package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import com.orafaaraujo.rafaarch.entity.chart.ChartValue;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public interface FetchChartsInteractor {

    void fetchChart(OnFinishedListener listener);

    interface OnFinishedListener {
        void onFinished(List<ChartValue> chartValues);
    }
}
