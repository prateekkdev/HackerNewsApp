package com.prateek.hackernewsapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prateek.hackernewsapp.app.AppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prateek on 21/9/17.
 */

@Module
@AppScope
public class NetworkModule {

    @AppScope
    @Provides
    public RetrofitService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }

    @AppScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(RetrofitService.SERVICE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @AppScope
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @AppScope
    @Provides
    public Gson provideGson() {
        return new GsonBuilder().create();
    }
}