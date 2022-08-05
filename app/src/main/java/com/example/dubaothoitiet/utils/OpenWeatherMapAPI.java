package com.example.dubaothoitiet.utils;

import com.example.dubaothoitiet.model.City;
import com.example.dubaothoitiet.model.Clouds;
import com.example.dubaothoitiet.model.Coord;
import com.example.dubaothoitiet.model.ListJson;
import com.example.dubaothoitiet.model.Main;
import com.example.dubaothoitiet.model.OpenWeatherJSon;
import com.example.dubaothoitiet.model.Rain;
import com.example.dubaothoitiet.model.Snow;
import com.example.dubaothoitiet.model.Sys;
import com.example.dubaothoitiet.model.TinhThanh;
import com.example.dubaothoitiet.model.Weather;
import com.example.dubaothoitiet.model.Wind;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class OpenWeatherMapAPI{
    private static TinhThanh tinhThanh1 = new TinhThanh("Ha Noi","Hà Nội", "21.0245", "105.8412");

    public static TinhThanh getTinhThanh1() {
        return tinhThanh1;
    }

    public static void setTinhThanh1(TinhThanh tinhThanh1) {
        OpenWeatherMapAPI.tinhThanh1 = tinhThanh1;
    }

    public static OpenWeatherJSon prediction()
    {
        OpenWeatherJSon openWeatherJSon = null;
        String result = "";

        try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?lat="+tinhThanh1.getLat() +"&lon=" + tinhThanh1.getLon() + "&appid=c3cd8bcbe67c7bc1666299dd1cb581b9");
            URLConnection connection = url.openConnection();
            InputStream is = connection.getInputStream();

            int byteCharacter;
            while ((byteCharacter = is.read()) != -1){
                result += (char)byteCharacter;
            }
            try {
                JSONObject jsonObject = new JSONObject(result);

                long cod = jsonObject.getLong("cod");
                long message = jsonObject.getLong("message");
                long cnt = jsonObject.getLong("cnt");
                String list = jsonObject.getString("list");
                String city = jsonObject.getString("city");

                openWeatherJSon = new OpenWeatherJSon(cod, message, cnt, getCity(city));
                try {
                    JSONArray jsonArray = new JSONArray(list);
                    String rain = "";
                    String snow = "";
                    int d = jsonArray.length();
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject objectList = jsonArray.getJSONObject(i);
                        long dt = objectList.getLong("dt");
                        String main = objectList.getString("main");
                        String weather = objectList.getString("weather");
                        String clouds = objectList.getString("clouds");


                        if(objectList.has("rain")){
                            rain = objectList.getString("rain");
                        }

                        if (objectList.has("snow")){
                            snow = objectList.getString("snow");
                        }
                        String wind = objectList.getString("wind");
                        long visibility = objectList.getLong("visibility");
                        double pop = objectList.getDouble("pop");
                        String sys = objectList.getString("sys");
                        String dt_txt = objectList.getString("dt_txt");
                        if(rain.equals("") == false && snow.equals("") == false){
                            openWeatherJSon.setListJson(new ListJson(dt, getMain(main), getWeather(weather), getClouds(clouds),
                                    getRain(rain), getSnow(snow), getWind(wind), visibility, pop, getSys(sys), dt_txt));
                        }else if (rain.equals("") == false){
                            openWeatherJSon.setListJson(new ListJson(dt, getMain(main), getWeather(weather), getClouds(clouds),
                                    getRain(rain), getWind(wind), visibility, pop, getSys(sys), dt_txt));
                        }else if (snow.equals("") == false){
                            openWeatherJSon.setListJson(new ListJson(dt, getMain(main), getWeather(weather), getClouds(clouds),
                                    getSnow(snow), getWind(wind), visibility, pop, getSys(sys), dt_txt));
                        }else {
                            openWeatherJSon.setListJson(new ListJson(dt, getMain(main), getWeather(weather), getClouds(clouds),
                                    getWind(wind), visibility, pop, getSys(sys), dt_txt));
                        }



                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return openWeatherJSon;
    }


    private static City getCity(String city){
        City city1 = null;
        try {
            JSONObject object = new JSONObject(city);
            long id = object.getLong("id");
            //String name = object.getString("name");
            String name = tinhThanh1.getTen();
            String coord = object.getString("coord");
            String country = object.getString("country");
            long population = object.getLong("population");
            long timezone = object.getLong("timezone");
            long sunrise = object.getLong("sunrise");
            long sunset = object.getLong("sunset");
            city1 = new City(id, name, getCoord(coord), country, population, timezone, sunrise, sunset);




        } catch (JSONException e) {
            e.printStackTrace();
        }
        return city1;
    }

    private static Coord getCoord(String coord){
        Coord coord1 = null;
        try {
            JSONObject object = new JSONObject(coord);
            double lat = object.getDouble("lat");
            double lon = object.getDouble("lon");
            coord1 = new Coord(lat, lon);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  coord1;
    }

    private static Main getMain(String main){
        Main main1 = null;
        try {
            JSONObject object = new JSONObject(main);
            double temp = object.getDouble("temp");
            double feels_like = object.getDouble("feels_like");
            double temp_min = object.getDouble("temp_min");
            double temp_max = object.getDouble("temp_max");
            double pressure = object.getDouble("pressure");
            long sea_level = object.getLong("sea_level");
            long grnd_level = object.getLong("grnd_level");
            double humidity = object.getDouble("humidity");
            double temp_kf = object.getDouble("temp");
            main1 = new Main(temp, feels_like, temp_min, temp_max, pressure, sea_level, grnd_level, humidity, temp_kf);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return main1;
    }
    private static Weather getWeather(String weather){
        Weather weather1 = null;
        try {
            JSONArray jsonArray = new JSONArray(weather);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                long id = object.getLong("id");
                String main = object.getString("main");
                String description = object.getString("description");
                String icon = object.getString("icon");
                weather1 = new Weather(id, main, description, icon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weather1;
    }

    private static Clouds getClouds(String clouds){
        Clouds clouds1 = null;
        try {
            JSONObject object = new JSONObject(clouds);
            int all = object.getInt("all");
            clouds1 = new Clouds(all);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clouds1;
    }
    private static Rain getRain(String rain){
        Rain rain1 = null;
        try {
            JSONObject object = new JSONObject(rain);
            double in3h = object.getDouble("3h");
            rain1 = new Rain(in3h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rain1;
    }

    private static Snow getSnow(String snow){
        Snow snow1 = null;
        try {
            JSONObject object = new JSONObject(snow);
            double in3h = object.getDouble("3h");
            snow1 = new Snow(in3h);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return snow1;
    }
    private static Wind getWind(String wind){
        Wind wind1 = null;
        try {
            JSONObject object = new JSONObject(wind);
            double speed = object.getDouble("speed");
            double deg = object.getDouble("deg");
            double gust = object.getDouble("gust");
            wind1 = new Wind(speed, deg, gust);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return wind1;
    }

    private static Sys getSys(String sys){
        Sys sys1 = null;
        try {
            JSONObject object = new JSONObject(sys);
            String pod = object.getString("pod");
            sys1 = new Sys(pod);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sys1;
    }


}
