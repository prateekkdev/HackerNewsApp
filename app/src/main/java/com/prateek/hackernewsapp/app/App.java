package com.prateek.hackernewsapp.app;

import android.app.Application;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponenet() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}