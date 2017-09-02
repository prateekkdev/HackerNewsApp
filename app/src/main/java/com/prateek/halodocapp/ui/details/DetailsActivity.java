package com.prateek.halodocapp.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.prateek.halodocapp.R;
import com.prateek.halodocapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    public static final String DETAILS_URL_KEY = "DETAILS_URL_KEY";

    ActivityDetailsBinding binding;

    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = getIntent().getStringExtra(DETAILS_URL_KEY);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        mWebview = binding.detailsWebView;

        mWebview.getSettings().setJavaScriptEnabled(true);

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(DetailsActivity.this, description, Toast.LENGTH_SHORT).show();
            }
        });

        if (TextUtils.isEmpty(url)) {
            mWebview.loadUrl("http://www.olacabs.com");
        } else {
            mWebview.loadUrl(url);
        }


    }

}
