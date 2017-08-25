package com.example.gabdullinae.wheatherapplication.network;

import com.example.gabdullinae.wheatherapplication.model.forecast.DailyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.forecast.HourlyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.temperature.WeatherResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 19:57.
 */
public interface WeatherApi {
    @GET("data/2.5/weather")
    Observable<Response<WeatherResponse>> byCityName(@Query("q") String city, @Query("units") String metric);

    @GET("data/2.5/forecast/hourly")
    Observable<Response<HourlyForecastWeatherResponse>> hourlyForecastByCityID(@Query("id") int cityID, @Query("units") String metric);

    @GET("data/2.5/forecast/daily")
    Observable<Response<DailyForecastWeatherResponse>> dailyForecastByCityID(@Query("id") int cityID, @Query("units") String metric);
}

