package com.orafaaraujo.rafaarch.presentation.ui.chart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.google.gson.Gson;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.model.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.helper.temperature.TemperatureChartMaker;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.orafaaraujo.rafaarch.presentation.ui.chartlist.ChartListActivity.CHART_KEY;


public class ChartActivity extends AppCompatActivity {

    @BindView(R.id.activity_chart_engine_temperature_chart)
    BarChart mBarChart;

    private ChartValue mChartValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        ButterKnife.bind(this);

        getChartValue();
        configChart();
    }

    private void getChartValue() {
        String strObj = getIntent().getStringExtra(CHART_KEY);
        mChartValue = new Gson().fromJson(strObj, ChartValue.class);
    }

    private void configChart() {
        TemperatureChartMaker.make(this, mBarChart, mChartValue);
    }
}
