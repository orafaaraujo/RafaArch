package com.orafaaraujo.rafaarch;

import android.app.Application;

import com.orafaaraujo.rafaarch.component.Injector;
import com.orafaaraujo.rafaarch.model.equipment.Equipment;
import com.orafaaraujo.rafaarch.model.equipment.EquipmentType;
import com.orafaaraujo.rafaarch.model.temperature.TemperatureRecord;
import com.orafaaraujo.rafaarch.repository.DatabaseRealm;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by rafael on 07/11/16.
 */

public class RafaArchApplication extends Application {

    @Inject
    DatabaseRealm databaseRealm;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        initRealm();
    }

    protected void initDagger() {
        Injector.initializeApplicationComponent(this);
        Injector.getApplicationComponent().inject(this);
    }

    protected void initRealm() {
        databaseRealm.setup();

        Equipment equipment = new Equipment();
        equipment.setName("Treadmill 1");
        equipment.setEquipmentType(EquipmentType.TREADMILL);

        final Random random = new Random();
        for (int i = 7; i < 25; i++) {
            equipment.getTemperatureRecords().add(new TemperatureRecord(i, random.nextInt(45)));
        }


//        databaseRealm.add(equipment);
    }
}
