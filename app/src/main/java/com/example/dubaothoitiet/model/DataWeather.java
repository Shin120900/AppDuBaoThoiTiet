package com.example.dubaothoitiet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataWeather {
    @SerializedName("openWeatherJSon")
    @Expose
    private OpenWeatherJSon openWeatherJSon;

    public DataWeather() {
    }

    public OpenWeatherJSon getOpenWeatherJSon() {
        return openWeatherJSon;
    }

    public void setOpenWeatherJSon(OpenWeatherJSon openWeatherJSon) {
        this.openWeatherJSon = openWeatherJSon;
    }
}
