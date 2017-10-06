package com.amit.realmmvp.di;

import com.amit.realmmvp.bookshome.BooksActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Amit Barjatya on 10/7/17.
 */
@Singleton
@Component(modules = {BooksHomeModule.class,RealmModule.class})
public interface BooksHomeComponent {
    void inject(BooksActivity activity);
}
