package com.orafaaraujo.rafaarch;

import android.app.Application;

import com.orafaaraujo.rafaarch.component.Injector;
import com.orafaaraujo.rafaarch.repository.DatabaseRealm;
import com.orafaaraujo.rafaarch.repository.EquipmentDatabase;

import javax.inject.Inject;

/**
 * Created by rafael on 07/11/16.
 */

public class RafaArchApplication extends Application {

    @Inject
    DatabaseRealm mDatabaseRealm;

    @Inject
    EquipmentDatabase mEquipmentDatabase;

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
        mDatabaseRealm.setup();
        mEquipmentDatabase.createData();
    }
}
