package com.rakib.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rakib.myapplication.model.WeatherEntity;
//import com.rakib.myapplication.networking.WeatherAPI;

import com.rakib.myapplication.networking.WeatherAPI;
import com.rakib.myapplication.view.adapter.WeatherAdapter;
import com.rakib.myapplication.viewmodel.WeatherViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String URL = "https://api.openweathermap.org/";
    final String API_kEY = "19dea8bcd0bf29172e775e025e3ed90f";
    Button search;
    TextView text1;
    TextView text2;
    EditText cityName;
    WeatherAPI weatherAPI;
    RecyclerView recyclerView;
    WeatherAdapter weatherAdapter;
    RecyclerView.LayoutManager layoutManager;
    String zipcode;
    WeatherViewModel weatherViewModel;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        cityName = findViewById (R.id.city_name);
        text1 = findViewById (R.id.weather_main);
        text2 = findViewById (R.id.weather_desc);
        search = findViewById (R.id.search_button);
        recyclerView = findViewById (R.id.recycler_view);
        layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (layoutManager);

        weatherViewModel = new ViewModelProvider (MainActivity.this).get (WeatherViewModel.class);
        search.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                zipcode = cityName.getText ( ).toString ( );

                //System.err.println ("After zipcode");
//                weatherViewModel = ViewModelProviders.of(MainActivity.this).get (WeatherViewModel.class);


//                mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
                weatherViewModel.setZipCode (zipcode);

//                        .of(MainActivity.this).get (WeatherViewModel.class);

                weatherViewModel.init ( );
                weatherViewModel.getNewsRepository ( ).observe (MainActivity.this, new Observer<ArrayList<WeatherEntity>> ( ) {
                    @Override
                    public void onChanged(ArrayList<WeatherEntity> weatherEntities) {
                        String a = weatherEntities.get (0).weather.get (0).getMain ();
                        System.err.println (a);
                        weatherAdapter = new WeatherAdapter ();
                        weatherAdapter.getWeather (weatherEntities);
                        recyclerView.setAdapter (weatherAdapter);
                    }
                });
//               weatherViewModel.getNewsRepository ().observe (MainActivity.this, new Observer<WeatherEntity> ( ) {
//                   @Override
//                   public void onChanged(WeatherEntity weatherEntity) {
//
//                       weatherAdapter =new  WeatherAdapter(weatherEntity);
//                       String mainWeather = weatherEntity.weather.get (0).getMain ( ).toString ( );
//
//                       System.err.println (mainWeather);
//                   }
//               });


                // weatherViewModel= new WeatherViewModel (zipcode);

                // setSearch();
            }

        });
    }

//    void setSearch() {
//        Retrofit retrofit = new Retrofit.Builder ( ).baseUrl (URL).addConverterFactory (GsonConverterFactory.create ( )).build ( );
//        Log.e ("Test", retrofit + "");
//        zipcode = cityName.getText ( ).toString ( );
//        weatherAPI = retrofit.create (WeatherAPI.class);
//        Call<WeatherEntity> call = weatherAPI.getByID (zipcode, "US", API_kEY);
//
//        call.enqueue (new Callback<WeatherEntity> ( ) {
//            @Override
//            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
//
//                WeatherEntity weatherEntity = response.body ( );
//
//                ArrayList<Weather> arrayList = weatherEntity.getWeather ();
//
//                weatherAdapter = new WeatherAdapter (arrayList);
//                recyclerView.setAdapter (weatherAdapter);
//
//                 /*
//                        Log.e ("Test", response.body ( ).toString ( ));
//
//                        WeatherEntity entity;
//                        entity = response.body ( );
//
//                        assert entity != null;
//                        String mainWeather = entity.weather.get (0).getMain ( ).toString ( );
//                        String desc = entity.weather.get (0).getDescription ( );
//                        text1.setText (mainWeather);
//                        text2.setText (desc); */
//            }
//
//            @Override
//            public void onFailure(Call<WeatherEntity> call, Throwable t) {
//
//            }
//        });
//    }
}
