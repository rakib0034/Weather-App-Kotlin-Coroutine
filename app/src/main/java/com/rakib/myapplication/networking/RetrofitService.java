package com.rakib.myapplication.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final String URL = "https://api.openweathermap.org/";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static <S> S createService (Class<S> serviceClass){
        return retrofit.create (serviceClass);
    }

    /*public static WeatherAPI getInterface() {
        return retrofit.create(WeatherAPI.class);
    }*/
}
