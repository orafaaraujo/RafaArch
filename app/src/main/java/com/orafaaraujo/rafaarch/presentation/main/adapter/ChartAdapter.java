package com.orafaaraujo.rafaarch.presentation.main.adapter;

import android.content.Context;
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

    private final Context mContext;
    private final ChartClickListener mClickListener;
    private final List<Chart> mCharts;

    public ChartAdapter(Context context, List<Chart> charts, ChartClickListener clickListener) {
        mContext = context;
        mCharts = charts;
        mClickListener = clickListener;
    }

    @Override
    public ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ChartItemLayoutFactory.getView(ChartTypes.values()[viewType], parent);
    }

    @Override
    public void onBindViewHolder(ChartViewHolder holder, int position) {
        ChartBindValue.bindView(mContext, holder, mCharts.get(position), mClickListener);
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
