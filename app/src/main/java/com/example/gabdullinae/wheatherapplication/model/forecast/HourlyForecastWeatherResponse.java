package com.example.gabdullinae.wheatherapplication.model.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Elvira Gabdullina
 on 12.11.2016, 14:43.
 */

public class HourlyForecastWeatherResponse {
    @SerializedName("list")
    public List<HourlyForecast> hourlyForecastList;
}
