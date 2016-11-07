package com.orafaaraujo.rafaarch.model.chart;

/**
 * Created by rafael on 01/11/16.
 */

public enum ChartType {
    COMPARING(0),
    COMPARING_BRANDS(1),
    USAGE_REPORT(2),
    ENIGINE_TEMPERATURE(3),
    ENIGINE_TEMPERATURE_FORECAST(4),
    OSCILLATION(5),
    OSCILLATION_FORECAST(6),
    USE_PEAKS(7);

    /**
     * Id to use on RecyclerView.
     */
    private int mId;

    ChartType(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

}