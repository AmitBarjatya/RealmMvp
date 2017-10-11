package com.amit.realmmvp.di;

import com.amit.realmmvp.booksadd.BooksAddNewContract;
import com.amit.realmmvp.booksadd.BooksAddNewPresenter;
import com.amit.realmmvp.models.RealmService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Amit Barjatya on 10/7/17.
 */

@Module
public class BooksAddNewModule {

    @Provides
    BooksAddNewContract.Presenter provideAddNewPresenter(RealmService realmService) {
        return new BooksAddNewPresenter(realmService);
    }
}
