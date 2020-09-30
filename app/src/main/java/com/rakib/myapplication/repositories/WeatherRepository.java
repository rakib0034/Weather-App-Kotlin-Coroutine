package com.rakib.myapplication.repositories;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.rakib.myapplication.model.Weather;
import com.rakib.myapplication.model.WeatherEntity;
import com.rakib.myapplication.networking.RetrofitService;
import com.rakib.myapplication.networking.WeatherAPI;
import com.rakib.myapplication.viewmodel.WeatherViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {

    final String API_KEY = "19dea8bcd0bf29172e775e025e3ed90f";
    static String zipCode;
    private static WeatherAPI weatherAPI;
    private static WeatherRepository weatherRepository;

    /*public WeatherRepository(String zipCode) {
        this.zipCode = zipCode;
    }*/

    public static  WeatherRepository getInstance() {
        if (weatherRepository == null) {
            weatherRepository = new WeatherRepository ();
        }
        weatherAPI = RetrofitService.createService (WeatherAPI.class);
        return weatherRepository;
    }


//    public WeatherRepository() {
//        weatherAPI = RetrofitService.getInterface ( );
//    }

    public MutableLiveData<ArrayList<WeatherEntity>> getWeather(String zipCode, String api_key) {
        final MutableLiveData<ArrayList<WeatherEntity>> weatherEntityMutableLiveData = new MutableLiveData<> ( );
        Call<WeatherEntity> call = weatherAPI.getByID (zipCode, "US", api_key);

        call.enqueue (new Callback<WeatherEntity> ( ) {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                WeatherEntity weatherEntity = response.body ( );
                ArrayList<WeatherEntity> weatherEntities = new ArrayList ( );
                weatherEntities.clear ( );
                weatherEntities.add (weatherEntity);
                weatherEntityMutableLiveData.setValue (weatherEntities);
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {

            }
        });
        return weatherEntityMutableLiveData;
    }
}
