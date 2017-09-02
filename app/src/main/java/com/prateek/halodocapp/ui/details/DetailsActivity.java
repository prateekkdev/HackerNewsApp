package com.prateek.halodocapp.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.prateek.halodocapp.R;
import com.prateek.halodocapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity implements IDetailsContract.IDetailsView {

    public static final String DETAILS_URL_KEY = "DETAILS_URL_KEY";

    private ActivityDetailsBinding binding;

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getStringExtra(DETAILS_URL_KEY);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        mWebview = binding.detailsWebView;

        // These should be exported to Presenter.

        initWebView();
        startProgress();
        if (TextUtils.isEmpty(url)) {
            mWebview.loadUrl("http://www.olacabs.com");
        } else {
            mWebview.loadUrl(url);
        }
    }

    @Override
    public void initWebView() {

        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                stopProgress();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                showError();
            }
        });
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
        Toast.makeText(DetailsActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
    }


}
