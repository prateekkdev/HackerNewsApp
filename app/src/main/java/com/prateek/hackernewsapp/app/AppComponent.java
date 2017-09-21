package com.prateek.hackernewsapp.app;

import com.prateek.hackernewsapp.network.NetworkModule;
import com.prateek.hackernewsapp.ui.ControllerComponent;
import com.prateek.hackernewsapp.ui.home.HomeModule;

import dagger.Component;

/**
 * Created by prateek on 21/9/17.
 */

@Component(modules = {NetworkModule.class, AppModule.class})
@AppScope
public interface AppComponent {
    ControllerComponent createControllerComponent(HomeModule module);
}