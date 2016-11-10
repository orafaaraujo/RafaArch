package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.usage;

import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.charts.LineChart;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

import butterknife.BindView;

/**
 * Created by rafael on 03/11/16.
 */

public class UsageReportViewHolder extends ChartViewHolder {

    @BindView(R.id.chart_engine_usage_out_button)
    public ImageButton outButton;

    @BindView(R.id.chart_engine_usage_chart)
    public LineChart chart;

    public UsageReportViewHolder(View itemView) {
        super(itemView);
    }

}
