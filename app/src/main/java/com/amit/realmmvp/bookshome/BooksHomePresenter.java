package com.amit.realmmvp.bookshome;

import com.amit.realmmvp.models.RealmService;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksHomePresenter implements BooksHomeContract.Presenter {

    BooksHomeContract.View mView;
    RealmService mRealmService;

    public BooksHomePresenter(){
    }

    public void setView(BooksHomeContract.View view) {
        this.mView = view;
        mRealmService = new RealmService();
        mView.showBooks(mRealmService.getAllBooks());
    }

    @Override
    public void clearView() {
        this.mView = null;
        mRealmService.closeRealm();
    }

    @Override
    public void onAddBookClicked() {
        mView.gotoAddNewBook();
    }
}
