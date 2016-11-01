package com.orafaaraujo.rafaarch.presentation.main;


import android.os.Handler;

import com.orafaaraujo.rafaarch.entity.Chart;

import java.util.Arrays;
import java.util.List;

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
        return Arrays.asList(new Chart("a"), new Chart("b"), new Chart("c"), new Chart("d"),
                new Chart("e"), new Chart("f"), new Chart("g"), new Chart("h"));
    }
}
