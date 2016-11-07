package com.orafaaraujo.rafaarch.component;

import com.orafaaraujo.rafaarch.RafaArchApplication;
import com.orafaaraujo.rafaarch.component.module.ApplicationContextModule;
import com.orafaaraujo.rafaarch.component.module.RepositoryModule;
import com.orafaaraujo.rafaarch.presentation.ui.chartlist.ChartListActivity;
import com.orafaaraujo.rafaarch.repository.DatabaseRealm;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rafael on 07/11/16.
 */

@Singleton
@Component(modules = {ApplicationContextModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    void inject(RafaArchApplication application);

    void inject(ChartListActivity activity);

    void inject(DatabaseRealm databaseRealm);

}
