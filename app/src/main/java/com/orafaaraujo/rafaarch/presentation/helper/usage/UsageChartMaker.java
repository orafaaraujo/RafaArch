package com.orafaaraujo.rafaarch.presentation.helper.usage;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.model.chart.ChartItem;
import com.orafaaraujo.rafaarch.model.chart.ChartValue;

import java.util.ArrayList;

/**
 * Created by rafael on 07/11/16.
 */

public class UsageChartMaker {

    public static void make(Context context, LineChart chart, ChartValue chartValue) {

        configChart(context, chart);
        chart.setData(generateData(context, chartValue));
    }

    private static void configChart(Context context, LineChart chart) {

        chart.getDescription().setEnabled(false); // remove chart title on right bottom
        chart.setDrawGridBackground(false); // remove gray background
        chart.getLegend().setEnabled(false); // Remove chart legend below bars
        chart.setHighlightPerTapEnabled(false);
        chart.setHighlightPerDragEnabled(false);
        chart.setScaleMinima(5f, 0.5f); // pre zoom on begining
        chart.animateY(600);

        final YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(ContextCompat.getColor(context, R.color.text_color));
        leftAxis.setTextSize(10f);
        leftAxis.setDrawGridLines(false); // remove grid
        leftAxis.setDrawAxisLine(false); // remove left side line
        leftAxis.setGranularity(1f); // settinhg the space betweens itens of Y
        leftAxis.setAxisMaximum(7f); // maximum of value on screen
        leftAxis.setAxisMinimum(1f); // minimum of value on screen

        chart.getAxisRight().setEnabled(false); // remove right labels

        final XAxis xAxis = chart.getXAxis();
        xAxis.setTextColor(ContextCompat.getColor(context, R.color.chart_label));
        xAxis.setTextSize(10f);
        xAxis.setDrawGridLines(false); // remove grid
        xAxis.setDrawAxisLine(false); // remove left side line
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
    }

    private static LineData generateData(Context context, ChartValue chartValue) {

        final ArrayList<ILineDataSet> dataSet = new ArrayList<>();
        dataSet.add(configureUsageLine(context, chartValue));
        dataSet.add(configureMonthAVGLine(context, chartValue));

        return new LineData(dataSet);
    }

    private static LineDataSet configureUsageLine(Context context, ChartValue chartValue) {

        final ArrayList<Entry> entries = new ArrayList<>();
        for (ChartItem item : chartValue.getItems()) {
            entries.add(new Entry(item.getTime(), item.getValue()));
        }

        final LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setColor(ContextCompat.getColor(context, R.color.chart_usage_line));
        dataSet.setFillColor(ContextCompat.getColor(context, R.color.chart_usage_line));
        dataSet.setDrawValues(false); // remove showing values
        dataSet.setDrawCircles(false); // don't draw dot on corner.
        dataSet.setDrawFilled(true); // fill below the line

        return dataSet;
    }

    private static LineDataSet configureMonthAVGLine(Context context, ChartValue chartValue) {

        final ArrayList<Entry> entries = new ArrayList<>();
        for (ChartItem item : chartValue.getAverageItems()) {
            entries.add(new Entry(item.getTime(), item.getValue()));
        }

        final LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setDrawValues(false); // remove showing values
        dataSet.enableDashedLine(12f, 12f, 12f);
        dataSet.setColor(ContextCompat.getColor(context, R.color.chart_usage_month_avg_line));
        dataSet.setDrawCircles(false); // don't draw dot on corner.
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER); // curved line

        return dataSet;
    }


}
