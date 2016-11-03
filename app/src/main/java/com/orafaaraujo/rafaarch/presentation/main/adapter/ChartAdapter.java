package com.orafaaraujo.rafaarch.presentation.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.orafaaraujo.rafaarch.R;
import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.entity.chart.ChartTypes;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {

    private List<Chart> mCharts;

    public ChartAdapter(List<Chart> charts) {
        mCharts = charts;
    }

    @Override
    public ChartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ChartItemLayoutFactory.getView(ChartTypes.values()[viewType], parent);
    }

    @Override
    public void onBindViewHolder(ChartAdapter.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

        }
        Chart chart = mCharts.get(position);
        if (chart != null) {
            holder.title.setText(chart.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mCharts != null ? mCharts.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mCharts.get(position).getType().getId();
    }

   public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.chart_item_title)
        TextView title;

        @BindView(R.id.chart_item_chart)
        BarChart barChart;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}
