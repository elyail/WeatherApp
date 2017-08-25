package com.example.gabdullinae.wheatherapplication.model.temperature;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 20:29.
 */

public enum WeatherMetric {
    METRIC("metric"),
    IMPERIAL("imperial");
    public String value;
    WeatherMetric(String value) {
        this.value = value;
    }
}
