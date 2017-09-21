package com.prateek.hackernewsapp.ui;

import com.prateek.hackernewsapp.app.AppComponent;
import com.prateek.hackernewsapp.ui.home.HomeActivity;
import com.prateek.hackernewsapp.ui.home.HomeModule;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by prateek on 21/9/17.
 */

@Subcomponent(modules = HomeModule.class)
@ActivityScope
public interface ControllerComponent {
    void inject(HomeActivity homeActivity);
}