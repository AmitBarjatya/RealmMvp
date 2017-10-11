package com.amit.realmmvp.bookshome;

import com.amit.realmmvp.models.coreobjects.Book;
import com.amit.realmmvp.mvpbase.MVPBasePresenter;

import java.util.List;

/**
 * A Contract that defines an MVP relationship between a view that is responsible for showing all books
 * and a presenter that is responsible for all the logic/model related task for showing all books
 * <p>
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
