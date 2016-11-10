package com.orafaaraujo.rafaarch.model.chart;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartValue {

    private final ChartType mType;

    private final List<ChartItem> mItems;

    private final List<ChartItem> mAverageItems;

    public ChartValue(ChartType type, List<ChartItem> items, List<ChartItem> averageItems) {
        mType = type;
        mItems = items;
        mAverageItems = averageItems;
    }

    public ChartType getType() {
        return mType;
    }

    public List<ChartItem> getItems() {
        return mItems;
    }

    public List<ChartItem> getAverageItems() {
        return mAverageItems;
    }
}