
package com.rakib.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rakib.myapplication.R;
import com.rakib.myapplication.model.WeatherEntity;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    ArrayList<WeatherEntity> list;

    // public WeatherAdapter(ArrayList<WeatherEntity> list) {
    //  this.list = list;
    // }
    public void getWeather(ArrayList<WeatherEntity> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from (parent.getContext ( ));
        View v = inflater.inflate (R.layout.item_weather, parent, false);


        return new WeatherViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherEntity current = list.get (position);
        String weather = current.weather.get (0).getMain ( );
        String desc = current.weather.get (0).getDescription ( );
//        String weather = current.get(0)getMain ();
//        String desc = current.getDescription ();
        holder.mainWeather.setText (weather);
        holder.weatherDesc.setText (desc);
        //notifyDataSetChanged ();
    }

    @Override
    public int getItemCount() {
        return list.size ( );
    }

    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView mainWeather;
        TextView weatherDesc;

        public WeatherViewHolder(@NonNull View itemView) {
            super (itemView);

            mainWeather = itemView.findViewById (R.id.weather_main);
            weatherDesc = itemView.findViewById (R.id.weather_desc);
        }

    }
}

