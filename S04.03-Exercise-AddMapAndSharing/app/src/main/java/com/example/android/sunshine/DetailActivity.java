package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String mForecast;
    private TextView mWeatherDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherDisplay = (TextView) findViewById(R.id.tv_display_weather);

        Intent intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                mForecast = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mWeatherDisplay.setText(mForecast);
            }
        }
    }

    // TODO (3) Create a menu with an item with id of action_share
    // TODO (4) Display the menu and implement the forecast sharing functionality
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(shareDetail());
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }


    private Intent shareDetail() {
        String mimeType ="text/plain";
        String chooserTitle = "Share Weather Detail";
        return ShareCompat.IntentBuilder.from(this)
                .setChooserTitle(chooserTitle)
                .setType(mimeType)
                .setText(mForecast).getIntent();
    }
}