package com.amit.realmmvp.bookshome;

import com.amit.realmmvp.models.coreobjects.Book;
import com.amit.realmmvp.mvpbase.MVPBasePresenter;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public interface BooksHomeContract {
    interface View {
        void showBooks(List<Book> books);
        void gotoAddNewBook();
    }

    interface Presenter extends MVPBasePresenter<BooksHomeContract.View> {
        void onAddBookClicked();
    }
}
