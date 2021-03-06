package com.prateek.hackernewsapp.ui.news.home;

import android.util.Log;

import com.prateek.hackernewsapp.network.RetrofitService;
import com.prateek.hackernewsapp.network.dto.Hit;
import com.prateek.hackernewsapp.ui.BasePresenter;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class HomePresenter extends BasePresenter implements IHomeContract.IHomePresenter {

    public static final String TAG = "HN, HomePresenter";

    private IHomeContract.IHomeView homeView;

    private RetrofitService service;

    private int currentPage;

    private ArrayList<Hit> listItems;

    public HomePresenter(IHomeContract.IHomeView homeView, RetrofitService service) {
        this.service = service;
        this.homeView = homeView;

        this.listItems = new ArrayList<>();
    }

    @Override
    public void onSearchAction(String value) {
        Log.e(TAG, "Starting network request with value: " + value);
        resetCurrentPage();
        search(value, 0);
    }

    private void resetCurrentPage() {
        currentPage = 0;
        homeView.hideKeyboard();
    }

    private void search(String value, int page) {
        service.listResults(value, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> homeView.startProgress())
                .doOnTerminate(() -> homeView.stopProgress())
                .subscribe(results -> {
                            Log.e(TAG, "Network Success, total hits: " + results.getHits().size());

                            if (page == 0) {
                                listItems = results.getHits();
                                homeView.loadResult(listItems);
                            } else {
                                listItems.addAll(results.getHits());
                                homeView.loadNextResult(listItems);
                            }
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