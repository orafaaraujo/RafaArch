package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import com.orafaaraujo.rafaarch.model.chart.ChartItem;
import com.orafaaraujo.rafaarch.model.chart.ChartType;
import com.orafaaraujo.rafaarch.model.chart.ChartValue;
import com.orafaaraujo.rafaarch.model.equipment.Equipment;
import com.orafaaraujo.rafaarch.repository.DatabaseRealm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 01/11/16.
 */

public class FetchChartsInteractorImpl implements FetchChartsInteractor {

    @Override
    public void fetchChart(DatabaseRealm realm, final OnFinishedListener listener) {

        // TODO fix Rx solution
//        realm.findAll(Equipment.class)
//                .flatMapIterable(equipments -> equipments)
//                .map(Equipment::getTemperatureRecords)
//                .asObservable()
//                .flatMapIterable(temperatures -> temperatures)
//                .map(temperature -> new ChartItem(temperature.getTime(), temperature.getValue()))
//                .toList()
//                .map(chartItem -> new ChartValue(ChartType.ENIGINE_TEMPERATURE, chartItem))
//                .toList()
//                .subscribe(listener::onFinished);


        realm.findAll(Equipment.class)
                .subscribe(equipments -> {
                            final List<ChartValue> chartValues = new ArrayList<>(1);
                            final List<ChartItem> usageReport = new ArrayList<>(equipments.get(0).getUsageRecords().size());
                            final List<ChartItem> averageReport = new ArrayList<>(equipments.get(0).getUsageRecords().size());
                            equipments.get(0).getUsageRecords().stream().forEach(tr -> {
                                usageReport.add(new ChartItem(tr.getTime(), tr.getValue()));
                                averageReport.add(new ChartItem(tr.getTime(), tr.getAverage()));
                            });
                            chartValues.add(new ChartValue(ChartType.USAGE_REPORT, usageReport, averageReport));
                            listener.onFinished(chartValues);
                        },
                        throwable -> {
                            // do nothing
                        });

    }
}