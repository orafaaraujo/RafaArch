package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.binds;

import android.support.annotation.NonNull;

import com.orafaaraujo.rafaarch.entity.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.ChartClickListener;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

/**
 * Created by rafael on 04/11/16.
 */

public interface ChartBinderInterface {

    ChartBinderInterface bind(@NonNull ChartValue chartValue, @NonNull ChartClickListener clickListener);

    ChartBinderInterface into(@NonNull ChartViewHolder viewHolder);

}
