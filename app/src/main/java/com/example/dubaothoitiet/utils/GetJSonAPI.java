package com.example.dubaothoitiet.utils;

import android.os.AsyncTask;

import com.example.dubaothoitiet.event.IGetJSon;
import com.example.dubaothoitiet.event.IGetLocation;
import com.example.dubaothoitiet.model.OpenWeatherJSon;


public class GetJSonAPI extends AsyncTask<Void, Void, OpenWeatherJSon> {
    IGetJSon iGetJSon;
    IGetLocation iGetLocation;

    public GetJSonAPI(IGetJSon iGetJSon) {
        this.iGetJSon = iGetJSon;

    }

    public void setiGetLocation(IGetLocation iGetLocation) {
        this.iGetLocation = iGetLocation;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected OpenWeatherJSon doInBackground(Void... params) {

        OpenWeatherJSon openWeatherJSon = null;
        try {

            //OpenWeatherMapAPI.setTinhThanh1(iGetLocation.getLoction());
            openWeatherJSon = OpenWeatherMapAPI.prediction();




        } catch (Exception e) {
            e.printStackTrace();
        }
        return openWeatherJSon;
    }

    @Override
    protected void onPostExecute(OpenWeatherJSon openWeatherJSon) {
        this.iGetJSon.getSuccessful(openWeatherJSon);




    }
}

