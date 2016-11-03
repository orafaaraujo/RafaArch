package com.orafaaraujo.rafaarch.presentation.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.ChartTypes;

/**
 * Created by rafael on 03/11/16.
 */

public class ChartItemLayoutFactory {

    public static ChartAdapter.ViewHolder getView(ChartTypes chartTypes, ViewGroup parent) {

        int layoutId = R.layout.chart_item;

        switch (chartTypes) {
            case COMPARING:
                break;
            case COMPARING_BRANDS:
                break;
            case USAGE_REPORT:
                break;
            case ENIGINE_TEMPERATURE:
                break;
            case ENIGINE_TEMPERATURE_FORECAST:
                break;
            case OSCILLATION:
                break;
            case OSCILLATION_FORECAST:
                break;
            case USE_PEAKS:
                break;
        }
        return new ChartAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }
}
