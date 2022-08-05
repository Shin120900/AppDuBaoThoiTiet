package com.example.dubaothoitiet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.dubaothoitiet.databinding.ActivityMainBinding;
import com.example.dubaothoitiet.event.IGetLocation;
import com.example.dubaothoitiet.fragment.HomeFragMent;
import com.example.dubaothoitiet.fragment.TimKiemFragment;
import com.example.dubaothoitiet.model.TinhThanh;

public class MainActivity extends AppCompatActivity implements LocationListener, IGetLocation {

    ActivityMainBinding binding;

    LocationManager locationManager;

    TinhThanh viTri;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ac = getSupportActionBar();
        ac.hide();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getFragment(HomeFragMent.newInstance(!isNetworkConnected()));


    }



    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
// There are no active networks.
            return false;
        } else
            return true;


    }

    private void getLocation(){
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 15000, 500, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        double lat = location.getLatitude();
        double lon = location.getLongitude();
        viTri = new TinhThanh("ViTri", "Vị trí hiện tại", lat+"", lon+"");
    }

    @Override
    public TinhThanh getLoction() {
        getLocation();
        return viTri;
    }
}