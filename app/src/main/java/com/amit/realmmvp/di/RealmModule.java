package com.amit.realmmvp.di;

import com.amit.realmmvp.models.RealmService;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Amit Barjatya on 10/7/17.
 */
@Module
public class RealmModule {

    @Provides
    Realm provideRealm(){
        return Realm.getDefaultInstance();
    }

    @Provides
    RealmService provideRealmService(){
        return new RealmService();
    }
}
