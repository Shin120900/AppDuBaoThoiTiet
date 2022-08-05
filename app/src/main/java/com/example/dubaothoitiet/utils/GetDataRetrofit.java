package com.example.dubaothoitiet.utils;

import com.example.dubaothoitiet.event.IHomeWeather;
import com.example.dubaothoitiet.model.DataWeather;
import com.example.dubaothoitiet.model.ListJson;
import com.example.dubaothoitiet.model.OpenWeatherJSon;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetDataRetrofit  {
    Call<DataWeather> call;
    DataWeather dataWeather;
    OpenWeatherJSon openWeatherJSon;
    List<ListJson> listJsonList;
    IHomeWeather iHomeWeather;

    public void getInstance(){


        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherService.WeatherAPI weatherAPI = retrofit.create(WeatherService.WeatherAPI.class);

            //call = weatherAPI.getDataWeather("c3cd8bcbe67c7bc1666299dd1cb581b9");
            call.enqueue(new Callback<DataWeather>() {
                @Override
                public void onResponse(Call<DataWeather> call, Response<DataWeather> response) {

                    dataWeather = response.body();
                    openWeatherJSon = dataWeather.getOpenWeatherJSon();
                    iHomeWeather.getData(openWeatherJSon);
                }

                @Override
                public void onFailure(Call<DataWeather> call, Throwable t) {

                }
            });


    }


}
