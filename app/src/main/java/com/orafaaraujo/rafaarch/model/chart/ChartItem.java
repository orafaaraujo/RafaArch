package com.orafaaraujo.rafaarch.model.chart;

/**
 * Created by rafael on 06/11/16.
 */

public class ChartItem {

    private final long mTime;
    private final int mValue;

    public ChartItem(long time, int value) {
        mTime = time;
        mValue = value;
    }

    public long getTime() {
        return mTime;
    }

    public int getValue() {
        return mValue;
    }
}
