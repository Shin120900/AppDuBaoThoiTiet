package com.example.dubaothoitiet.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.dubaothoitiet.R;
import com.example.dubaothoitiet.SQLHelper;
import com.example.dubaothoitiet.adapter.ContactNhietDoAdapter;
import com.example.dubaothoitiet.databinding.FragmentHomeBinding;
import com.example.dubaothoitiet.event.IGetJSon;
import com.example.dubaothoitiet.event.IHomeWeather;
import com.example.dubaothoitiet.event.ISql;
import com.example.dubaothoitiet.model.Contact;
import com.example.dubaothoitiet.model.ContactNhietDo;
import com.example.dubaothoitiet.model.OpenWeatherJSon;
import com.example.dubaothoitiet.presenter.ContactPresenter;
import com.example.dubaothoitiet.utils.GetJSonAPI;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeFragMent extends Fragment implements IGetJSon, IHomeWeather, ISql {
    NumberFormat format = new DecimalFormat("#0");
    FragmentHomeBinding binding;
    ContactPresenter presenter;
    SQLHelper sqlHelper;
    List<ContactNhietDo> contactNhietDoList;
    Contact contact;
    boolean ischeck;


    public static HomeFragMent newInstance(boolean ischeck) {

        Bundle args = new Bundle();
        args.putBoolean("ischeck", ischeck);
        HomeFragMent fragment = new HomeFragMent();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        presenter = new ContactPresenter(this, getContext());
        ischeck = getArguments().getBoolean("ischeck");
        sqlHelper = new SQLHelper(getContext());


        if (ischeck) {
            displayAlertDialog();
            contact = sqlHelper.getContactSQL();
            contactNhietDoList = sqlHelper.getAllContactNhietDo();
            View(contact, contactNhietDoList);

        } else {
            new GetJSonAPI(this).execute();
        }

        binding.tvTimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = TimKiemFragment.newInstance();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });


        return binding.getRoot();
    }


    public void View(Contact contact, List<ContactNhietDo> contactNhietDoList) {
        if (contactNhietDoList.get(1).getTime().equals("09:00") || contactNhietDoList.get(1).getTime().equals("12:00") || contactNhietDoList.get(1).getTime().equals("15:00") || contactNhietDoList.get(1).getTime().equals("18:00")){
            binding.linearhome.setBackgroundResource(R.drawable.anhbuoisang);
        }else {
            binding.linearhome.setBackgroundResource(R.drawable.anhbuoitoi);
        }
        binding.tvNameCity.setText(contact.getCityName());
        binding.tvNhietDo.setText(contact.getNhietDo() + "");
        binding.tvMoTa.setText(contact.getDescription());
        String iconHN = contact.getIcon_hn();
        if (iconHN.equals("01d")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.sun);
        } else if (iconHN.equals("01n")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.moon);
        } else if (iconHN.equals("02d")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.cloudy);
        } else if (iconHN.equals("02n")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.cloudynight);
        } else if (iconHN.equals("03d") || iconHN.equals("03n") || iconHN.equals("04d") || iconHN.equals("04n")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.cloud);
        } else if (iconHN.equals("09d") || iconHN.equals("09n") || iconHN.equals("10d") || iconHN.equals("10n")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.rain);
        } else if (iconHN.equals("11d") || iconHN.equals("11n")) {
            binding.tvIconHN.setBackgroundResource(R.drawable.storm);
        }

        String iconNM = contact.getIcon_nm();
        if (iconNM.equals("01d")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.sun);
        } else if (iconNM.equals("01n")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.moon);
        } else if (iconNM.equals("02d")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.cloudy);
        } else if (iconNM.equals("02n")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.cloudynight);
        } else if (iconNM.equals("03d") || iconNM.equals("03n") || iconNM.equals("04d") || iconNM.equals("04n")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.cloud);
        } else if (iconNM.equals("09d") || iconNM.equals("09n") || iconNM.equals("10d") || iconNM.equals("10n")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.rain);
        } else if (iconNM.equals("11d") || iconNM.equals("11n")) {
            binding.tvIconNM.setBackgroundResource(R.drawable.storm);
        }

        String iconNK = contact.getIcon_nk();
        if (iconNK.equals("01d")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.sun);
        } else if (iconNK.equals("01n")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.moon);
        } else if (iconNK.equals("02d")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.cloudy);
        } else if (iconNK.equals("02n")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.cloudynight);
        } else if (iconNK.equals("03d") || iconNK.equals("03n") || iconNK.equals("04d") || iconNK.equals("04n")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.cloud);
        } else if (iconNK.equals("09d") || iconNK.equals("09n") || iconNK.equals("10d") || iconNK.equals("10n")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.rain);
        } else if (iconNK.equals("11d") || iconNK.equals("11n")) {
            binding.tvIconNK.setBackgroundResource(R.drawable.storm);
        }
        binding.tvNdCnVaTnHomNay.setText(contact.getNhietdo_hn());
        binding.tvNdCnVaTnNgayMai.setText(contact.getNhietdo_nm());
        binding.tvNdCnVaTnNgayKia.setText(contact.getNhietdo_nk());

        ContactNhietDoAdapter adapter = new ContactNhietDoAdapter(contactNhietDoList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        binding.rcListView.setAdapter(adapter);
        binding.rcListView.setLayoutManager(layoutManager);

        XAxis xAxis = binding.lcBieuDo.getXAxis();
        YAxis yAxisLeft = binding.lcBieuDo.getAxisLeft();
        YAxis yAxisRight = binding.lcBieuDo.getAxisRight();
        xAxis.setValueFormatter(new MyXAxisFormatter());
        yAxisLeft.setValueFormatter(new MyYAxisFormatter());
        yAxisRight.setValueFormatter(new MyYAxisFormatter());

        Description description = new Description();
        description.setText("");
        binding.lcBieuDo.setDescription(description);


        LineDataSet lineDataSet = new LineDataSet(dataValues1(contactNhietDoList), "Nhiệt độ");
        lineDataSet.setLineWidth(5);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        LineData data = new LineData(dataSets);
        binding.lcBieuDo.setData(data);
        binding.lcBieuDo.invalidate();

        binding.tvGio.setText(contact.getGio() + "m/s");
        binding.tvNdCamNhan.setText(contact.getNhietdo_cn() + "°");
        binding.tvDoam.setText(contact.getDoam() + "%");
        binding.tvApSuat.setText(contact.getApsuat() + "hPa");


    }

    private ArrayList<Entry> dataValues1(List<ContactNhietDo> list) {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        for (int i = 0; i < list.size(); i++) {
            dataVals.add(new Entry(i, list.get(i).getNhietdo()));
        }


        return dataVals;
    }

    private class MyXAxisFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {


            return "";
        }
    }

    private class MyYAxisFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {
            return "";
        }
    }


    @Override
    public void onSuccessFil() {

    }

    @Override
    public void onMessenger(String mes) {

    }


    @Override
    public void getData(OpenWeatherJSon openWeatherJSon) {
        /*binding.tvNameCity.setText(openWeatherJSon.getCity().getName());
        binding.tvNhietDo.setText(format.format(openWeatherJSon.getListJson(1).getMain().getTemp() - 273.15) + "");
        binding.tvGio.setText(openWeatherJSon.getListJson(1).getWind().getSpeed()+" m/s");
        binding.tvNdCamNhan.setText(format.format(openWeatherJSon.getListJson(1).getMain().getFeels_like() - 273.15) + "°C");
        binding.tvDoam.setText(format.format(openWeatherJSon.getListJson(1).getMain().getHumidity())+ "%");
        binding.tvApSuat.setText(openWeatherJSon.getListJson(1).getMain().getGrnd_level()+ "hPa");





        List<ContactNhietDo> nhietDoList = new ArrayList<>();
        String thangBG = openWeatherJSon.getListJson(1).getDt_txt().substring(5,7);
        String ngayBG = openWeatherJSon.getListJson(1).getDt_txt().substring(8,10);
        String timeBG = openWeatherJSon.getListJson(1).getDt_txt().substring(11,16);
        int nhietdoBG = (int) (openWeatherJSon.getListJson(1).getMain().getTemp() - 273.15);
        String iconBG = openWeatherJSon.getListJson(1).getWeather().getIcon();
        int ndCaoNhat = (int) (openWeatherJSon.getListJson(1).getMain().getTemp_max() - 273.15);
        int ndThapNhat = (int) (openWeatherJSon.getListJson(1).getMain().getTemp_min() - 273.15);
        binding.tvNdCnVaTnHomNay.setText(ndCaoNhat+"° / "+ndThapNhat+"°");
        nhietDoList.add(new ContactNhietDo("Bây giờ", nhietdoBG, iconBG));
        int i = 1;
        String time;
        int j = 0;
        do {
            i++;
            String thang = openWeatherJSon.getListJson(i).getDt_txt().substring(5,7);
            String ngay = openWeatherJSon.getListJson(i).getDt_txt().substring(8,10);
            time = openWeatherJSon.getListJson(i).getDt_txt().substring(11,16);
            int nhietdo = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            String icon = openWeatherJSon.getListJson(i).getWeather().getIcon();
            if ((ngayBG.equals(ngay) == false || thangBG.equals(thang) == false) && (time.equals("00:00") == true)){
                String timeNM = ngay + "/"+ thang;
                nhietDoList.add(new ContactNhietDo(timeNM, nhietdo, icon));
                j = i;
            }else {
                nhietDoList.add(new ContactNhietDo(time, nhietdo, icon));
            }
        }while (i < 9);

        int ndCaoNhatNgayMai = (int) (openWeatherJSon.getListJson(j).getMain().getTemp_max() - 273.15);
        int ndThapNhatNgayMai = (int) (openWeatherJSon.getListJson(j).getMain().getTemp_min() - 273.15);
        binding.tvNdCnVaTnNgayMai.setText(ndCaoNhatNgayMai+"° / "+ndThapNhatNgayMai+"°");

        int ndCaoNhatNgayKia = (int) (openWeatherJSon.getListJson(j+9).getMain().getTemp_max() - 273.15);
        int ndThapNhatNgayKia = (int) (openWeatherJSon.getListJson(j+9).getMain().getTemp_min() - 273.15);
        binding.tvNdCnVaTnNgayKia.setText(ndCaoNhatNgayKia+"° / "+ndThapNhatNgayKia+"°");

        ContactNhietDoAdapter adapter = new ContactNhietDoAdapter(nhietDoList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        binding.rcListView.setAdapter(adapter);
        binding.rcListView.setLayoutManager(layoutManager);*/
    }

    public void displayAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        TextView tvCaiDatCode = alertLayout.findViewById(R.id.tvCaiDat);
        TextView tvOkCode = alertLayout.findViewById(R.id.tvOk);

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        alert.setTitle("");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        AlertDialog dialog = alert.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        tvCaiDatCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        tvOkCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }


    @Override
    public void getSuccessful(OpenWeatherJSon openWeatherJSon) {
        String nameCity = openWeatherJSon.getCity().getName();
        int nhietdo = (int) (openWeatherJSon.getListJson(1).getMain().getTemp() - 273.15);
        String icon_hn = openWeatherJSon.getListJson(1).getWeather().getIcon();
        String icon_nm = openWeatherJSon.getListJson(9).getWeather().getIcon();
        String icon_nk = openWeatherJSon.getListJson(17).getWeather().getIcon();
        String nhietdo_hn = "";
        String nhietdo_nm = "";
        String nhietdo_nk = "";
        String gio = String.valueOf(openWeatherJSon.getListJson(1).getWind().getSpeed());
        int nhietdo_cm = (int) (openWeatherJSon.getListJson(1).getMain().getFeels_like() - 273.15);
        int doam = (int) openWeatherJSon.getListJson(1).getMain().getHumidity();
        String apsuat = String.valueOf(openWeatherJSon.getListJson(1).getMain().getGrnd_level());


        List<ContactNhietDo> nhietDoList = new ArrayList<>();
        String thangBG = openWeatherJSon.getListJson(1).getDt_txt().substring(5, 7);
        String ngayBG = openWeatherJSon.getListJson(1).getDt_txt().substring(8, 10);
        String timeBG = openWeatherJSon.getListJson(1).getDt_txt().substring(11, 16);
        int nhietdoBG = (int) (openWeatherJSon.getListJson(1).getMain().getTemp() - 273.15);
        String description = openWeatherJSon.getListJson(1).getWeather().getDescription();
        String iconBG = openWeatherJSon.getListJson(1).getWeather().getIcon();
        int ndCaoNhat = (int) (openWeatherJSon.getListJson(1).getMain().getTemp() - 273.15);
        int ndThapNhat = (int) (openWeatherJSon.getListJson(1).getMain().getTemp() - 273.15);
        String ngayMai;
        int dem = 0;
        if (timeBG.equals("00:00")) {
            dem = 1;
        } else if (timeBG.equals("03:00")) {
            dem = 2;
        } else if (timeBG.equals("06:00")) {
            dem = 3;
        } else if (timeBG.equals("09:00")) {
            dem = 4;
        } else if (timeBG.equals("12:00")) {
            dem = 5;
        } else if (timeBG.equals("15:00")) {
            dem = 6;
        } else if (timeBG.equals("18:00")) {
            dem = 7;
        } else if (timeBG.equals("21:00")) {
            dem = 8;
        }
        int a = 1;
        for (int i = 1; i < 10 - dem; i++) {

            if (dem > 6) {
                if (ndCaoNhat < (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15)) {
                    ndCaoNhat = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
                }
            }
            if (ndThapNhat > (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15)) {
                ndThapNhat = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            }
            a = i;

        }
        if (dem > 6) {
            nhietdo_hn = "_ _° / " + ndThapNhat + "°";
        } else {
            nhietdo_hn = ndCaoNhat + "° / " + ndThapNhat + "°";
        }
        int ndCaoNhatNgayMai = (int) (openWeatherJSon.getListJson(a).getMain().getTemp() - 273.15);
        int ndThapNhatNgayMai = (int) (openWeatherJSon.getListJson(a).getMain().getTemp() - 273.15);
        for (int i = a; i < a + 8; i++) {


            if (ndCaoNhatNgayMai < (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15)) {
                ndCaoNhatNgayMai = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            }

            if (ndThapNhatNgayMai > (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15)) {
                ndThapNhatNgayMai = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            }


        }
        nhietdo_nm = ndCaoNhatNgayMai + "° / " + ndThapNhatNgayMai + "°";
        int ndCaoNhatNgayKia = (int) (openWeatherJSon.getListJson(a + 8).getMain().getTemp_max() - 273.15);
        int ndThapNhatNgayKia = (int) (openWeatherJSon.getListJson(a + 8).getMain().getTemp_min() - 273.15);

        for (int i = a + 8; i < a + 16; i++) {


            if (ndCaoNhatNgayKia < (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15)) {
                ndCaoNhatNgayKia = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            }

            if (ndThapNhatNgayKia > (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15)) {
                ndThapNhatNgayKia = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            }

        }
        nhietdo_nk = ndCaoNhatNgayKia + "° / " + ndThapNhatNgayKia + "°";


        nhietDoList.add(new ContactNhietDo(1, "Bây giờ", nhietdoBG, iconBG));
        int i = 1;
        String time;
        int j = 0;
        do {
            i++;
            String thang = openWeatherJSon.getListJson(i).getDt_txt().substring(5, 7);
            String ngay = openWeatherJSon.getListJson(i).getDt_txt().substring(8, 10);
            time = openWeatherJSon.getListJson(i).getDt_txt().substring(11, 16);
            int nhietdoGio = (int) (openWeatherJSon.getListJson(i).getMain().getTemp() - 273.15);
            String icon = openWeatherJSon.getListJson(i).getWeather().getIcon();
            if ((ngayBG.equals(ngay) == false || thangBG.equals(thang) == false) && (time.equals("00:00") == true)) {
                String timeNM = ngay + "/" + thang;
                nhietDoList.add(new ContactNhietDo(i, timeNM, nhietdoGio, icon));
                j = i;
            } else {
                nhietDoList.add(new ContactNhietDo(i, time, nhietdoGio, icon));
            }
        } while (i < 9);

        presenter.onEditContact(1, nameCity, nhietdo, description, icon_hn, icon_nm, icon_nk, nhietdo_hn, nhietdo_nm, nhietdo_nk, gio, nhietdo_cm, doam, apsuat);
        for (ContactNhietDo con : nhietDoList) {
            presenter.onEditContactNhietDo(con.getId(), con.getTime(), con.getNhietdo(), con.getIcon());
        }

        contact = sqlHelper.getContactSQL();
        contactNhietDoList = sqlHelper.getAllContactNhietDo();
        View(contact, contactNhietDoList);


    }
}



