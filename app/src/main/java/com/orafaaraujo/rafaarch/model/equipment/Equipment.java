package com.orafaaraujo.rafaarch.model.equipment;

import com.orafaaraujo.rafaarch.model.oscillation.OscillationRecord;
import com.orafaaraujo.rafaarch.model.temperature.TemperatureRecord;
import com.orafaaraujo.rafaarch.model.usage.UsageRecord;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rafael on 06/11/16.
 */

public class Equipment extends RealmObject {

    @PrimaryKey
    private int mId;

    private String mName;

    private String mEquipmentType;

    private RealmList<TemperatureRecord> temperatureRecords = new RealmList<>();

    private RealmList<UsageRecord> usageRecords = new RealmList<>();

    private RealmList<OscillationRecord> oscillationRecords = new RealmList<>();

    public Equipment() {
    }

    public Equipment(int id, String name, EquipmentType equipmentType) {
        mId = id;
        mName = name;
        equipmentType.toString();
    }

    public void setId(int id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        mEquipmentType = equipmentType.toString();
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public EquipmentType getEquipmentType() {
        return EquipmentType.valueOf(mEquipmentType);
    }

    public RealmList<TemperatureRecord> getTemperatureRecords() {
        return temperatureRecords;
    }

    public RealmList<UsageRecord> getUsageRecords() {
        return usageRecords;
    }

    public RealmList<OscillationRecord> getOscillationRecords() {
        return oscillationRecords;
    }
}
