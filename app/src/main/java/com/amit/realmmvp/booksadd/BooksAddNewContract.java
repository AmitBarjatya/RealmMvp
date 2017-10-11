package com.amit.realmmvp.booksadd;

import com.amit.realmmvp.mvpbase.MVPBasePresenter;

/**
 * A Contract that defines an MVP relationship between a view that is responsible for adding book feature
 * and a presenter that is responsible for all the logic/model related task for adding book feature
 * <p>
 * Created by Amit Barjatya on 10/5/17.
 */

public interface BooksAddNewContract {
    interface View {
        void onBookAdded();

        void showNameRequiredError();

        void showAuthorRequiredError();
    }

    interface Presenter extends MVPBasePresenter<BooksAddNewContract.View> {
        void addBook(String name, String author);
    }
}
