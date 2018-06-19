package com.prateek.hackernewsapp.ui.news.home;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by prateek on 21/9/17.
 */

@Subcomponent
@Component(modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}