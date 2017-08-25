package com.example.gabdullinae.wheatherapplication.detailinfoactivity.detailinfofragment;

import com.example.gabdullinae.wheatherapplication.model.forecast.DailyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.forecast.HourlyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.temperature.WeatherResponse;

/**
 * Created by Elvira Gabdullina
 * on 25.08.17, 14:17.
 */

public interface DetailInfoView {
    void bindWeatherResponse(WeatherResponse weatherResponse);
    void bindDailyResponse(DailyForecastWeatherResponse dailyForecastWeatherResponse);
    void bindHourlyResponse(HourlyForecastWeatherResponse hourlyForecastWeatherResponse);
    void showErrorToast(String error);
}
