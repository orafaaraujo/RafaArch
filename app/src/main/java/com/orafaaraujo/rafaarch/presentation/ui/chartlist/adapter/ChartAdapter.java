package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.orafaaraujo.rafaarch.entity.chart.ChartType;
import com.orafaaraujo.rafaarch.entity.chart.ChartValue;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes.ChartViewHolder;

import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class ChartAdapter extends RecyclerView.Adapter<ChartViewHolder> {

    private final Context mContext;
    private final ChartClickListener mClickListener;
    private final List<ChartValue> mChartValues;

    public ChartAdapter(Context context, List<ChartValue> chartValues, ChartClickListener clickListener) {
        mContext = context;
        mChartValues = chartValues;
        mClickListener = clickListener;
    }

    @Override
    public ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ChartItemLayoutFactory.getView(ChartType.values()[viewType], parent);
    }

    @Override
    public void onBindViewHolder(ChartViewHolder holder, int position) {
        ChartBindValue.bindView(mContext, holder, mChartValues.get(position), mClickListener);
    }

    @Override
    public int getItemCount() {
        return mChartValues != null ? mChartValues.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mChartValues.get(position).getType().getId();
    }
}
