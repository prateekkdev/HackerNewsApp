package com.prateek.hackernewsapp.app;

import android.app.Application;

import com.prateek.hackernewsapp.ui.news.NewsComponent;
import com.prateek.hackernewsapp.ui.news.NewsModule;
import com.prateek.hackernewsapp.ui.news.details.DetailsComponent;
import com.prateek.hackernewsapp.ui.news.home.HomeComponent;
import com.prateek.hackernewsapp.ui.news.home.HomeModule;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class App extends Application {

    private AppComponent appComponent;
    private NewsComponent newsComponent;
    private HomeComponent homeComponent;
    private DetailsComponent detailsComponent;

    public AppComponent appComponent() {
        return appComponent;
    }

    public NewsComponent newsComponent() {
        if(newsComponent == null) {
            newsComponent = appComponent().plusNewsComponent(new NewsModule());
        }
        return newsComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}