package com.example.dubaothoitiet.model;

public class Contact {
    private int id;
    private String cityName;
    private int nhietDo;
    private String description;
    private String icon_hn;
    private String icon_nm;
    private String icon_nk;
    private String nhietdo_hn;
    private String nhietdo_nm;
    private String nhietdo_nk;
    private String gio;
    private int nhietdo_cn;
    private int doam;
    private String apsuat;

    public Contact(int id, String cityName, int nhietDo, String description, String icon_hn, String icon_nm, String icon_nk, String nhietdo_hn, String nhietdo_nm, String nhietdo_nk, String gio, int nhietdo_cn, int doam, String apsuat) {
        this.id = id;
        this.cityName = cityName;
        this.nhietDo = nhietDo;
        this.description = description;
        this.icon_hn = icon_hn;
        this.icon_nm = icon_nm;
        this.icon_nk = icon_nk;
        this.nhietdo_hn = nhietdo_hn;
        this.nhietdo_nm = nhietdo_nm;
        this.nhietdo_nk = nhietdo_nk;
        this.gio = gio;
        this.nhietdo_cn = nhietdo_cn;
        this.doam = doam;
        this.apsuat = apsuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getNhietDo() {
        return nhietDo;
    }

    public void setNhietDo(int nhietDo) {
        this.nhietDo = nhietDo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon_hn() {
        return icon_hn;
    }

    public void setIcon_hn(String icon_hn) {
        this.icon_hn = icon_hn;
    }

    public String getIcon_nm() {
        return icon_nm;
    }

    public void setIcon_nm(String icon_nm) {
        this.icon_nm = icon_nm;
    }

    public String getIcon_nk() {
        return icon_nk;
    }

    public void setIcon_nk(String icon_nk) {
        this.icon_nk = icon_nk;
    }

    public String getNhietdo_hn() {
        return nhietdo_hn;
    }

    public void setNhietdo_hn(String nhietdo_hn) {
        this.nhietdo_hn = nhietdo_hn;
    }

    public String getNhietdo_nm() {
        return nhietdo_nm;
    }

    public void setNhietdo_nm(String nhietdo_nm) {
        this.nhietdo_nm = nhietdo_nm;
    }

    public String getNhietdo_nk() {
        return nhietdo_nk;
    }

    public void setNhietdo_nk(String nhietdo_nk) {
        this.nhietdo_nk = nhietdo_nk;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public int getNhietdo_cn() {
        return nhietdo_cn;
    }

    public void setNhietdo_cn(int nhietdo_cm) {
        this.nhietdo_cn = nhietdo_cm;
    }

    public int getDoam() {
        return doam;
    }

    public void setDoam(int doam) {
        this.doam = doam;
    }

    public String getApsuat() {
        return apsuat;
    }

    public void setApsuat(String apsuat) {
        this.apsuat = apsuat;
    }
}
