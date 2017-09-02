package com.prateek.halodocapp.app;

import android.app.Application;

import com.prateek.halodocapp.network.RetrofitClient;
import com.prateek.halodocapp.network.RetrofitService;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class HalodocApp extends Application {

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