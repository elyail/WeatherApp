package com.example.gabdullinae.wheatherapplication.detailinfoactivity.detailinfofragment;

import android.content.Context;
import android.widget.Toast;

import com.example.gabdullinae.wheatherapplication.model.City;
import com.example.gabdullinae.wheatherapplication.model.forecast.DailyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.forecast.HourlyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.temperature.WeatherMetric;
import com.example.gabdullinae.wheatherapplication.model.temperature.WeatherResponse;
import com.example.gabdullinae.wheatherapplication.network.RestClient;

import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func3;
import rx.schedulers.Schedulers;

/**
 * Created by Elvira Gabdullina
 * on 25.08.17, 14:18.
 */

public class DetailInfoPresenter {
    private DetailInfoView view;
    private WeatherResponse weatherResponse;
    private DailyForecastWeatherResponse dailyForecastWeatherResponse;
    private HourlyForecastWeatherResponse hourlyForecastWeatherResponse;

    public DetailInfoPresenter(DetailInfoView view) {
        this.view = view;
    }

    public void getRequest(City city) {
        Observable.zip(RestClient.rest().byCityName(city.name, WeatherMetric.METRIC.value),
                RestClient.rest().dailyForecastByCityID(city.id, WeatherMetric.METRIC.value),
                RestClient.rest().hourlyForecastByCityID(city.id, WeatherMetric.METRIC.value),
                new Func3<Response<WeatherResponse>, Response<DailyForecastWeatherResponse>, Response<HourlyForecastWeatherResponse>, Void>(
                ) {
                    @Override
                    public Void call(Response<WeatherResponse> weatherResponseResponse,
                                     Response<DailyForecastWeatherResponse> dailyForecastWeatherResponseResponse,
                                     Response<HourlyForecastWeatherResponse> hourlyForecastWeatherResponseResponse) {
                        if (!weatherResponseResponse.isSuccessful() || !dailyForecastWeatherResponseResponse.isSuccessful() ||
                                !hourlyForecastWeatherResponseResponse.isSuccessful()) {
                            return null;
                        }
                        weatherResponse = weatherResponseResponse.body();
                        dailyForecastWeatherResponse = dailyForecastWeatherResponseResponse.body();
                        hourlyForecastWeatherResponse = hourlyForecastWeatherResponseResponse.body();
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        view.bindWeatherResponse(weatherResponse);
                        view.bindDailyResponse(dailyForecastWeatherResponse);
                        view.bindHourlyResponse(hourlyForecastWeatherResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        view.showErrorToast(throwable.getMessage());
                    }
                });
    }
}
