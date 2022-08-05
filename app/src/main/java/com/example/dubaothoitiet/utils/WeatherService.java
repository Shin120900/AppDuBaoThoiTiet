package com.example.dubaothoitiet.utils;

import com.example.dubaothoitiet.model.DataWeather;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WeatherService {
    public interface WeatherAPI{
        @GET("data/2.5/forecast?lat=21.0245&lon=105.8412")
        Call<DataWeather> getDataWeather(
                @Query("appid") String apiKey);
    }
}
