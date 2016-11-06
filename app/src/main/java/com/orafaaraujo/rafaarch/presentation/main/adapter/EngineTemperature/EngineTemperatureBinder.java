package com.orafaaraujo.rafaarch.presentation.main.adapter.EngineTemperature;

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
import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.presentation.chartHelper.TemperatureBarDataSet;
import com.orafaaraujo.rafaarch.presentation.chartHelper.TemperatureValueFormatter;
import com.orafaaraujo.rafaarch.presentation.main.adapter.ChartClickListener;
import com.orafaaraujo.rafaarch.presentation.main.adapter.binds.ChartBinderInterface;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;

import java.util.ArrayList;

/**
 * Created by rafael on 03/11/16.
 */

public class EngineTemperatureBinder implements ChartBinderInterface {

    private final Context mContext;

    private Chart mChartValue;

    private BarChart mChart;

    private EngineTempViewHolder mViewHolder;

    private ChartClickListener mClickListener;

    private EngineTemperatureBinder(Context context) {
        mContext = context;
    }

    private static EngineTemperatureBinder sBinder;

    public static EngineTemperatureBinder getInstance(Context context) {
        if (sBinder == null) {
            sBinder = new EngineTemperatureBinder(context);
        }
        return sBinder;
    }

    @Override
    public EngineTemperatureBinder bind(@NonNull Chart chart, ChartClickListener clickListener) {
        mClickListener = clickListener;
        mChartValue = chart;
        return this;
    }

    @Override
    public EngineTemperatureBinder into(@NonNull ChartViewHolder viewHolder) {
        mViewHolder = (EngineTempViewHolder) viewHolder;
        mChart = mViewHolder.chart;
        apply();
        return this;
    }

    @Override
    public void apply() {
        configClicks();
        configBarChart();
    }

    private void configClicks() {
        RxView.clicks(mViewHolder.outButton).subscribe(aVoid -> {
            mClickListener.onChartClick(mChartValue);
        });
    }

    private void configBarChart() {

        mChart.getDescription().setEnabled(false); // remove chart title on right bottom

        mChart.setDrawGridBackground(false); // remove gray background
        mChart.setDrawBarShadow(false); // show only part which have content on bar
        mChart.getLegend().setEnabled(false); // Remove chart legend below bars
        mChart.setExtraTopOffset(0);
        mChart.animateY(600);

        // set a threshold line limit.
        LimitLine limitLine = new LimitLine(40f);
        limitLine.enableDashedLine(12f, 12f, 12f);
        limitLine.setLineColor(R.color.chart_limit_color);

        final YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(ContextCompat.getColor(mContext, R.color.text_color));
        leftAxis.setTextSize(10f);
        leftAxis.setDrawGridLines(false); // remove grid
        leftAxis.setDrawAxisLine(false); // remove left side line
        leftAxis.addLimitLine(limitLine); // set threshold
        leftAxis.setValueFormatter(new TemperatureValueFormatter()); // Formatting the labels of Y
        leftAxis.setGranularity(20f); // settinhg the space betweens itens of Y

        mChart.getAxisRight().setEnabled(false); // remove right labels

        final XAxis xAxis = mChart.getXAxis();
        xAxis.setTextColor(ContextCompat.getColor(mContext, R.color.chart_label));
        xAxis.setTextSize(10f);
        xAxis.setDrawGridLines(false); // remove grid
        xAxis.setDrawAxisLine(false); // remove left side line
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(0f);

        mChart.setData(generateBarData(50, 13));
    }

    protected BarData generateBarData(float range, int count) {

        ArrayList<IBarDataSet> dataSet = new ArrayList<>();
        ArrayList<BarEntry> entries = new ArrayList<>();

        for (int j = 1; j < count; j++) {
            entries.add(new BarEntry(j, (float) (Math.random() * range) + range / 4));
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