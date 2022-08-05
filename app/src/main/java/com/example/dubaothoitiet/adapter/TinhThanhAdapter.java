package com.example.dubaothoitiet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dubaothoitiet.R;
import com.example.dubaothoitiet.event.IClickTinhThanh;
import com.example.dubaothoitiet.model.TinhThanh;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TinhThanhAdapter extends RecyclerView.Adapter<TinhThanhAdapter.ViewHolder> {
    List<TinhThanh> tinhThanhList;
    List<TinhThanh> list = new ArrayList<>();
    IClickTinhThanh iClickTinhThanh;

    public TinhThanhAdapter(List<TinhThanh> tinhThanhList) {
        this.tinhThanhList = tinhThanhList;
        if(list.size()==0){
            list.addAll(tinhThanhList);
        }
    }

    public void setiClickTinhThanh(IClickTinhThanh iClickTinhThanh) {
        this.iClickTinhThanh = iClickTinhThanh;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_tinh_thanhpho, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTenTinh.setText(tinhThanhList.get(position).getTen());
        holder.tvTenTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickTinhThanh.clickTinhThanh(tinhThanhList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return tinhThanhList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenTinh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenTinh = itemView.findViewById(R.id.tvTenTinh);
        }
    }

    public void filter(String text) {
        String nfdNormalizedString = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        text = pattern.matcher(nfdNormalizedString).replaceAll("").toLowerCase().replaceAll("đ", "d");;
        tinhThanhList.clear();
        if(text.isEmpty()){
            tinhThanhList.addAll(list);
        } else {
            text = text.toLowerCase();
            for (TinhThanh tinhThanh : list) {
                if (tinhThanh.getName().toLowerCase().contains(text)) {
                    tinhThanhList.add(tinhThanh);
                }
            }
        }

        notifyDataSetChanged();
    }
}
