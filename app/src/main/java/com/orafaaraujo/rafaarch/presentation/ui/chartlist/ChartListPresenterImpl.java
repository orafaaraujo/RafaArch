package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import com.orafaaraujo.rafaarch.repository.DatabaseRealm;

import javax.inject.Inject;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartListPresenterImpl implements ChartListPresenter {

    private DatabaseRealm mRealm;
    private ChartListView mChartListView;
    private FetchChartsInteractor mFetchChartsInteractor;

    @Inject
    public ChartListPresenterImpl(DatabaseRealm realm) {
        mFetchChartsInteractor = new FetchChartsInteractorImpl();
        mRealm = realm;
    }

    @Override
    public void setView(ChartListView chartListView) {
        mChartListView = chartListView;
    }

    @Override
    public void onResume() {
        if (mChartListView != null) {
            mChartListView.showProgress();
        }
        mFetchChartsInteractor.fetchChart(mRealm, chartValues -> {
            mChartListView.hideProgress();
            mChartListView.setupRecyclerView(chartValues);
        });
    }

    @Override
    public void onDestroy() {
        mChartListView = null;
    }
}
