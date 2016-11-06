package com.orafaaraujo.rafaarch.entity.temperature;

/**
 * Created by rafael on 06/11/16.
 */

public class TemperatureRecord {

    private final long mTime;
    private final int mValue;

    public TemperatureRecord(long time, int value) {
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
