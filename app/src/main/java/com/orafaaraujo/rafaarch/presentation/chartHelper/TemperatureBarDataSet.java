package com.orafaaraujo.rafaarch.presentation.chartHelper;

import android.graphics.Color;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.List;

/**
 * Created by rafael on 06/11/16.
 */

public class TemperatureBarDataSet extends BarDataSet {

    public TemperatureBarDataSet(List<BarEntry> yVals, String label) {
        super(yVals, label);
    }

    @Override
    public int getColor(int index) {
        // if temperature is above 40º set red, otherwise green.
        if (getEntryForIndex(index).getY() > 40) {
            return Color.rgb(255, 121, 74);
        } else {
            return Color.rgb(116, 197, 89);
        }
    }
}
