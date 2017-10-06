package com.amit.realmmvp.models;

import com.amit.realmmvp.models.coreobjects.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class RealmService {
    Realm mRealm;

    public RealmService(){
        mRealm = Realm.getDefaultInstance();
    }

    public RealmResults<Book> getAllBooks(){
        if (mRealm.isClosed())
            mRealm = Realm.getDefaultInstance();
        return mRealm.where(Book.class).findAllSorted("id");
    }

    public void addBook(final String name, final String author){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                long size = realm.where(Book.class).count();
                Book book = realm.createObject(Book.class,size);
                book.setAuthor(author);
                book.setName(name);
            }
        });
    }

    public void closeRealm() {
        mRealm.close();
    }
}
