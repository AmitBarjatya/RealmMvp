package com.amit.realmmvp.booksadd;

import android.text.TextUtils;

import com.amit.realmmvp.models.RealmService;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksAddNewPresenter implements BooksAddNewContract.Presenter{

    BooksAddNewContract.View mView;
    RealmService mRealmService;

    public BooksAddNewPresenter(RealmService realmService){
        this.mRealmService = realmService;
    }

    public void setView(BooksAddNewContract.View view) {
        this.mView = view;
    }

    @Override
    public void clearView() {
        this.mView = null;
        mRealmService.closeRealm();
    }

    @Override
    public void addBook(String name, String author) {
        if (name == null || name.isEmpty()){
            mView.showNameRequiredError();
            return;
        }else if(author == null || author.isEmpty()){
            mView.showAuthorRequiredError();
            return;
        }

        mRealmService.addBook(name,author);
        mView.onBookAdded();
    }
}
