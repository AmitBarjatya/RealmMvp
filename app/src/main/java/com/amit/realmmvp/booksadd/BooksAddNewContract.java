package com.amit.realmmvp.booksadd;

import com.amit.realmmvp.mvpbase.MVPBasePresenter;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public interface BooksAddNewContract {
    interface View{
        void onBookAdded();
        void showNameRequiredError();
        void showAuthorRequiredError();
    }

    interface Presenter extends MVPBasePresenter<BooksAddNewContract.View>{
        void addBook(String name,String author);
    }
}
