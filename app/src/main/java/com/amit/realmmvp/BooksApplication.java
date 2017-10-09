package com.amit.realmmvp;

import android.app.Application;

import com.amit.realmmvp.models.migration.Migration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksApplication extends Application {

    AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        initRealm();
    }

    void initComponent(){
        mComponent = DaggerAppComponent.builder()
                .build();
    }

    void initRealm() {
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .migration(new Migration())
                .schemaVersion(Migration.VERSION)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public AppComponent getmComponent() {
        return mComponent;
    }

    public void setmComponent(AppComponent mComponent) {
        this.mComponent = mComponent;
    }
}
