package com.orafaaraujo.rafaarch.entity.chart;

/**
 * Created by rafael on 01/11/16.
 */

public class Chart implements ChartItem {

    private final String mTitle;

    private final ChartTypes mType;

    public Chart(String title, ChartTypes type) {
        mTitle = title;
        mType = type;
    }

    public String getTitle() {
        return mTitle;
    }

    public ChartTypes getType() {
        return mType;
    }
}