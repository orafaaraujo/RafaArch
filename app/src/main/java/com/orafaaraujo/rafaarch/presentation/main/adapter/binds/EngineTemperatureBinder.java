package com.orafaaraujo.rafaarch.presentation.main.adapter.binds;

import android.support.annotation.NonNull;

import com.jakewharton.rxbinding.view.RxView;
import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.presentation.main.adapter.ChartClickListener;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.EngineTempViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

public class EngineTemperatureBinder implements ChartBinderInterface {

    private Chart mChart;

    private EngineTempViewHolder mViewHolder;

    private ChartClickListener mClickListener;

    private EngineTemperatureBinder() {
    }

    private static EngineTemperatureBinder sBinder;

    public static EngineTemperatureBinder getInstance() {
        if (sBinder == null) {
            sBinder = new EngineTemperatureBinder();
        }
        return sBinder;
    }

    @Override
    public EngineTemperatureBinder bind(@NonNull Chart chart, ChartClickListener clickListener) {
        mClickListener = clickListener;
        mChart = chart;
        return this;
    }

    @Override
    public EngineTemperatureBinder into(@NonNull ChartViewHolder viewHolder) {
        mViewHolder = (EngineTempViewHolder) viewHolder;
        apply();
        return this;
    }

    @Override
    public void apply() {
        RxView.clicks(mViewHolder.outButton).subscribe(aVoid -> {
            mClickListener.onChartClick(mChart);
        });
    }
}
