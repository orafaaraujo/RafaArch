package com.orafaaraujo.rafaarch.presentation.helper.temperature;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by rafael on 06/11/16.
 */

public class TemperatureValueFormatter implements IAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return (int) value + "º";
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }
}
