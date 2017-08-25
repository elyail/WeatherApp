package com.example.gabdullinae.wheatherapplication.network;

import android.util.Log;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 20:11.
 */

public class RestClient {
    private static HttpLoggingInterceptor logger = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Log.d("rest", message);
        }
    });

    static {
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter("appid", "2f8c329ad491005ba293664dbfc5ba65").build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        }
    }).addInterceptor(logger).build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static WeatherApi service = retrofit.create(WeatherApi.class);

    public static WeatherApi rest() {
        return service;
    }



}
