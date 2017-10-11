package com.amit.realmmvp.di;

import com.amit.realmmvp.bookshome.BooksHomeContract;
import com.amit.realmmvp.bookshome.BooksHomePresenter;
import com.amit.realmmvp.models.RealmService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amit Barjatya on 10/7/17.
 */
@Module
public class BooksHomeModule {

    @Provides
    BooksHomeContract.Presenter provideBooksHomePresenter(RealmService realmService) {
        return new BooksHomePresenter(realmService);
    }

}
