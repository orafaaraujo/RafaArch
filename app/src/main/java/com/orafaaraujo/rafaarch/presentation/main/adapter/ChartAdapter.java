package com.orafaaraujo.rafaarch.presentation.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.orafaaraujo.rafaarch.entity.chart.Chart;
import com.orafaaraujo.rafaarch.entity.chart.ChartTypes;
import com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes.ChartViewHolder;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartAdapter extends RecyclerView.Adapter<ChartViewHolder> {

    private final ChartClickListener mClickListener;
    private List<Chart> mCharts;

    public ChartAdapter(List<Chart> charts, ChartClickListener clickListener) {
        mCharts = charts;
        mClickListener = clickListener;
    }

    @Override
    public ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ChartItemLayoutFactory.getView(ChartTypes.values()[viewType], parent);
    }

    @Override
    public void onBindViewHolder(ChartViewHolder holder, int position) {
        ChartBindValue.bindView(holder, mCharts.get(position), mClickListener);
    }

    @Override
    public int getItemCount() {
        return mCharts != null ? mCharts.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mCharts.get(position).getType().getId();
    }
}
