package com.prateek.halodocapp.ui.home;

import com.prateek.halodocapp.network.dto.Hit;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public interface IHomeContract {

    interface IHomeView {
        void showResult(List<Hit> hitsArrayList);

        void startProgress();

        void stopProgress();

        void showError();
    }

    interface IHomePresenter {
        void onSearchAction(String value);

        void loadNextPage(String value);
    }
}