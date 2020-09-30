package com.rakib.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rakib.myapplication.model.WeatherEntity;
import com.rakib.myapplication.repositories.WeatherRepository;

import java.util.ArrayList;


public class WeatherViewModel extends ViewModel {
    private String zipCode;
    public static WeatherRepository weatherRepository;

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private MutableLiveData<ArrayList<WeatherEntity>> mutableLiveData;

    /*public WeatherViewModel(String zipCode) {
        this.zipCode = zipCode;

    }*/

    public void init() {
        if (mutableLiveData != null) {
            return;
        }
        weatherRepository = WeatherRepository.getInstance ( );
    }

    public LiveData<ArrayList<WeatherEntity>> getNewsRepository() {

        String API_KEY = "19dea8bcd0bf29172e775e025e3ed90f";
        mutableLiveData = weatherRepository.getWeather (zipCode, API_KEY);
        return mutableLiveData;
    }

}
