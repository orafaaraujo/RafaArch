package com.orafaaraujo.rafaarch.model.usage;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rafael on 08/11/16.
 */

public class UsageRecord extends RealmObject {

    @PrimaryKey
    private long mTime;

    private int mValue;

    private int mAverage;

    public UsageRecord() {
    }

    public UsageRecord(long time, int value, int average) {
        mTime = time;
        mValue = value;
        mAverage = average;
    }

    public long getTime() {
        return mTime;
    }

    public int getValue() {
        return mValue;
    }

    public int getAverage() {
        return mAverage;
    }
}
