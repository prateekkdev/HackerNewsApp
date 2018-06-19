package com.prateek.hackernewsapp.app;

import android.content.Context;

import com.prateek.hackernewsapp.network.NetworkModule;
import com.prateek.hackernewsapp.network.RetrofitService;
import com.prateek.hackernewsapp.ui.news.NewsComponent;
import com.prateek.hackernewsapp.ui.news.NewsModule;
import com.prateek.hackernewsapp.ui.news.home.HomeComponent;
import com.prateek.hackernewsapp.ui.news.home.HomeModule;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by prateek on 21/9/17.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppModule.class})
public interface AppComponent {
    NewsComponent plusNewsComponent(NewsModule newsModule);
}