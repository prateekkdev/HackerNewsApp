package com.prateek.halodocapp.ui.home;

import com.prateek.halodocapp.network.dto.Hit;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public interface IHomeContract {

    interface IHomeView {
        void searchResult(List<Hit> hitsArrayList);
    }

    interface IHomePresenter {
        void onSearchAction(String value);
    }
}