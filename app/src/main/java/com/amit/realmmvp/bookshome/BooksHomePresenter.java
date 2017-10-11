package com.amit.realmmvp.bookshome;

import com.amit.realmmvp.models.RealmService;

/**
 * A presenter that follows the BooksHomeContract.Presenter contract
 * to get all the books from persistent storage and pass them on to the view
 * <p>
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksHomePresenter implements BooksHomeContract.Presenter {

    BooksHomeContract.View mView;
    RealmService mRealmService;

    public BooksHomePresenter(RealmService realmService) {
        this.mRealmService = realmService;
    }

    /**
     * When the view is active get all the books from the storage and ask the view to show them
     *
     * @param view
     */
    public void setView(BooksHomeContract.View view) {
        this.mView = view;
        mView.showBooks(mRealmService.getAllBooks());
    }

    /**
     * Clear the view reference this presenter is holding
     * Also close the realm instance
     */
    @Override
    public void clearView() {
        this.mView = null;
        mRealmService.closeRealm();
    }

    /**
     * ask the view to go to AddNewBookActivity
     */
    @Override
    public void onAddBookClicked() {
        mView.gotoAddNewBook();
    }
}
