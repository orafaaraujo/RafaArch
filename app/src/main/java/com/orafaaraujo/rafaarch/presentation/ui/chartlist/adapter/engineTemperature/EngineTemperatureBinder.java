package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.engineTemperature;

import android.content.Context;
import android.support.annotation.NonNull;

import com.jakewharton.rxbinding.view.RxView;
import com.orafaaraujo.rafaarch.model.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.helper.temperature.TemperatureChartMaker;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.ChartClickListener;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.binds.ChartBinderInterface;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

public class EngineTemperatureBinder implements ChartBinderInterface {

    private static EngineTemperatureBinder sBinder;
    private final Context mContext;
    private ChartValue mChartValue;
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
    public EngineTemperatureBinder bind(@NonNull ChartValue chartValue, @NonNull ChartClickListener clickListener) {
        mClickListener = clickListener;
        mChartValue = chartValue;
        return this;
    }

    @Override
    public EngineTemperatureBinder into(@NonNull ChartViewHolder viewHolder) {
        mViewHolder = (EngineTempViewHolder) viewHolder;
        apply();
        return this;
    }

    public void apply() {
        configClicks();
        TemperatureChartMaker.make(mContext, mViewHolder.chart, mChartValue);
    }

    private void configClicks() {
        RxView.clicks(mViewHolder.outButton).subscribe(aVoid -> {
            mClickListener.onChartClick(mChartValue);
        });
    }
}