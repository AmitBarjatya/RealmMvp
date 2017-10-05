package com.amit.realmmvp.booksadd;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amit.realmmvp.R;
import com.amit.realmmvp.mvpbase.MVPBaseView;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksAddNewActivity extends MVPBaseView implements BooksAddNewContract.View {

    EditText edBookName;
    EditText edBookAuthor;
    Button btnAddBook;

    BooksAddNewContract.Presenter mPresenter;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);
        mPresenter = new BooksAddNewPresenter();
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

    void initViews() {
        edBookName = findViewById(R.id.ed_book_name);
        edBookAuthor = findViewById(R.id.ed_book_author);
        edBookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0){
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
                if (charSequence.length() > 0){
                    edBookAuthor.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnAddBook = findViewById(R.id.btn_add_book);
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edBookName.getText().toString();
                String author = edBookAuthor.getText().toString();
                mPresenter.addBook(name,author);
            }
        });

    }

    @Override
    public void showNameRequiredError() {
        edBookName.setError("This is required");
    }

    @Override
    public void showAuthorRequiredError() {
        edBookAuthor.setError("This is required");
    }

    @Override
    public void onBookAdded() {
        Toast.makeText(this, "Book Added Successfully", Toast.LENGTH_SHORT).show();
        edBookName.setText("");
        edBookAuthor.setText("");
    }
}
