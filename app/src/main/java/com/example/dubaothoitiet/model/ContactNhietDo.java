package com.example.dubaothoitiet.model;

public class ContactNhietDo {

    private String time;
    private int nhietdo;
    private String icon;
    private int id;


    public ContactNhietDo( int id, String time, int nhietdo, String icon) {
        this.time = time;
        this.nhietdo = nhietdo;
        this.icon = icon;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNhietdo() {
        return nhietdo;
    }

    public void setNhietdo(int nhietdo) {
        this.nhietdo = nhietdo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
