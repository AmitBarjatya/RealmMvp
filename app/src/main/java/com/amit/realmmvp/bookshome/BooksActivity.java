package com.amit.realmmvp.bookshome;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.amit.realmmvp.R;
import com.amit.realmmvp.models.coreobjects.Book;
import com.amit.realmmvp.mvpbase.MVPBaseView;

import io.realm.RealmResults;

public class BooksActivity extends MVPBaseView implements BooksHomeContract.View {

    RecyclerView rv;
    BooksHomeAdapter mAdapter;
    BooksHomeContract.Presenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecyclerView();
        initFab();
        mPresenter = new BooksHomePresenter();
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

    void initRecyclerView() {
        rv = findViewById(R.id.rv_books);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        mAdapter = new BooksHomeAdapter();
    }

    void initFab() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.onAddBookClicked();
            }
        });
    }


    @Override
    public void showBooks(RealmResults<Book> books) {
        mAdapter.setBooks(books);
    }

    @Override
    public void gotoAddNewBook() {
        Toast.makeText(this, "Action to go to add new book activity", Toast.LENGTH_SHORT).show();
    }
}
