package com.orafaaraujo.rafaarch.entity.chart;

/**
 * Created by rafael on 01/11/16.
 */

public enum ChartTypes {
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

    ChartTypes(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

}