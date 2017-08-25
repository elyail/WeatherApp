package com.example.gabdullinae.wheatherapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Elvira Gabdullina
 on 12.11.2016, 14:43.
 */

public class CityList {
    @SerializedName("_id")
    public int cityId;

    @SerializedName("name")
    public String cityName;

    @SerializedName("country")
    public String country;
}
