package com.prateek.hackernewsapp.app;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prateek on 21/9/17.
 */

@Module
@AppScope
public class AppModule {

    private Context context;

    AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @Provides
    @AppScope
    Context provideAppContext() {
        return context;
    }

}
