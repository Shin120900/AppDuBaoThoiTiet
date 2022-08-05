package com.example.dubaothoitiet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OpenWeatherJSon implements Serializable {
    @SerializedName("cod")
    @Expose
    private long cod;
    @SerializedName("message")
    @Expose
    private long message;
    @SerializedName("cnt")
    @Expose
    private long cnt;
    @SerializedName("list")
    @Expose
    private List<ListJson> list =  new ArrayList<ListJson>();
    @SerializedName("city")
    @Expose
    private City city;

    public OpenWeatherJSon(long cod, long message, long cnt, City city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;

        this.city = city;
    }

    public long getCod() {

        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public long getMessage() {
        return message;
    }

    public void setMessage(long message) {
        this.message = message;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public List<ListJson> getList() {
        return list;
    }

    public void setList(List<ListJson> list) {
        this.list = list;
    }

    public ListJson getListJson(int i){
        return list.get(i);
    }

    public void setListJson(ListJson listJson){
        list.add(listJson);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}
