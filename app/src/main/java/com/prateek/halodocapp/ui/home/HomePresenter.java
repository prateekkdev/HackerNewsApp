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

    private RetrofitService service;

    public HomePresenter(RetrofitService service) {
        this.service = service;
    }

    @Override
    public void onSearchAction(String value) {
        service.listResults("news", 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> Log.e(TAG, "Size: " + results.getHits().size())
                        , throwable -> Log.e(TAG, throwable.getMessage()));
    }
}
