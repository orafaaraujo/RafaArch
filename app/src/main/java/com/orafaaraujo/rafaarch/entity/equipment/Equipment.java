package com.orafaaraujo.rafaarch.entity.equipment;

import com.orafaaraujo.rafaarch.entity.temperature.TemperatureRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafael on 06/11/16.
 */

public class Equipment {

    private final String mName;
    private final EquipmentType mEquipmentType;
    private final List<TemperatureRecord> temperatureRecords = new ArrayList<>(0);

    public Equipment(String name, EquipmentType equipmentType) {
        mName = name;
        mEquipmentType = equipmentType;
    }

    public String getName() {
        return mName;
    }

    public EquipmentType getEquipmentType() {
        return mEquipmentType;
    }

    public List<TemperatureRecord> getTemperatureRecords() {
        return temperatureRecords;
    }
}
