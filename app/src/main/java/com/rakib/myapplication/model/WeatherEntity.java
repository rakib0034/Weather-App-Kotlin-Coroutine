package com.rakib.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherEntity {
    @SerializedName("weather")
    public ArrayList<Weather> weather;

    public ArrayList<Weather> getWeather() {
        return weather;
    }
}



