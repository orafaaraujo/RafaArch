package com.orafaaraujo.rafaarch.presentation.ui.chartlist;

/**
 * Created by rafael on 01/11/16.
 */

public interface ChartListPresenter {

    void setView(ChartListView chartListView);

    void onResume();

    void onDestroy();
}
