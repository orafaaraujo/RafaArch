package com.orafaaraujo.rafaarch.presentation.main.adapter.binds;

import android.support.annotation.NonNull;

import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.presentation.main.adapter.ChartClickListener;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;

/**
 * Created by rafael on 04/11/16.
 */

public interface ChartBinderInterface {

    ChartBinderInterface bind(@NonNull Chart chart, ChartClickListener clickListener);

    ChartBinderInterface into(@NonNull ChartViewHolder viewHolder);

    void apply();
}
