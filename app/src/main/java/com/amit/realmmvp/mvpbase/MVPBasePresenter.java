package com.amit.realmmvp.mvpbase;

/**
 * Created by Amit Barjatya on 10/5/17.
 */

public interface MVPBasePresenter<T> {
    void setView(T view);
    void clearView();
}
