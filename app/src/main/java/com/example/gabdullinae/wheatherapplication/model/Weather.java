package com.example.gabdullinae.wheatherapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 20:44.
 */

public class Weather {
    @SerializedName("id")
    public int id;
    @SerializedName("main")
    public  String title;
    @SerializedName("description")
    public  String description;
    @SerializedName("icon")
    public  String icon;
}
