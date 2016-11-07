package com.orafaaraujo.rafaarch.presentation.ui.chartlist;

import com.orafaaraujo.rafaarch.model.chart.ChartValue;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public interface ChartListView {

    void showProgress();

    void hideProgress();

    void setupRecyclerView(List<ChartValue> chartValues);


}
