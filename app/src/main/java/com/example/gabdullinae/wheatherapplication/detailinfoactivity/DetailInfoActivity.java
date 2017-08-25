package com.example.gabdullinae.wheatherapplication.detailinfoactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.gabdullinae.wheatherapplication.R;
import com.example.gabdullinae.wheatherapplication.detailinfoactivity.detailinfofragment.DetailInfoWeatherFragment;

/**
 * Created by Elvira Gabdullina
 * on 07.11.2016, 21:11.
 */

public class DetailInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new DetailInfoWeatherFragment())
                .commit();
    }
}
