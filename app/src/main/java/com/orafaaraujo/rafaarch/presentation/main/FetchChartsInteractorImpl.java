package com.orafaaraujo.rafaarch.presentation.main;


import android.os.Handler;

import com.orafaaraujo.rafaarch.entity.chart.Chart;

import java.util.Arrays;
import java.util.List;

import static com.orafaaraujo.rafaarch.entity.chart.ChartTypes.ENIGINE_TEMPERATURE;

/**
 * Created by rafael on 01/11/16.
 */

public class FetchChartsInteractorImpl implements FetchChartsInteractor {

    @Override
    public void fetchChart(final OnFinishedListener listener) {

        // To emulate a loading.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createArrayList());
            }
        }, 2000);
    }

    private List<Chart> createArrayList() {
        return Arrays.asList(new Chart("a", ENIGINE_TEMPERATURE), new Chart("b", ENIGINE_TEMPERATURE), new Chart("c", ENIGINE_TEMPERATURE), new Chart("d", ENIGINE_TEMPERATURE),
                new Chart("e", ENIGINE_TEMPERATURE), new Chart("f", ENIGINE_TEMPERATURE), new Chart("g", ENIGINE_TEMPERATURE), new Chart("h", ENIGINE_TEMPERATURE));
    }
}
