package com.orafaaraujo.rafaarch.component.module;

import com.orafaaraujo.rafaarch.repository.DatabaseRealm;
import com.orafaaraujo.rafaarch.repository.EquipmentDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rafael on 07/11/16.
 */
@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseRealm() {
        return new DatabaseRealm();
    }

    @Provides
    @Singleton
    public EquipmentDatabase provideDatabaseData() {
        return new EquipmentDatabase();
    }
}
