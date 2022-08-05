package com.example.dubaothoitiet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {
    @SerializedName("3h")
    @Expose
    private double in3h;

    public Rain(double in3h) {
        this.in3h = in3h;
    }

    public double getIn3h() {
        return in3h;
    }

    public void setIn3h(double in3h) {
        this.in3h = in3h;
    }
}
