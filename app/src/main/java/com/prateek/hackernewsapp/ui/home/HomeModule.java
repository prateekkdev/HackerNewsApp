package com.prateek.hackernewsapp.ui.home;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.prateek.hackernewsapp.network.RetrofitService;
import com.prateek.hackernewsapp.ui.ActivityScope;
import com.prateek.hackernewsapp.ui.home.HomeActivity;
import com.prateek.hackernewsapp.ui.home.HomePresenter;
import com.prateek.hackernewsapp.ui.home.IHomeContract;
import com.prateek.hackernewsapp.ui.home.SearchResultAdapter;

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
    @ActivityScope
    HomePresenter provideHomePresenter(RetrofitService retrofitService) {
        return new HomePresenter(activity, retrofitService);
    }

    @Provides
    @ActivityScope
    SearchResultAdapter provideSearchResultAdapter() {
        return new SearchResultAdapter();
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(activity);
    }
}