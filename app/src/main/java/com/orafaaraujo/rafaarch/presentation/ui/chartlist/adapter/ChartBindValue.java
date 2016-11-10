package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter;

import android.content.Context;

import com.orafaaraujo.rafaarch.model.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.engineTemperature.EngineTemperatureBinder;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.usage.UsageReportBinder;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

class ChartBindValue {

    static void bindView(Context context, ChartViewHolder viewHolder, ChartValue chartValue, ChartClickListener clickListener) {

        switch (chartValue.getType()) {
            case COMPARING:
                break;
            case COMPARING_BRANDS:
                break;
            case USAGE_REPORT:
                UsageReportBinder.getInstance(context).bind(chartValue, clickListener).into(viewHolder);
                break;
            case ENIGINE_TEMPERATURE:
                EngineTemperatureBinder.getInstance(context).bind(chartValue, clickListener).into(viewHolder);
                break;
            case ENIGINE_TEMPERATURE_FORECAST:
                break;
            case OSCILLATION:
                break;
            case OSCILLATION_FORECAST:
                break;
            case USE_PEAKS:
                break;
            default:
                break;
        }
    }


}
