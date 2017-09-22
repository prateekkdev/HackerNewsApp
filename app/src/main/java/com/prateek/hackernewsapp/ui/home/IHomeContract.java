package com.prateek.hackernewsapp.ui.home;

import com.prateek.hackernewsapp.network.dto.Hit;
import com.prateek.hackernewsapp.ui.IBaseContract;

import java.util.List;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public interface IHomeContract {

    interface IHomeView extends IBaseContract.IBaseView {
        void loadResult(List<Hit> hitsArrayList);

        void loadNextResult(List<Hit> hitsArrayList);
    }

    interface IHomePresenter extends IBaseContract.IBasePresenter {
        void onSearchAction(String value);

        void loadNextPage(String value);
    }
}