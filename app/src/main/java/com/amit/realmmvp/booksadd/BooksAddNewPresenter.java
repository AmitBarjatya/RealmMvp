package com.amit.realmmvp.booksadd;

import com.amit.realmmvp.models.RealmService;

/**
 * A presenter that follows the BooksAddNewContract.Presenter contract
 * to add a new book to persistent storage and perform validation on inputs
 * <p>
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksAddNewPresenter implements BooksAddNewContract.Presenter {

    BooksAddNewContract.View mView;
    RealmService mRealmService;

    public BooksAddNewPresenter(RealmService realmService) {
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

    /**
     * Method to save a new Book instance to persistent storage
     * Validates that the Book name is not empty
     * Validates that the name of the Author of the Book is also not empty
     * If validated, save the Book and notifies the view
     *
     * @param name   The name of the book
     * @param author The name of the author of the book
     */
    @Override
    public void addBook(String name, String author) {
        if (name == null || name.isEmpty()) {
            mView.showNameRequiredError();
            return;
        } else if (author == null || author.isEmpty()) {
            mView.showAuthorRequiredError();
            return;
        }

        mRealmService.addBook(name, author);
        mView.onBookAdded();
    }
}
