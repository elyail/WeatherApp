package com.example.gabdullinae.wheatherapplication.model.temperature;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 20:50.
 */

public class Temperature {
    @SerializedName("temp")
    public Double degree;
    @SerializedName("pressure")
    public double pressure;
    @SerializedName("humidity")
    public double humidity;
    @SerializedName("temp_min")
    public double tempMin;
    @SerializedName("temp_max")
    public double tempMax;
}
