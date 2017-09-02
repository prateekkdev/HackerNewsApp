package com.prateek.halodocapp.ui.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.prateek.halodocapp.R;
import com.prateek.halodocapp.app.HalodocApp;
import com.prateek.halodocapp.databinding.ActivityHomeBinding;
import com.prateek.halodocapp.network.dto.Hit;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    public static final String TAG = "Halodoc, HomeActivity";

    private IHomeContract.IHomePresenter homePresenter;

    private ActivityHomeBinding binding;

    private SearchResultAdapter resultAdapter;

    private LinearLayoutManager mLayoutManager;

    boolean mIsLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        homePresenter = new HomePresenter(this, ((HalodocApp) this.getApplication()).retrofitClient());

        resultAdapter = new SearchResultAdapter();

        mLayoutManager = new LinearLayoutManager(this);

        binding.homeRecyclerview.addOnScrollListener(mScrollListener);
        binding.homeRecyclerview.setLayoutManager(mLayoutManager);
        binding.homeRecyclerview.setAdapter(resultAdapter);


        binding.homeBtnSearch.setOnClickListener(view -> {

            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(binding.homeBtnSearch.getWindowToken(), 0);

            homePresenter.onSearchAction(binding.homeTxtSearch.getText().toString());
        });

    }

    @Override
    public void loadResult(List<Hit> hitsList) {
        resultAdapter.updateData(hitsList);
        binding.homeRecyclerview.scrollToPosition(0);
    }

    public void loadNextResult(List<Hit> hitsList) {
        resultAdapter.updateData(hitsList);
    }

    RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (mIsLoading) {
                return;
            }
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();
            if (pastVisibleItems + visibleItemCount  - 5 >= totalItemCount) {
                homePresenter.loadNextPage(binding.homeTxtSearch.getText().toString());
            }
        }
    };

    @Override
    public void startProgress() {
        binding.mainProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgress() {
        binding.mainProgress.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(HomeActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
    }

}