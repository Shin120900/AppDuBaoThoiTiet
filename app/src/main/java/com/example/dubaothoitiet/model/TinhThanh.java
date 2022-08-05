package com.example.dubaothoitiet.model;

public class TinhThanh {
    private String name;
    private String ten;
    private String lat;
    private String lon;

    public TinhThanh(String name, String ten, String lat, String lon) {
        this.name = name;
        this.ten = ten;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
