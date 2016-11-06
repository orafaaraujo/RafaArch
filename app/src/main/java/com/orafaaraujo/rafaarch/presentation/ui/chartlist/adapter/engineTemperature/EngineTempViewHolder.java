package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.engineTemperature;

import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.BarChart;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

import butterknife.BindView;

/**
 * Created by rafael on 03/11/16.
 */

public class EngineTempViewHolder extends ChartViewHolder {

    @BindView(R.id.chart_engine_temperature_out_button)
    public ImageButton outButton;

    @BindView(R.id.chart_engine_temperature_chart)
    public BarChart chart;

    public EngineTempViewHolder(View itemView) {
        super(itemView);
    }

}
