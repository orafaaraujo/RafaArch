package com.orafaaraujo.rafaarch.presentation.ui.chartlist.adapter.viewholdes;

import android.view.View;
import android.widget.TextView;

import com.orafaaraujo.rafaarch.R;

import butterknife.BindView;

/**
 * Created by rafael on 03/11/16.
 */

public class BlankViewHolder extends ChartViewHolder {

    @BindView(R.id.chart_item_title)
    TextView title;

    public BlankViewHolder(View itemView) {
        super(itemView);
    }

}
