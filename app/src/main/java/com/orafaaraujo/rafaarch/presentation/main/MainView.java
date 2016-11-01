package com.orafaaraujo.rafaarch.presentation.main;

import com.orafaaraujo.rafaarch.entity.Chart;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setupRecyclerView(List<Chart> charts);


}
