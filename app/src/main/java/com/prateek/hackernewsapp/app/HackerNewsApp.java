package com.prateek.hackernewsapp.app;

import android.app.Application;

import com.prateek.hackernewsapp.network.RetrofitClient;
import com.prateek.hackernewsapp.network.RetrofitService;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class HackerNewsApp extends Application {

    private static RetrofitService retrofitService;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public RetrofitService retrofitClient() {

        if (retrofitService == null) {
            retrofitService = new RetrofitClient().getClient();
        }

        return retrofitService;
    }
}