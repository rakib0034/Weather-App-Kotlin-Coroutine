package com.rakib.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("id")
    public int id;
    @SerializedName("main")
    public String mainWeather;
    @SerializedName("description")
    public String description;
    @SerializedName("icon")
    public String icon;

    public String getMain() {
        return mainWeather;
    }

    public void setMainWeather(String main) {
        this.mainWeather = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
