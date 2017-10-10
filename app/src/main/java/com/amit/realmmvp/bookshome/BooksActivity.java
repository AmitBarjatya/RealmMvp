package com.amit.realmmvp.bookshome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.amit.realmmvp.BooksApplication;
import com.amit.realmmvp.R;
import com.amit.realmmvp.booksadd.BooksAddNewActivity;
import com.amit.realmmvp.models.coreobjects.Book;
import com.amit.realmmvp.mvpbase.MVPBaseView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

public class BooksActivity extends MVPBaseView implements BooksHomeContract.View {

    @BindView(R.id.rv_books) RecyclerView rv;

    BooksHomeAdapter mAdapter;

    @Inject BooksHomeContract.Presenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        ButterKnife.bind(this);
        ((BooksApplication) getApplication()).getmComponent()
                .inject(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecyclerView();
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
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        mAdapter = new BooksHomeAdapter();
        rv.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab) void onFabClick() {
        mPresenter.onAddBookClicked();
    }


    @Override
    public void showBooks(List<Book> books) {
        mAdapter.setBooks(books);
    }

    @Override
    public void gotoAddNewBook() {
        Intent intent = new Intent(this, BooksAddNewActivity.class);
        startActivity(intent);
    }
}
