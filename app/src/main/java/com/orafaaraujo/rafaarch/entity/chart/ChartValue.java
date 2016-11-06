package com.orafaaraujo.rafaarch.entity.chart;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartValue {

    private final ChartType mType;

    private final List<ChartItem> mItems;

    public ChartValue(ChartType type, List<ChartItem> items) {
        mType = type;
        mItems = items;
    }

    public ChartType getType() {
        return mType;
    }

    public List<ChartItem> getItems() {
        return mItems;
    }
}