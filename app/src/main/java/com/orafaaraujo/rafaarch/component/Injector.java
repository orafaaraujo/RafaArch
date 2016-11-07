package com.orafaaraujo.rafaarch.component;

import com.orafaaraujo.rafaarch.RafaArchApplication;
import com.orafaaraujo.rafaarch.component.module.ApplicationContextModule;
import com.orafaaraujo.rafaarch.component.module.RepositoryModule;

import java.util.Objects;

/**
 * Created by rafael on 07/11/16.
 */

public class Injector {

    private static ApplicationComponent applicationComponent;

    private Injector() {
    }

    public static void initializeApplicationComponent(RafaArchApplication application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(application))
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        Objects.requireNonNull(applicationComponent, "applicationComponent is null");
        return applicationComponent;
    }
}
