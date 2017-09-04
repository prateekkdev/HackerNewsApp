package com.prateek.hackernewsapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public class RetrofitClient {

    public RetrofitClient() {

    }

    public RetrofitService getClient() {
        return service(retrofit(okHttpClient(), gson()));
    }

    private RetrofitService service(Retrofit retrofit) {
        return retrofit.create(RetrofitService.class);
    }

    private Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(RetrofitService.SERVICE_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    private Gson gson() {
        return new GsonBuilder().create();
    }

}
