package com.amit.realmmvp.presenters;

import android.text.TextUtils;

import com.amit.realmmvp.booksadd.BooksAddNewContract;
import com.amit.realmmvp.booksadd.BooksAddNewPresenter;
import com.amit.realmmvp.models.RealmService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Created by Amit Barjatya on 10/10/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class TestBooksAddNewPresenter {

    @Mock
    BooksAddNewContract.View mView;

    @Mock
    RealmService realmService;

    @Mock
    TextUtils textUtils;

    BooksAddNewContract.Presenter mPresenter;

    /**
     * Before starting a test
     * Make a new instance of the presenter with mocked dependencies
     * Also set the mocked view
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new BooksAddNewPresenter(realmService);
        mPresenter.setView(mView);
    }

    /**
     * When a invalid input for name is given
     * Test that the view's showNameRequired method gets called
     */
    @Test
    public void testAddBookReturnsErrorWhenNameIsInvalid() {
        String name = "";
        String author = "someAuthor";

        mPresenter.addBook(name, author);

        verify(mView).showNameRequiredError();
    }

    /**
     * When a invalid input for author is given
     * Test that the view's showAuthorRequired method gets called
     */
    @Test
    public void testAddBookReturnsErrorWhenAuthorIsInvalid() {
        String name = "someName";
        String author = "";

        mPresenter.addBook(name, author);

        verify(mView).showAuthorRequiredError();
    }

    /**
     * When a valid input for name and author is given
     * Test that the realm service's add book method gets called
     * Test that the view's books added method gets called
     */
    @Test
    public void testAddBookWorksForValidNameAndAuthor() {
        String name = "someName";
        String author = "someAuthor";

        mPresenter.addBook(name, author);

        verify(realmService).addBook(name, author);
        verify(mView, atLeastOnce()).onBookAdded();
    }

}
