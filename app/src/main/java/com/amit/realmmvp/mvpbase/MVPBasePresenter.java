package com.amit.realmmvp.mvpbase;

/**
 * A Base interface which all of MVP presenters should implement
 * <p>
 * Created by Amit Barjatya on 10/5/17.
 */

public interface MVPBasePresenter<T> {
    void setView(T view);

    void clearView();
}
