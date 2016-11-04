package com.orafaaraujo.rafaarch.presentation.main.adapter.viewholdes;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by rafael on 03/11/16.
 */

public class ChartViewHolder  extends RecyclerView.ViewHolder {

    public ChartViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
