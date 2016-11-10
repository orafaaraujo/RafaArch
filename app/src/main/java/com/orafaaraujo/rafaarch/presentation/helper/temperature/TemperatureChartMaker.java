package com.orafaaraujo.rafaarch.presentation.helper.temperature;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.model.chart.ChartItem;
import com.orafaaraujo.rafaarch.model.chart.ChartValue;

import java.util.ArrayList;

/**
 * Created by rafael on 07/11/16.
 */

public class TemperatureChartMaker {

    public static void make(Context context, BarChart chart, ChartValue chartValue) {

        configChart(context, chart);
        chart.setData(generateData(chartValue));
    }

    private static void configChart(Context context, BarChart chart) {

        chart.getDescription().setEnabled(false); // remove chart title on right bottom
        chart.setDrawGridBackground(false); // remove gray background
        chart.setDrawBarShadow(false); // show only part which have content on bar
        chart.getLegend().setEnabled(false); // Remove chart legend below bars
        chart.setViewPortOffsets(80, 0, 80, 80);
        chart.animateY(600);

        // set a threshold line limit.
        LimitLine limitLine = new LimitLine(40f);
        limitLine.enableDashedLine(12f, 12f, 12f);
        limitLine.setLineColor(R.color.chart_limit_color);

        final YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(ContextCompat.getColor(context, R.color.text_color));
        leftAxis.setTextSize(10f);
        leftAxis.setDrawGridLines(false); // remove grid
        leftAxis.setDrawAxisLine(false); // remove left side line
        leftAxis.addLimitLine(limitLine); // set threshold
        leftAxis.setValueFormatter(new TemperatureValueFormatter()); // Formatting the labels of Y
        leftAxis.setGranularity(20f); // settinhg the space betweens itens of Y

        chart.getAxisRight().setEnabled(false); // remove right labels

        final XAxis xAxis = chart.getXAxis();
        xAxis.setTextColor(ContextCompat.getColor(context, R.color.chart_label));
        xAxis.setTextSize(10f);
        xAxis.setDrawGridLines(false); // remove grid
        xAxis.setDrawAxisLine(false); // remove left side line
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(0f);

    }

    private static BarData generateData(ChartValue chartValue) {

        final ArrayList<BarEntry> entries = new ArrayList<>();
        for (ChartItem item : chartValue.getItems()) {
            entries.add(new BarEntry(item.getTime(), item.getValue()));
        }

        final TemperatureBarDataSet barDataSet = new TemperatureBarDataSet(entries, "");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setDrawValues(false);

        final ArrayList<IBarDataSet> dataSet = new ArrayList<>();
        dataSet.add(barDataSet);

        final BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.5f); // bar width size.

        return barData;
    }

}
