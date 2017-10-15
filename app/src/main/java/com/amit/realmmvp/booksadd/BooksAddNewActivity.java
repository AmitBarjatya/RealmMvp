package com.amit.realmmvp.booksadd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amit.realmmvp.BooksApplication;
import com.amit.realmmvp.R;
import com.amit.realmmvp.mvpbase.MVPBaseView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Activity to add a new Book to the persistent storage
 * It follows the MVP pattern and obeys the BooksAddNewContract
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksAddNewActivity extends MVPBaseView implements BooksAddNewContract.View {

    @BindView(R.id.ed_book_name)
    EditText edBookName;
    @BindView(R.id.ed_book_author)
    EditText edBookAuthor;
    @BindView(R.id.btn_add_book)
    Button btnAddBook;
    @Inject
    BooksAddNewContract.Presenter mPresenter;

    /**
     * when the add button is clicked
     * get the values in form fields and pass them on to presenter for validation checks
     * and to save them if validation is successful
     */
    @OnClick(R.id.btn_add_book)
    void addBook() {
        String name = edBookName.getText().toString();
        String author = edBookAuthor.getText().toString();
        mPresenter.addBook(name, author);
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);
        ButterKnife.bind(this);
        ((BooksApplication) getApplication()).getmComponent()
                .inject(this);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        mPresenter.clearView();
        super.onStop();
    }

    /**
     * initialize views and also:
     * 1. attach text change listeners on edittext fields to
     * hide error message when their values are changed
     */
    void initViews() {
        edBookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    edBookName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edBookAuthor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    edBookAuthor.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * when validation fails because of book's name
     * show an error message on the screen next to name text field
     */
    @Override
    public void showNameRequiredError() {
        edBookName.setError(getString(R.string.activity_booksaddnew_field_is_required));
    }

    /**
     * when validation fails because of book's author
     * show an error message on the screen next to author text field
     */
    @Override
    public void showAuthorRequiredError() {
        edBookAuthor.setError(getString(R.string.activity_booksaddnew_field_is_required));
    }

    /**
     * when validation is successful
     * show an feedback message on the screen telling the user that it was successful
     */
    @Override
    public void onBookAdded() {
        Toast.makeText(this, R.string.activity_booksaddnew_book_add_success, Toast.LENGTH_SHORT).show();
        edBookAuthor.setText(null);
        edBookName.setText(null);
    }
}
