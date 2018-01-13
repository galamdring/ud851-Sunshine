package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView textview_detail = ((TextView) findViewById(R.id.tv_detail_weather_data));
        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent thisIntent = getIntent();
        if(thisIntent.hasExtra("WeatherData")) {
            String data = thisIntent.getStringExtra("WeatherData");
            textview_detail.setText(data);
        }
        else textview_detail.setText("No data provided.");

    }
}