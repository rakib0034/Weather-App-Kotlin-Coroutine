package com.rakib.myapplication.networking;


import com.rakib.myapplication.model.WeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("data/2.5/weather?")
    Call<WeatherEntity> getWeather(@Query("q") String cityName, @Query("ID") String appid);

    @GET("data/2.5/weather?")
    Call<WeatherEntity> getByID(@Query("zip") String id, @Query("country code") String countryCode, @Query("APPID") String app_id);


}
