package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.usage;

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

public class UsageReportBinder implements ChartBinderInterface {

    private static UsageReportBinder sBinder;
    private final Context mContext;
    private ChartValue mChartValue;
    private UsageReportViewHolder mViewHolder;
    private ChartClickListener mClickListener;

    private UsageReportBinder(Context context) {
        mContext = context;
    }

    public static UsageReportBinder getInstance(Context context) {
        if (sBinder == null) {
            sBinder = new UsageReportBinder(context);
        }
        return sBinder;
    }

    @Override
    public UsageReportBinder bind(@NonNull ChartValue chartValue, @NonNull ChartClickListener clickListener) {
        mClickListener = clickListener;
        mChartValue = chartValue;
        return this;
    }

    @Override
    public UsageReportBinder into(@NonNull ChartViewHolder viewHolder) {
        mViewHolder = (UsageReportViewHolder) viewHolder;
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