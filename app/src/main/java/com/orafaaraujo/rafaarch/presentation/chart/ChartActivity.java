package com.orafaaraujo.rafaarch.presentation.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.Chart;

import static com.orafaaraujo.rafaarch.presentation.main.MainActivity.CHART_KEY;


public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        // TODO Make screen
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra(CHART_KEY);
        Chart chart = gson.fromJson(strObj, Chart.class);
    }
}
