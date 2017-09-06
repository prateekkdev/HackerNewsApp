package com.prateek.hackernewsapp.ui.home;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.prateek.hackernewsapp.R;
import com.prateek.hackernewsapp.app.HackerNewsApp;
import com.prateek.hackernewsapp.databinding.ActivityHomeBinding;
import com.prateek.hackernewsapp.network.dto.Hit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class HomeActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    public static final String TAG = "Halodoc, HomeActivity";
    boolean mIsLoading;
    private IHomeContract.IHomePresenter homePresenter;
    private ActivityHomeBinding binding;
    private SearchResultAdapter resultAdapter;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (mIsLoading) {
                return;
            }
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition();
            if (pastVisibleItems + visibleItemCount - 5 >= totalItemCount) {
                homePresenter.loadNextPage(binding.homeTxtSearch.getText().toString());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        homePresenter = new HomePresenter(this, ((HackerNewsApp) this.getApplication()).retrofitClient());

        resultAdapter = new SearchResultAdapter();

        mLayoutManager = new LinearLayoutManager(this);

        binding.homeRecyclerview.addOnScrollListener(mScrollListener);
        binding.homeRecyclerview.setLayoutManager(mLayoutManager);
        binding.homeRecyclerview.setAdapter(resultAdapter);

        binding.homeBtnSearch.setOnClickListener(view -> homePresenter.onSearchAction(binding.homeTxtSearch.getText().toString()));

        getSearchQueryWhenTextChange().subscribe(str -> homePresenter.onSearchAction(str));
    }

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(binding.homeBtnSearch.getWindowToken(), 0);
    }


    Observable<String> getSearchQueryWhenTextChange() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

                binding.homeTxtSearch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        e.onNext(charSequence.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
            }
        }).filter(str -> str.length() > 3)
                .debounce(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void loadResult(List<Hit> hitsList) {
        resultAdapter.updateData(hitsList);
        binding.homeRecyclerview.scrollToPosition(0);
    }

    public void loadNextResult(List<Hit> hitsList) {
        resultAdapter.updateData(hitsList);
    }

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