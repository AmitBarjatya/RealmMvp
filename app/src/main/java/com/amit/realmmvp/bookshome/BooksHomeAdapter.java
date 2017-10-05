package com.amit.realmmvp.bookshome;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amit.realmmvp.R;
import com.amit.realmmvp.models.coreobjects.Book;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public class BooksHomeAdapter extends RecyclerView.Adapter<BooksHomeAdapter.BookHolder> {

    private RealmResults<Book> books;

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2,parent,false);
        return new BookHolder(view);
    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
        Book book = books.get(position);
        holder.tvName.setText(book.getName());
        holder.tvAuthor.setText(book.getAuthor());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(RealmResults<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    static class BookHolder extends RecyclerView.ViewHolder{
        @BindView(android.R.id.text1) TextView tvName;
        @BindView(android.R.id.text2) TextView tvAuthor;

        public BookHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
