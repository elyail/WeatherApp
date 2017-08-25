package com.example.gabdullinae.wheatherapplication.detailinfoactivity.detailinfofragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabdullinae.wheatherapplication.R;
import com.example.gabdullinae.wheatherapplication.model.City;
import com.example.gabdullinae.wheatherapplication.model.forecast.DailyForecast;
import com.example.gabdullinae.wheatherapplication.model.forecast.DailyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.forecast.HourlyForecast;
import com.example.gabdullinae.wheatherapplication.model.forecast.HourlyForecastWeatherResponse;
import com.example.gabdullinae.wheatherapplication.model.temperature.WeatherResponse;
import com.example.gabdullinae.wheatherapplication.utils.IconUtils;
import com.example.gabdullinae.wheatherapplication.utils.TimeUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.example.gabdullinae.wheatherapplication.mainactivity.citylist.CityListFragment.CITY;


public class DetailInfoWeatherFragment extends Fragment implements DetailInfoView {
    private static final String WEATHER_RESPONSE = "weatherResponse";
    private static final String DAILY_FORECAST_WEATHER_RESPONSE = "dailyForecastWeatherResponse";
    private static final String HOURLY_FORECAST_WEATHER_RESPONSE = "hourlyForecastWeatherResponse";
    private DetailInfoPresenter presenter = new DetailInfoPresenter(this);
    private TextView weatherDegree;
    private ImageView weatherIcon;
    private TextView cityWeatherDescription;
    private TextView weatherMax;
    private TextView weatherMin;
    private ImageView weatherIconDescription;
    private TextView visibilityDegree;
    private TextView cloudsDegree;
    private TextView humidityDegree;
    private Toolbar toolbar;
    int cityID;
    private ForecastByTimeAdapter adapterByTime;
    private RecyclerView byTime;
    private List<HourlyForecast> hourlyForecastlist = new ArrayList<>();
    private List<DailyForecast> dailyForecastlist = new ArrayList<>();

    //dailyForecast
    private TextView dayOfWeek1;
    private TextView minTempForecast1;
    private TextView maxTempForecast1;
    private TextView dayOfWeek2;
    private TextView minTempForecast2;
    private TextView maxTempForecast2;
    private TextView dayOfWeek3;
    private TextView minTempForecast3;
    private TextView maxTempForecast3;
    private TextView dayOfWeek4;
    private TextView minTempForecast4;
    private TextView maxTempForecast4;
    private TextView dayOfWeek5;
    private TextView minTempForecast5;
    private TextView maxTempForecast5;
    private ImageView iconForecast1;
    private ImageView iconForecast2;
    private ImageView iconForecast3;
    private ImageView iconForecast4;
    private ImageView iconForecast5;

