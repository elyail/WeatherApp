package com.example.gabdullinae.wheatherapplication.model.forecast;

import com.example.gabdullinae.wheatherapplication.model.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvira Gabdullina
 on 12.11.2016, 14:43.
 */

public class HourlyForecast {
    @SerializedName("dt")
    public Long dt;

    @SerializedName("main")
    public HourlyTemperature main;

    @SerializedName("weather")
    public List<Weather> weather = new ArrayList<Weather>();

}
