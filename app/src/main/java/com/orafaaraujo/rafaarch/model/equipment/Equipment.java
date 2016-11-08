package com.orafaaraujo.rafaarch.model.equipment;

import com.orafaaraujo.rafaarch.model.oscillation.OscillationRecord;
import com.orafaaraujo.rafaarch.model.temperature.TemperatureRecord;
import com.orafaaraujo.rafaarch.model.usage.UsageRecord;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by rafael on 06/11/16.
 */

public class Equipment extends RealmObject {

    private String mName;

    private String mEquipmentType;

    private RealmList<TemperatureRecord> temperatureRecords = new RealmList<>();
    private RealmList<UsageRecord> usageRecords = new RealmList<>();
    private RealmList<OscillationRecord> oscillationRecords = new RealmList<>();

    public Equipment() {
    }

    public void setName(String name) {
        mName = name;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        mEquipmentType = equipmentType.toString();
    }

    public String getName() {
        return mName;
    }

    public EquipmentType getEquipmentType() {
        return EquipmentType.valueOf(mEquipmentType);
    }

    public List<TemperatureRecord> getTemperatureRecords() {
        return temperatureRecords;
    }

    public RealmList<UsageRecord> getUsageRecords() {
        return usageRecords;
    }

    public RealmList<OscillationRecord> getOscillationRecords() {
        return oscillationRecords;
    }
}
