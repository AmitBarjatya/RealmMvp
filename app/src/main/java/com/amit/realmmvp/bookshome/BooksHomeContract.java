package com.amit.realmmvp.bookshome;

import com.amit.realmmvp.models.coreobjects.Book;
import com.amit.realmmvp.mvpbase.MVPBasePresenter;

import io.realm.RealmResults;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

interface BooksHomeContract {
    interface View {
        void showBooks(RealmResults<Book> books);
        void gotoAddNewBook();
    }

    interface Presenter extends MVPBasePresenter<BooksHomeContract.View> {
        void onAddBookClicked();
    }
}
