package com.orafaaraujo.rafaarch.presentation.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.ChartTypes;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.BlankViewHolder;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.EngineTempViewHolder;

/**
 * Created by rafael on 03/11/16.
 */

class ChartItemLayoutFactory {

    static ChartViewHolder getView(ChartTypes chartType, ViewGroup parent) {

        final ChartViewHolder chartViewHolder;
        final View inflate;

        switch (chartType) {
            case COMPARING:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            case COMPARING_BRANDS:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            case USAGE_REPORT:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            case ENIGINE_TEMPERATURE:
                inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item_engine_temperature, parent, false);
                chartViewHolder = new EngineTempViewHolder(inflate);
                break;
            case ENIGINE_TEMPERATURE_FORECAST:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            case OSCILLATION:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            case OSCILLATION_FORECAST:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            case USE_PEAKS:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
            default:
                chartViewHolder = new BlankViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_item, parent, false));
                break;
        }
        return chartViewHolder;
    }
}
