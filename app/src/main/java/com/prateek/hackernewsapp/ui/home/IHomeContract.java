package com.prateek.hackernewsapp.ui.home;

import com.prateek.hackernewsapp.network.dto.Hit;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public interface IHomeContract {

    interface IHomeView {
        void loadResult(List<Hit> hitsArrayList);

        void loadNextResult(List<Hit> hitsArrayList);

        void startProgress();

        void stopProgress();

        void showError();
    }

    interface IHomePresenter {
        void onSearchAction(String value);

        void loadNextPage(String value);
    }
}