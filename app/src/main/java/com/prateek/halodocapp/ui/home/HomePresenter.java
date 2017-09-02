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

    private int currentPage;

    public HomePresenter(IHomeContract.IHomeView homeView, RetrofitService service) {
        this.service = service;
        this.homeView = homeView;
    }

    @Override
    public void onSearchAction(String value) {
        Log.e(TAG, "Starting network request with value: " + value);
        resetCurrentPage();
        search(value, 0);
    }

    private void resetCurrentPage() {
        currentPage = 0;
    }

    private void search(String value, int page) {
        service.listResults(value, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> homeView.startProgress())
                .doOnTerminate(() -> homeView.stopProgress())
                .subscribe(results -> {
                            Log.e(TAG, "Network Success, total hits: " + results.getHits().size());
                            homeView.searchResult(results.getHits());
                        }
                        , throwable -> {
                            Log.e(TAG, "Network Error: " + throwable.getMessage());
                            homeView.showError();
                        });
    }

    @Override
    public void loadNextPage(String value) {
        search(value, ++currentPage);
    }
}
