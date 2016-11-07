package com.orafaaraujo.rafaarch.model.temperature;

import io.realm.RealmObject;

/**
 * Created by rafael on 06/11/16.
 */

public class TemperatureRecord extends RealmObject {

    private long mTime;
    private int mValue;

    public TemperatureRecord() {
    }

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
