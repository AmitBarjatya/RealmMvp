package com.amit.realmmvp.models;

import com.amit.realmmvp.models.coreobjects.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A persistent storage wrapper service class to provide data to different presenter
 * <p>
 * Created by Amit Barjatya on 10/5/17.
 */

public class RealmService {
    Realm mRealm;


    public RealmService() {
        mRealm = Realm.getDefaultInstance();
    }

    /**
     * Get all books from the database sorted by their id
     *
     * @return RealmResults<Book> list of all books in database
     */
    public RealmResults<Book> getAllBooks() {
        if (mRealm.isClosed())
            mRealm = Realm.getDefaultInstance();
        return mRealm.where(Book.class).findAllSorted("id");
    }

    /**
     * Create a new book in database
     *
     * @param name   Name of the book
     * @param author Author of the book
     */
    public void addBook(final String name, final String author) {
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                long size = realm.where(Book.class).count();
                Book book = realm.createObject(Book.class, size);
                book.setAuthor(author);
                book.setName(name);
            }
        });
    }

    /**
     * Close this database instance
     */
    public void closeRealm() {
        mRealm.close();
    }
}