    private WeatherResponse weatherResponse;
    private DailyForecastWeatherResponse dailyForecastWeatherResponse;
    private HourlyForecastWeatherResponse hourlyForecastWeatherResponse;
    private City city;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (weatherResponse == null || dailyForecastWeatherResponse == null || hourlyForecastWeatherResponse == null) {
            return;
        }
        Gson gson = new Gson();
        outState.putString(WEATHER_RESPONSE, gson.toJson(weatherResponse));
        outState.putString(DAILY_FORECAST_WEATHER_RESPONSE, gson.toJson(dailyForecastWeatherResponse));
        outState.putString(HOURLY_FORECAST_WEATHER_RESPONSE, gson.toJson(hourlyForecastWeatherResponse));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        getExtras();
        addCityNameInToolbar();
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(WEATHER_RESPONSE)
                    && savedInstanceState.containsKey(DAILY_FORECAST_WEATHER_RESPONSE)
                    && savedInstanceState.containsKey(HOURLY_FORECAST_WEATHER_RESPONSE)) {
                Gson gson = new Gson();
                weatherResponse = gson.fromJson(savedInstanceState.getString(WEATHER_RESPONSE), WeatherResponse.class);
                dailyForecastWeatherResponse = gson.fromJson(savedInstanceState.getString(DAILY_FORECAST_WEATHER_RESPONSE), DailyForecastWeatherResponse.class);
                hourlyForecastWeatherResponse = gson.fromJson(savedInstanceState.getString(HOURLY_FORECAST_WEATHER_RESPONSE), HourlyForecastWeatherResponse.class);
                bindWeatherResponse(weatherResponse);
                bindDailyResponse(dailyForecastWeatherResponse);
                bindHourlyResponse(hourlyForecastWeatherResponse);
                return;
            }
        }
        presenter.getRequest(city);
    }

    private void addCityNameInToolbar() {
        ((TextView) toolbar.findViewById(R.id.toolbar_title)).setText(this.city.name);
    }

    private void getExtras() {
        String city = getActivity().getIntent().getStringExtra(CITY);
        this.city = new Gson().fromJson(city, City.class);
    }

    private void init(View view) {
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        weatherDegree = (TextView) view.findViewById(R.id.weatherDegree);
        weatherIcon = (ImageView) view.findViewById(R.id.weatherIcon);
        cityWeatherDescription = (TextView) view.findViewById(R.id.cityWeatherDescription);
        weatherMax = (TextView) view.findViewById(R.id.weatherMax);
        byTime = (RecyclerView) view.findViewById(R.id.forecastRecyclerListByTime);
        weatherMin = (TextView) view.findViewById(R.id.weatherMin);
        weatherIconDescription = (ImageView) view.findViewById(R.id.weatherIconDescription);
        visibilityDegree = (TextView) view.findViewById(R.id.visibilityDegree);
        cloudsDegree = (TextView) view.findViewById(R.id.cloudsDegree);
        humidityDegree = (TextView) view.findViewById(R.id.humidityDegree);
        dayOfWeek1 = (TextView) view.findViewById(R.id.dayOfWeek1);
        dayOfWeek2 = (TextView) view.findViewById(R.id.dayOfWeek2);
        dayOfWeek3 = (TextView) view.findViewById(R.id.dayOfWeek3);
        dayOfWeek4 = (TextView) view.findViewById(R.id.dayOfWeek4);
        dayOfWeek5 = (TextView) view.findViewById(R.id.dayOfWeek5);
        minTempForecast1 = (TextView) view.findViewById(R.id.minTempForecast1);
        minTempForecast2 = (TextView) view.findViewById(R.id.minTempForecast2);
        minTempForecast3 = (TextView) view.findViewById(R.id.minTempForecast3);
        minTempForecast4 = (TextView) view.findViewById(R.id.minTempForecast4);
        minTempForecast5 = (TextView) view.findViewById(R.id.minTempForecast5);
        maxTempForecast1 = (TextView) view.findViewById(R.id.maxTempForecast1);
        maxTempForecast2 = (TextView) view.findViewById(R.id.maxTempForecast2);
        maxTempForecast3 = (TextView) view.findViewById(R.id.maxTempForecast3);
        maxTempForecast4 = (TextView) view.findViewById(R.id.maxTempForecast4);
        maxTempForecast5 = (TextView) view.findViewById(R.id.maxTempForecast5);
        iconForecast1 = (ImageView) view.findViewById(R.id.iconForecast1);
        iconForecast2 = (ImageView) view.findViewById(R.id.iconForecast2);
        iconForecast3 = (ImageView) view.findViewById(R.id.iconForecast3);
        iconForecast4 = (ImageView) view.findViewById(R.id.iconForecast4);
        iconForecast5 = (ImageView) view.findViewById(R.id.iconForecast5);
    }

    @Override
    public void bindWeatherResponse(WeatherResponse weatherResponse) {
        weatherIcon.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(weatherResponse.weatherList.get(0).icon)));
        weatherDegree.setText(String.valueOf((weatherResponse.temperature.degree.intValue())) + " °C");
        cityWeatherDescription.setText(String.valueOf(weatherResponse.weatherList.get(0).description));
        weatherMax.setText(String.valueOf(weatherResponse.temperature.tempMax));
        weatherMin.setText(String.valueOf(weatherResponse.temperature.tempMin));
        visibilityDegree.setText(String.valueOf(weatherResponse.visibility));
        cloudsDegree.setText(String.valueOf(weatherResponse.clouds.all));
        humidityDegree.setText(String.valueOf(weatherResponse.temperature.humidity));
        cityID = weatherResponse.cityID;
        weatherIconDescription.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(weatherResponse.weatherList.get(0).icon)));
    }

    @Override
    public void bindDailyResponse(DailyForecastWeatherResponse dailyForecastWeatherResponse) {
        dailyForecastlist.addAll(dailyForecastWeatherResponse.dailyForecastList);
        dayOfWeek1.setText(TimeUtils.prettyDate(getActivity(), dailyForecastlist.get(1).dt));
        minTempForecast1.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(1).temp.min) + " °C"));
        maxTempForecast1.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(1).temp.max) + " °C"));
        iconForecast1.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(dailyForecastWeatherResponse.dailyForecastList.get(1).weather.get(0).icon)));

        dayOfWeek2.setText(TimeUtils.prettyDate(getActivity(), dailyForecastlist.get(2).dt));
        minTempForecast2.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(2).temp.min) + " °C"));
        maxTempForecast2.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(2).temp.max) + " °C"));
        iconForecast2.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(dailyForecastWeatherResponse.dailyForecastList.get(2).weather.get(0).icon)));

        dayOfWeek3.setText(TimeUtils.prettyDate(getActivity(), dailyForecastlist.get(3).dt));
        minTempForecast3.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(3).temp.min) + " °C"));
        maxTempForecast3.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(3).temp.max) + " °C"));
        iconForecast3.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(dailyForecastWeatherResponse.dailyForecastList.get(3).weather.get(0).icon)));

        dayOfWeek4.setText(TimeUtils.prettyDate(getActivity(), dailyForecastlist.get(4).dt));
        minTempForecast4.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(4).temp.min) + " °C"));
        maxTempForecast4.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(4).temp.max) + " °C"));
        iconForecast4.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(dailyForecastWeatherResponse.dailyForecastList.get(4).weather.get(0).icon)));

        dayOfWeek5.setText(TimeUtils.prettyDate(getActivity(), dailyForecastlist.get(5).dt));
        minTempForecast5.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(5).temp.min) + " °C"));
        maxTempForecast5.setText(String.valueOf((dailyForecastWeatherResponse.dailyForecastList.get(5).temp.max) + " °C"));
        iconForecast5.setImageDrawable(IconUtils.prettyIcon(getContext(), String.valueOf(dailyForecastWeatherResponse.dailyForecastList.get(5).weather.get(0).icon)));
    }

    @Override
    public void bindHourlyResponse(HourlyForecastWeatherResponse hourlyForecastWeatherResponse) {
        hourlyForecastlist.addAll(hourlyForecastWeatherResponse.hourlyForecastList);
        adapterByTime = new ForecastByTimeAdapter(hourlyForecastlist);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        byTime.setLayoutManager(layoutManager);
        byTime.setAdapter(adapterByTime);
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }
}
