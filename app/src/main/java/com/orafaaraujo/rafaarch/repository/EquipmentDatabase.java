package com.orafaaraujo.rafaarch.repository;

import com.orafaaraujo.rafaarch.component.Injector;
import com.orafaaraujo.rafaarch.model.equipment.Equipment;
import com.orafaaraujo.rafaarch.model.equipment.EquipmentType;
import com.orafaaraujo.rafaarch.model.usage.UsageRecord;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by rafael on 08/11/16.
 */

public class EquipmentDatabase {

    @Inject
    DatabaseRealm mDatabaseRealm;

    public EquipmentDatabase() {
        Injector.getApplicationComponent().inject(this);
    }

    public void createData() {

        Equipment equipment = new Equipment(1, "Treadmill 1", EquipmentType.TREADMILL);
        final Random random = new Random();
        for (int i = 0; i < 35; i++) {
            equipment.getUsageRecords().add(new UsageRecord(i, random.nextInt(6-2) + 2, random.nextInt(6-2) + 2));
        }

        mDatabaseRealm.add(equipment);
    }
}
