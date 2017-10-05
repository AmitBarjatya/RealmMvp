package com.amit.realmmvp.bookshome;

import com.amit.realmmvp.models.RealmService;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksHomePresenter implements BooksHomeContract.Presenter {

    BooksHomeContract.View mView;
    RealmService mRealmService;

    public BooksHomePresenter(){
        mRealmService = new RealmService();
    }

    public void setView(BooksHomeContract.View view) {
        this.mView = view;
        mView.showBooks(mRealmService.getAllBooks());
    }

    @Override
    public void clearView() {
        this.mView = null;
    }

    @Override
    public void onAddBookClicked() {
        mView.gotoAddNewBook();
    }
}
