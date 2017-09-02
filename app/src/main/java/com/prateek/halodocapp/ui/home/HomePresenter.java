package com.prateek.halodocapp.ui.home;

import android.util.Log;

import com.prateek.halodocapp.network.RetrofitService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class HomePresenter implements IHomeContract.IHomePresenter {

    public static final String TAG = "Halodoc, HomePresenter";

    private IHomeContract.IHomeView homeView;

    private RetrofitService service;

    public HomePresenter(IHomeContract.IHomeView homeView, RetrofitService service) {
        this.service = service;
        this.homeView = homeView;
    }

    @Override
    public void onSearchAction(String value) {

        Log.e(TAG, "Starting network request with value: " + value);

        service.listResults(value, 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                            Log.e(TAG, "Network Success, total hits: " + results.getHits().size());
                            homeView.searchResult(results.getHits());
                        }
                        , throwable -> Log.e(TAG, "Network Error: " + throwable.getMessage()));
    }
}
