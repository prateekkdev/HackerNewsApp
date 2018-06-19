package com.prateek.hackernewsapp.ui.news;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    @Provides
    NewsModel provideNewsModel() {
        return new NewsModel("This object is local singleton");
    }
}