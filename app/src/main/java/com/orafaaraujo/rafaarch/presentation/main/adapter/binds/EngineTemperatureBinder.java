package com.orafaaraujo.rafaarch.presentation.main.adapter.binds;

import android.support.annotation.NonNull;

import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.EngineTempViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

public class EngineTemperatureBinder implements ChartBinderInterface {

    private Chart mChart;

    private EngineTempViewHolder mViewHolder;

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
    public EngineTemperatureBinder bind(@NonNull Chart chart) {
        mChart = chart;
        return this;
    }

    @Override
    public EngineTemperatureBinder into(@NonNull ChartViewHolder viewHolder) {
        mViewHolder = (EngineTempViewHolder) viewHolder;
        return this;
    }

    @Override
    public void apply() {

    }

}
