package com.prateek.halodocapp.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.prateek.halodocapp.R;
import com.prateek.halodocapp.app.HalodocApp;
import com.prateek.halodocapp.databinding.ActivityHomeBinding;
import com.prateek.halodocapp.network.dto.Hit;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    public static final String TAG = "Halodoc, HomeActivity";

    IHomeContract.IHomePresenter homePresenter;

    ActivityHomeBinding binding;

    SearchResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        homePresenter = new HomePresenter(this, ((HalodocApp) this.getApplication()).retrofitClient());

        resultAdapter = new SearchResultAdapter();

        binding.homeRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.homeRecyclerview.setAdapter(resultAdapter);

        binding.homeBtnSearch.setOnClickListener(view -> homePresenter.onSearchAction(binding.homeTxtSearch.getText().toString()));
    }

    @Override
    public void searchResult(List<Hit> hitsList) {

        resultAdapter.updateData(hitsList);
    }
}