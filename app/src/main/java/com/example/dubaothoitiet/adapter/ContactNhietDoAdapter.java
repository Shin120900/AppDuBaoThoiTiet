package com.example.dubaothoitiet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dubaothoitiet.R;
import com.example.dubaothoitiet.model.ContactNhietDo;


import java.util.List;

public class ContactNhietDoAdapter extends RecyclerView.Adapter<ContactNhietDoAdapter.ViewHolder> {

    List<ContactNhietDo> nhietDoList;

    public ContactNhietDoAdapter(List<ContactNhietDo> nhietDoList) {
        this.nhietDoList = nhietDoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_nhietdo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTimeCode.setText(nhietDoList.get(position).getTime());
        holder.tvNhietDoCode.setText(nhietDoList.get(position).getNhietdo()+ "°C");
        String icon = nhietDoList.get(position).getIcon();
        if(icon.equals("01d")){
            holder.tvIconCode.setBackgroundResource(R.drawable.sun);
        }else if(icon.equals("01n")){
            holder.tvIconCode.setBackgroundResource(R.drawable.moon);
        }else if(icon.equals("02d")){
            holder.tvIconCode.setBackgroundResource(R.drawable.cloudy);
        }else if(icon.equals("02n")){
            holder.tvIconCode.setBackgroundResource(R.drawable.cloudynight);
        }else if(icon.equals("03d") || icon.equals("03n") || icon.equals("04d") || icon.equals("04n")){
            holder.tvIconCode.setBackgroundResource(R.drawable.cloud);
        }else if(icon.equals("09d") || icon.equals("09n") || icon.equals("10d") || icon.equals("10n")){
            holder.tvIconCode.setBackgroundResource(R.drawable.rain);
        }else if(icon.equals("11d") || icon.equals("11n")){
            holder.tvIconCode.setBackgroundResource(R.drawable.storm);
        }

    }

    @Override
    public int getItemCount() {
        return nhietDoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTimeCode;
        TextView tvNhietDoCode;
        TextView tvIconCode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTimeCode = itemView.findViewById(R.id.tvTime);
            tvNhietDoCode = itemView.findViewById(R.id.tvNhietDoGio);
            tvIconCode = itemView.findViewById(R.id.tvIconGio);
        }
    }


}
