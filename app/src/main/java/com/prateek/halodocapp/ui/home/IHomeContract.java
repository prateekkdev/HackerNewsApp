package com.prateek.halodocapp.ui.home;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public interface IHomeContract {

    interface IHomeView {
        void searchResult();
    }

    interface IHomePresenter {
        void onSearchAction(String value);
    }
}