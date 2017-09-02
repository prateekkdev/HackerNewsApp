package com.prateek.halodocapp.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.prateek.halodocapp.R;
import com.prateek.halodocapp.app.HalodocApp;
import com.prateek.halodocapp.network.RetrofitService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG = "Halodoc, HomeActivity";

    IHomeContract.IHomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RetrofitService retrofitService = ((HalodocApp) this.getApplication()).retrofitClient();

        homePresenter = new HomePresenter();

    }
}