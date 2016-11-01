package com.orafaaraujo.rafaarch.presentation.main;


import com.orafaaraujo.rafaarch.entity.Chart;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public interface FetchChartsInteractor {

    interface OnFinishedListener {
        void onFinished(List<Chart> charts);
    }

    void fetchChart(OnFinishedListener listener);
}
