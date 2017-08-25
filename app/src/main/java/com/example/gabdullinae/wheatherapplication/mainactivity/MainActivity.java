package com.example.gabdullinae.wheatherapplication.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gabdullinae.wheatherapplication.R;
import com.example.gabdullinae.wheatherapplication.mainactivity.citylist.CityListFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new CityListFragment())
                .commit();
    }
}
