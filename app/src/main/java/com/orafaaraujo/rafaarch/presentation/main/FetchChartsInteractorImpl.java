package com.orafaaraujo.rafaarch.presentation.main;


import android.os.Handler;

import com.orafaaraujo.rafaarch.entity.chart.Chart;

import java.util.Arrays;
import java.util.List;

import static com.orafaaraujo.rafaarch.entity.chart.ChartTypes.ENIGINE_TEMPERATURE;
import static com.orafaaraujo.rafaarch.entity.chart.ChartTypes.OSCILLATION;

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
        }, 500);
    }

    private List<Chart> createArrayList() {
        return Arrays.asList(new Chart("a", ENIGINE_TEMPERATURE), new Chart("b", OSCILLATION),
                new Chart("c", OSCILLATION), new Chart("d", OSCILLATION),
                new Chart("e", OSCILLATION), new Chart("f", ENIGINE_TEMPERATURE),
                new Chart("g", OSCILLATION), new Chart("h", OSCILLATION));
    }
}
