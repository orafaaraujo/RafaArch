package com.orafaaraujo.rafaarch.component.module;

import android.content.Context;

import com.orafaaraujo.rafaarch.RafaArchApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rafael on 07/11/16.
 */
@Module
public class ApplicationContextModule {

    private final RafaArchApplication mApplication;

    public ApplicationContextModule(RafaArchApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public RafaArchApplication application() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Context applicationContext() {
        return mApplication.getApplicationContext();
    }

}
