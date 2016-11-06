package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import com.orafaaraujo.rafaarch.entity.chart.ChartValue;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartListPresenterImpl implements ChartListPresenter, FetchChartsInteractor.OnFinishedListener {

    private ChartListView mChartListView;
    private FetchChartsInteractor mFetchChartsInteractor;

    public ChartListPresenterImpl(ChartListView chartListView, FetchChartsInteractor FetchChartsInteractor) {
        mChartListView = chartListView;
        mFetchChartsInteractor = FetchChartsInteractor;
    }

    @Override
    public void onResume() {
        if (mChartListView != null) {
            mChartListView.showProgress();
        }
        mFetchChartsInteractor.fetchChart(this);
    }

    @Override
    public void onDestroy() {
        mChartListView = null;
    }

    @Override
    public void onFinished(List<ChartValue> chartValues) {
        if (mChartListView != null) {
            mChartListView.hideProgress();
            mChartListView.setupRecyclerView(chartValues);
        }
    }
}
