package com.amit.realmmvp.di;

import com.amit.realmmvp.booksadd.BooksAddNewActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Amit Barjatya on 10/7/17.
 */
@Singleton
@Component(modules = {BooksAddNewModule.class,RealmModule.class})
public interface BooksAddNewComponent {
    void inject(BooksAddNewActivity activity);
}
