package com.amit.realmmvp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    void initRealm() {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
