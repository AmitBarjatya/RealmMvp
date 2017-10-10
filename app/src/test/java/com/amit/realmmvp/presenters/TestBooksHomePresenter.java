package com.amit.realmmvp.presenters;

import com.amit.realmmvp.bookshome.BooksHomeContract;
import com.amit.realmmvp.bookshome.BooksHomePresenter;
import com.amit.realmmvp.models.RealmService;
import com.amit.realmmvp.models.coreobjects.Book;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Amit Barjatya on 10/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestBooksHomePresenter {

    @Mock
    BooksHomeContract.View mView;

    @Mock
    RealmService mRealmService;

    BooksHomeContract.Presenter presenter;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new BooksHomePresenter(mRealmService);
    }

    /**
     * Test that when this presenter's setview is called
     * it fetched the book list from realm service
     * and it then passes it on to the view
     */
    @Test
    public void testPresenterCallsViewsShowBooksAfterSetView(){

        presenter.setView(mView);

        verify(mRealmService).getAllBooks();
        verify(mView).showBooks(anyList());
    }

    /**
     * Test that when this presenter's onAddBookClicked method is called
     * it calls the views gotoAddBookView method
     */
    @Test
    public void testPresenterCallsViewsAddBookWhenFabIsClicked(){

        presenter.setView(mView);
        presenter.onAddBookClicked();

        verify(mView).gotoAddNewBook();
    }
}
