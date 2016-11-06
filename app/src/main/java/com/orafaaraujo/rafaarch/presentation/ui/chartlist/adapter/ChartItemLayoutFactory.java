package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.ChartType;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.engineTemperature.EngineTempViewHolder;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.BlankViewHolder;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

class ChartItemLayoutFactory {

    static ChartViewHolder getView(ChartType chartType, ViewGroup parent) {

        final ChartViewHolder chartViewHolder;

        switch (chartType) {
            case COMPARING:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            case COMPARING_BRANDS:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            case USAGE_REPORT:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            case ENIGINE_TEMPERATURE:
                chartViewHolder = new EngineTempViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item_engine_temperature, parent, false));
                break;
            case ENIGINE_TEMPERATURE_FORECAST:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            case OSCILLATION:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            case OSCILLATION_FORECAST:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            case USE_PEAKS:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
            default:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.chart_item, parent, false));
                break;
        }
        return chartViewHolder;
    }
}
