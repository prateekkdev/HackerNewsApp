package com.prateek.hackernewsapp.ui.news.home;

import android.support.v7.widget.LinearLayoutManager;

import com.prateek.hackernewsapp.network.RetrofitService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prateek on 21/9/17.
 */

@Module
public class HomeModule {

    private HomeActivity activity;

    HomeModule(HomeActivity activity) {
        this.activity = activity;
    }

    @Provides
    IHomeContract.IHomePresenter provideHomePresenter(RetrofitService retrofitService) {
        return new HomePresenter(activity, retrofitService);
    }

    @Provides
    SearchResultAdapter provideSearchResultAdapter() {
        return new SearchResultAdapter();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(activity);
    }
}