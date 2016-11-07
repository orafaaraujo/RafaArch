package com.orafaaraujo.rafaarch.repository;

import android.content.Context;

import com.orafaaraujo.rafaarch.component.Injector;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import rx.Observable;

/**
 * Created by rafael on 07/11/16.
 */

public class DatabaseRealm {

    @Inject
    Context mContext;

    RealmConfiguration realmConfiguration;

    public DatabaseRealm() {
        Injector.getApplicationComponent().inject(this);
    }

    public void setup() {
        if (realmConfiguration == null) {
            Realm.init(mContext);
            realmConfiguration = new RealmConfiguration.Builder().build();
            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            throw new IllegalStateException("database already configured");
        }
    }

    public Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public <T extends RealmObject> T add(T model) {
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        realm.copyToRealm(model);
        realm.commitTransaction();
        return model;
    }

    public <T extends RealmObject> Observable<RealmResults<T>> findAll(Class<T> clazz) {
        return getRealmInstance().where(clazz).findAllAsync().asObservable();
    }

    public void close() {
        getRealmInstance().close();
    }
}