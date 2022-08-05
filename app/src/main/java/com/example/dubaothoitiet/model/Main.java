package com.example.dubaothoitiet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("feels_like")
    @Expose
    private double feels_like;
    @SerializedName("temp_min")
    @Expose
    private double temp_min;
    @SerializedName("temp_max")
    @Expose
    private double temp_max;
    @SerializedName("pressure")
    @Expose
    private double pressure;
    @SerializedName("sea_level")
    @Expose
    private long sea_level;
    @SerializedName("grnd_level")
    @Expose
    private long grnd_level;
    @SerializedName("humidity")
    @Expose
    private double humidity;
    @SerializedName("temp_kf")
    @Expose
    private double temp_kf;

    public Main(double temp,
                double feels_like,
                double temp_min,
                double temp_max,
                double pressure,
                long sea_level,
                long grnd_level,
                double humidity,
                double temp_kf) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.humidity = humidity;
        this.temp_kf = temp_kf;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public long getSea_level() {
        return sea_level;
    }

    public void setSea_level(long sea_level) {
        this.sea_level = sea_level;
    }

    public long getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(long grnd_level) {
        this.grnd_level = grnd_level;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(double temp_kf) {
        this.temp_kf = temp_kf;
    }
}
