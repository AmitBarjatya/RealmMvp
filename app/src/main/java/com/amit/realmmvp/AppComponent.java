package com.amit.realmmvp;

import com.amit.realmmvp.booksadd.BooksAddNewActivity;
import com.amit.realmmvp.bookshome.BooksActivity;
import com.amit.realmmvp.di.AppModule;
import com.amit.realmmvp.di.BooksAddNewModule;
import com.amit.realmmvp.di.BooksHomeModule;
import com.amit.realmmvp.di.RealmModule;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by Amit Barjatya on 10/8/17.
 */

@Component(modules = {AppModule.class, BooksHomeModule.class,
        BooksAddNewModule.class, RealmModule.class})
public interface AppComponent {
    void inject(BooksActivity activity);
    void inject(BooksAddNewActivity activity);
}
