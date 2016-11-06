package com.orafaaraujo.rafaarch.presentation.ui.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.ChartValue;

import static com.orafaaraujo.rafaarch.presentation.ui.chartlist.ChartListActivity.CHART_KEY;


public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        // TODO Make screen
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra(CHART_KEY);
        ChartValue chartValue = gson.fromJson(strObj, ChartValue.class);
    }
}
