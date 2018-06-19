package com.prateek.hackernewsapp.ui.news;

import com.prateek.hackernewsapp.app.AppComponent;
import com.prateek.hackernewsapp.ui.news.details.DetailsComponent;
import com.prateek.hackernewsapp.ui.news.details.DetailsModule;
import com.prateek.hackernewsapp.ui.news.home.HomeComponent;
import com.prateek.hackernewsapp.ui.news.home.HomeModule;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent
@Component(modules = NewsModule.class)
public interface NewsComponent {
    HomeComponent plusHomeComponent(HomeModule homeModule);
    DetailsComponent plusDetailsComponent(DetailsModule detailsModule);
}
