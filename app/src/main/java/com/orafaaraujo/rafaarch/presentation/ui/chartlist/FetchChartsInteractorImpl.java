package com.orafaaraujo.rafaarch.presentation.ui.chartlist;


import android.os.Handler;

import com.orafaaraujo.rafaarch.model.chart.ChartItem;
import com.orafaaraujo.rafaarch.model.chart.ChartType;
import com.orafaaraujo.rafaarch.model.chart.ChartValue;
import com.orafaaraujo.rafaarch.model.equipment.Equipment;
import com.orafaaraujo.rafaarch.model.equipment.EquipmentType;
import com.orafaaraujo.rafaarch.model.temperature.TemperatureRecord;
import com.orafaaraujo.rafaarch.repository.DatabaseRealm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rafael on 01/11/16.
 */

public class FetchChartsInteractorImpl implements FetchChartsInteractor {

    @Override
    public void fetchChart(DatabaseRealm realm, final OnFinishedListener listener) {


        
        new Handler().postDelayed(() -> listener.onFinished(createArrayList()), 500);
    }

    private List<ChartValue> createArrayList() {

        // TODO Mock data!
        final Equipment equipment = new Equipment("Tredmill 1", EquipmentType.TREADMILL);
        final Random random = new Random();
        for (int i = 7; i < 25; i++) {
            equipment.getTemperatureRecords().add(new TemperatureRecord(i, random.nextInt(45)));
        }

        final List<ChartValue> chartValues = new ArrayList<>(1);
        final List<ChartItem> temperatureItems = new ArrayList<>(equipment.getTemperatureRecords().size());
        equipment.getTemperatureRecords().stream().forEach(tr -> {
            temperatureItems.add(new ChartItem(tr.getTime(), tr.getValue()));
        });
        chartValues.add(new ChartValue(ChartType.ENIGINE_TEMPERATURE, temperatureItems));

        return chartValues;
    }
}
