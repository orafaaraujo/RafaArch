package com.orafaaraujo.rafaarch.presentation.main;


import com.orafaaraujo.rafaarch.entity.chart.Chart;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class MainPresenterImpl implements MainPresenter, FetchChartsInteractor.OnFinishedListener {

    private MainView mMainView;
    private FetchChartsInteractor mFetchChartsInteractor;

    public MainPresenterImpl(MainView mainView, FetchChartsInteractor FetchChartsInteractor) {
        mMainView = mainView;
        mFetchChartsInteractor = FetchChartsInteractor;
    }

    @Override
    public void onResume() {
        if (mMainView != null) {
            mMainView.showProgress();
        }
        mFetchChartsInteractor.fetchChart(this);
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onFinished(List<Chart> charts) {
        if (mMainView != null) {
            mMainView.hideProgress();
            mMainView.setupRecyclerView(charts);
        }
    }
}
