package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.ui.chart.ChartActivity;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.ChartAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChartListActivity extends AppCompatActivity implements ChartListView {

    public static final String CHART_KEY = "CHART_KEY";
    @BindView(R.id.chartlist_recycler_View)
    RecyclerView mRecyclerView;
    @BindView(R.id.chartlist_progress)
    ProgressBar mProgressBar;
    private ChartListPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chartlist);
        ButterKnife.bind(this);
        mPresenter = new ChartListPresenterImpl(this, new FetchChartsInteractorImpl());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setupRecyclerView(List<ChartValue> chartValues) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ChartAdapter(this, chartValues, chart -> {

            Intent intent = new Intent(ChartListActivity.this, ChartActivity.class);
            intent.putExtra(CHART_KEY, new Gson().toJson(chart));
            startActivity(intent);

        }));
    }
}
