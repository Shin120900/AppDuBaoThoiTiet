package com.example.dubaothoitiet.event;

import com.example.dubaothoitiet.model.OpenWeatherJSon;

public interface IGetJSon {
    void getSuccessful(OpenWeatherJSon openWeatherJSon);
    void onMessenger (String mes);
}
