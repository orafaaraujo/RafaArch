package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import com.orafaaraujo.rafaarch.model.chart.ChartValue;
import com.orafaaraujo.rafaarch.repository.DatabaseRealm;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public interface FetchChartsInteractor {

    void fetchChart(DatabaseRealm realm, OnFinishedListener listener);

    interface OnFinishedListener {
        void onFinished(List<ChartValue> chartValues);
    }
}
