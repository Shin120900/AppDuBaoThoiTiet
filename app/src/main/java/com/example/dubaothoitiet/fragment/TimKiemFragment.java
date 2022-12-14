package com.example.dubaothoitiet.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dubaothoitiet.R;
import com.example.dubaothoitiet.adapter.TinhThanhAdapter;
import com.example.dubaothoitiet.databinding.FragmentTimkiemBinding;
import com.example.dubaothoitiet.event.IClickTinhThanh;
import com.example.dubaothoitiet.model.TinhThanh;
import com.example.dubaothoitiet.utils.OpenWeatherMapAPI;

import java.util.ArrayList;
import java.util.List;

public class TimKiemFragment extends Fragment {
    FragmentTimkiemBinding binding;



    public static TimKiemFragment newInstance() {

        Bundle args = new Bundle();

        TimKiemFragment fragment = new TimKiemFragment();
        fragment.setArguments(args);
        return fragment;
    }






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_timkiem, container, false);
        binding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = HomeFragMent.newInstance(false);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

        List<TinhThanh> tinhThanhList = new ArrayList<>();
        tinhThanhList.add(new TinhThanh("Ha Noi","H?? N???i", "21.0245", "105.8412"));
        tinhThanhList.add(new TinhThanh("Ho Chi Minh","H??? Ch?? Minh", "10.8333", "106.6667"));
        tinhThanhList.add(new TinhThanh("An Giang", "An Giang", "10.5461", "105.209"));
        tinhThanhList.add(new TinhThanh("Bac Lieu", "B???c Li??u", "9.2772", "105.7672"));
        tinhThanhList.add(new TinhThanh("Bac Giang", "B???c Giang", "21.2895", "106.1940"));
        tinhThanhList.add(new TinhThanh("Bac Kan", "B???c K???n", "22.1347", "105.8471"));
        tinhThanhList.add(new TinhThanh("Bac Ninh", "B???c Ninh", "21.1788", "106.0735"));
        tinhThanhList.add(new TinhThanh("Ben Tre" , "B???n Tre", "10.2421", "106.3727"));
        tinhThanhList.add(new TinhThanh("Binh Duong", "B??nh D????ng", "11.1993", "106.6922"));
        tinhThanhList.add(new TinhThanh("Binh Dinh", "B??nh ?????nh", "14.1341", "108.9164"));
        tinhThanhList.add(new TinhThanh("Binh Phuoc", "B??nh Ph?????c", "11.7446", "106.8940"));
        tinhThanhList.add(new TinhThanh("Binh Thuan", "B??nh Thu???n", "11.0648", "107.8856"));
        tinhThanhList.add(new TinhThanh("Cao Bang", "Cao B???ng", "22.6677", "106.2503"));
        tinhThanhList.add(new TinhThanh("Ca Mau", "C?? Mau", "9.1753", "105.2012"));
        tinhThanhList.add(new TinhThanh("Can Tho", "C???n Th??", "10.1155", "105.5610"));
        tinhThanhList.add(new TinhThanh("Hai Phong","H???i Ph??ng", "20.8476", "106.6925"));
        tinhThanhList.add(new TinhThanh("Da Nang", "???? N???ng", "16.0783", "108.0650"));
        tinhThanhList.add(new TinhThanh("Gia Lai", "Gia Lai", "13.8300", "108.2831"));
        tinhThanhList.add(new TinhThanh("Hoa Binh", "H??a B??nh", "20.6751", "105.4163"));
        tinhThanhList.add(new TinhThanh("Ha Giang", "H?? Giang", "22.8037", "105.0114"));
        tinhThanhList.add(new TinhThanh("Ha Nam", "H?? Nam", "20.5459", "105.9693"));
        tinhThanhList.add(new TinhThanh("Ha Tinh", "H?? T??nh", "18.3615", "105.9040"));
        tinhThanhList.add(new TinhThanh("Hung Yen", "H??ng Y??n", "20.6549", "106.0617"));
        tinhThanhList.add(new TinhThanh("Hai Duong", "H???i D????ng", "20.9347", "106.3160"));
        tinhThanhList.add(new TinhThanh("Hau Giang","H???u Giang", "9.7885", "105.6196"));
        tinhThanhList.add(new TinhThanh("Dien Bien", "??i???n Bi??n", "21.7832", "103.1855"));
        tinhThanhList.add(new TinhThanh("Dak Lak", "?????k L???k", "12.8670", "108.2784"));
        tinhThanhList.add(new TinhThanh("Dak Nong", "?????k N??ng", "12.1875", "107.7072"));
        tinhThanhList.add(new TinhThanh("Dong Nai", "?????ng Nai", "11.034532", "107.2220"));
        tinhThanhList.add(new TinhThanh("Dong Thap" , "?????ng Th??p", "10.6436", "105.6305"));
        tinhThanhList.add(new TinhThanh("Khanh Hoa", "Kh??nh H??a", "12.3123", "108.9839"));
        tinhThanhList.add(new TinhThanh("Kien Giang", "Ki??n Giang", "10.0490", "105.1159"));
        tinhThanhList.add(new TinhThanh("Kon Tum", "Kon Tum", "14.3447", "107.9699"));
        tinhThanhList.add(new TinhThanh("Lai Chau", "Lai Ch??u", "22.3996", "103.4417"));
        tinhThanhList.add(new TinhThanh("Long An", "Long An", "10.7209", "106.1128"));
        tinhThanhList.add(new TinhThanh("Lao Cai", "L??o Cai", "22.4184", "103.9939"));
        tinhThanhList.add(new TinhThanh("Lam Dong", "L??m ?????ng", "11.6430", "108.0360"));
        tinhThanhList.add(new TinhThanh("Lang Son", "L???ng S??n", "21.8542", "106.7415"));
        tinhThanhList.add(new TinhThanh("Nam Dinh", "Nam ?????nh", "20.4241", "106.1706"));
        tinhThanhList.add(new TinhThanh("Nghe An", "Ngh??? An", "19.3005", "105.0138"));
        tinhThanhList.add(new TinhThanh("Ninh Binh", "Ninh B??nh", "20.2486", "105.9709"));
        tinhThanhList.add(new TinhThanh("Ninh Thuan", "Ninh Thu???n", "11.7135", "108.9113"));
        tinhThanhList.add(new TinhThanh("Phu Tho", "Ph?? Th???", "21.4151", "105.2306"));
        tinhThanhList.add(new TinhThanh("Phu Yen", "Ph?? Y??n", "13.1625", "109.0815"));
        tinhThanhList.add(new TinhThanh("Quang Binh", "Qu???ng B??nh", "17.5190", "106.3986"));
        tinhThanhList.add(new TinhThanh("Quang Nam", "Qu???ng Nam", "15.6295", "107.9719"));
        tinhThanhList.add(new TinhThanh("Quang Ngai", "Qu???ng Ng??i", "15.1507", "108.8375"));
        tinhThanhList.add(new TinhThanh("Quang Ninh", "Qu???ng Ninh", "21.1782", "107.1968"));
        tinhThanhList.add(new TinhThanh("Quang Tri", "Qu???ng Tr???", "16.6741", "107.1577"));
        tinhThanhList.add(new TinhThanh("Soc Trang", "S??c Tr??ng", "9.6053", "105.9738"));
        tinhThanhList.add(new TinhThanh("Son La", "S??n La", "21.3440", "103.9012"));
        tinhThanhList.add(new TinhThanh("Thanh Hoa", "Thanh H??a", "20.0583", "105.4343"));
        tinhThanhList.add(new TinhThanh("Thai Binh", "Th??i B??nh", "20.4513", "106.3398"));
        tinhThanhList.add(new TinhThanh("Thai Nguyen", "Th??i Nguy??n", "21.5659", "105.8016"));
        tinhThanhList.add(new TinhThanh("Tien Giang", "Ti???n Giang", "10.4285", "106.2789"));
        tinhThanhList.add(new TinhThanh("Tra Vinh" , "Tr?? Vinh", "9.9482", "106.3336"));
        tinhThanhList.add(new TinhThanh("Tuyen Quang", "Tuy??n Quang", "21.7830", "105.2242"));
        tinhThanhList.add(new TinhThanh("Tay Ninh", "T??y Ninh", "11.3503", "106.1238"));
        tinhThanhList.add(new TinhThanh("Vinh Long", "V??nh Long", "10.2529", "105.9341"));
        tinhThanhList.add(new TinhThanh("Vinh Phuc", "V??nh Ph??c", "21.3782", "105.5630"));
        tinhThanhList.add(new TinhThanh("Yen Bai", "Y??n B??i", "21.7095", "104.8997"));
        tinhThanhList.add(new TinhThanh("Thua Thien Hue", "Th???a Thi??n Hu???", "16.3804", "107.4665"));
        tinhThanhList.add(new TinhThanh("Ba Ria Vung Tau", "B?? R???a - V??ng T??u", "10.5101", "107.1738"));



        TinhThanhAdapter tinhThanhAdapter = new TinhThanhAdapter(tinhThanhList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 4, RecyclerView.VERTICAL, false);
        binding.rcListThanhPho.setAdapter(tinhThanhAdapter);
        binding.rcListThanhPho.setLayoutManager(layoutManager);
        binding.svTimKiem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tinhThanhAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                tinhThanhAdapter.filter(newText);
                return true;
            }
        });

        tinhThanhAdapter.setiClickTinhThanh(new IClickTinhThanh() {
            @Override
            public void clickTinhThanh(TinhThanh tinhThanh) {
                OpenWeatherMapAPI.setTinhThanh1(tinhThanh);
                Fragment fragment = HomeFragMent.newInstance(false);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();


            }
        });



        return binding.getRoot();
    }


}
