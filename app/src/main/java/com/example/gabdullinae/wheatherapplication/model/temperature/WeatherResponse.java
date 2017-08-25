package com.example.gabdullinae.wheatherapplication.model.temperature;

import com.example.gabdullinae.wheatherapplication.model.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 20:43.
 */

public class WeatherResponse {
    @SerializedName("weather")
   public List<Weather> weatherList;

    @SerializedName("main")
    public Temperature temperature;

    @SerializedName("visibility")
    public int visibility;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("id")
    public int cityID;

}
