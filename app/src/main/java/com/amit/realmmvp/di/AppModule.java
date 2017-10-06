package com.amit.realmmvp.di;

import android.app.Application;

import com.amit.realmmvp.BooksApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amit Barjatya on 10/7/17.
 */

@Module
public class AppModule {
    BooksApplication mApp;

    public AppModule(BooksApplication app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    BooksApplication providesApplication(){
        return mApp;
    }
}
