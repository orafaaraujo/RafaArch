package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.engineTemperature;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jakewharton.rxbinding.view.RxView;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.ChartItem;
import com.orafaaraujo.rafaarch.entity.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.helper.temperature.TemperatureBarDataSet;
import com.orafaaraujo.rafaarch.presentation.helper.temperature.TemperatureValueFormatter;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.ChartClickListener;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.binds.ChartBinderInterface;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

import java.util.ArrayList;

/**
 * Created by rafael on 03/11/16.
 */

public class EngineTemperatureBinder implements ChartBinderInterface {

    private static EngineTemperatureBinder sBinder;
    private final Context mContext;
    private ChartValue mChartValue;
    private BarChart mBarChart;
    private EngineTempViewHolder mViewHolder;
    private ChartClickListener mClickListener;

    private EngineTemperatureBinder(Context context) {
        mContext = context;
    }

    public static EngineTemperatureBinder getInstance(Context context) {
        if (sBinder == null) {
            sBinder = new EngineTemperatureBinder(context);
        }
        return sBinder;
    }

    @Override
    public EngineTemperatureBinder bind(@NonNull ChartValue chartValue, ChartClickListener clickListener) {
        mClickListener = clickListener;
        mChartValue = chartValue;
        return this;
    }

    @Override
    public EngineTemperatureBinder into(@NonNull ChartViewHolder viewHolder) {
        mViewHolder = (EngineTempViewHolder) viewHolder;
        mBarChart = mViewHolder.chart;
        apply();
        return this;
    }

    @Override
    public void apply() {
        configClicks();
        configBarChart();
        mBarChart.setData(generateBarData(50, 13));
    }

    private void configClicks() {
        RxView.clicks(mViewHolder.outButton).subscribe(aVoid -> {
            mClickListener.onChartClick(mChartValue);
        });
    }

    private void configBarChart() {

        mBarChart.getDescription().setEnabled(false); // remove chart title on right bottom

        mBarChart.setDrawGridBackground(false); // remove gray background
        mBarChart.setDrawBarShadow(false); // show only part which have content on bar
        mBarChart.getLegend().setEnabled(false); // Remove chart legend below bars
        mBarChart.setExtraTopOffset(0);
        mBarChart.animateY(600);

        // set a threshold line limit.
        LimitLine limitLine = new LimitLine(40f);
        limitLine.enableDashedLine(12f, 12f, 12f);
        limitLine.setLineColor(R.color.chart_limit_color);

        final YAxis leftAxis = mBarChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(ContextCompat.getColor(mContext, R.color.text_color));
        leftAxis.setTextSize(10f);
        leftAxis.setDrawGridLines(false); // remove grid
        leftAxis.setDrawAxisLine(false); // remove left side line
        leftAxis.addLimitLine(limitLine); // set threshold
        leftAxis.setValueFormatter(new TemperatureValueFormatter()); // Formatting the labels of Y
        leftAxis.setGranularity(20f); // settinhg the space betweens itens of Y

        mBarChart.getAxisRight().setEnabled(false); // remove right labels

        final XAxis xAxis = mBarChart.getXAxis();
        xAxis.setTextColor(ContextCompat.getColor(mContext, R.color.chart_label));
        xAxis.setTextSize(10f);
        xAxis.setDrawGridLines(false); // remove grid
        xAxis.setDrawAxisLine(false); // remove left side line
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(0f);


    }

    private BarData generateBarData(float range, int count) {

        ArrayList<IBarDataSet> dataSet = new ArrayList<>();
        ArrayList<BarEntry> entries = new ArrayList<>();


        for (ChartItem item : mChartValue.getItems()) {
            entries.add(new BarEntry(item.getTime(), item.getValue()));
        }

        TemperatureBarDataSet barDataSet = new TemperatureBarDataSet(entries, "");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setDrawValues(false);

        dataSet.add(barDataSet);

        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.5f); // bar width size.

        return barData;
    }


}