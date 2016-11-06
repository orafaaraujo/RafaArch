package com.orafaaraujo.rafaarch.presentation.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.presentation.chart.ChartActivity;
import com.orafaaraujo.rafaarch.presentation.main.adapter.ChartAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.main_recycler_View)
    RecyclerView mRecyclerView;

    @BindView(R.id.main_progress)
    ProgressBar mProgressBar;

    private MainPresenter mPresenter;

    public static final String CHART_KEY = "CHART_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainPresenterImpl(this, new FetchChartsInteractorImpl());
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
    public void setupRecyclerView(List<Chart> charts) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ChartAdapter(this, charts, chart -> {

            Intent intent = new Intent(MainActivity.this, ChartActivity.class);
            intent.putExtra(CHART_KEY, new Gson().toJson(chart));
            startActivity(intent);

        }));
    }
}
