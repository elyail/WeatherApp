package com.example.gabdullinae.wheatherapplication.model.forecast;

import com.example.gabdullinae.wheatherapplication.model.Weather;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Elvira Gabdullina
 on 12.11.2016, 14:42.
 */

public class DailyForecast {
    @SerializedName("dt")
    public Long dt;

    @SerializedName("temp")
    public Temp temp;

    @SerializedName("weather")
    public java.util.List<Weather> weather = new ArrayList<Weather>();

}
