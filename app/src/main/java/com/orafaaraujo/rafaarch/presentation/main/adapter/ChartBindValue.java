package com.orafaaraujo.rafaarch.presentation.main.adapter;

import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.presentation.main.adapter.binds.EngineTemperatureBinder;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

class ChartBindValue {

    static void bindView(ChartViewHolder viewHolder, Chart chart, ChartClickListener clickListener) {

        switch (chart.getType()) {
            case COMPARING:
                break;
            case COMPARING_BRANDS:
                break;
            case USAGE_REPORT:
                break;
            case ENIGINE_TEMPERATURE:
                EngineTemperatureBinder.getInstance().bind(chart, clickListener).into(viewHolder);
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
