package com.orafaaraujo.rafaarch.model.temperature;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rafael on 06/11/16.
 */

public class TemperatureRecord extends RealmObject {

    @PrimaryKey
    private long mTime;

    private int mValue;

    public TemperatureRecord() {
    }

    public TemperatureRecord(long time, int value) {
        mTime = time;
        mValue = value;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public void setValue(int value) {
        mValue = value;
    }

    public long getTime() {
        return mTime;
    }

    public int getValue() {
        return mValue;
    }

}
