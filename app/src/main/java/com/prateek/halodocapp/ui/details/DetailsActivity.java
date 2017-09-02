package com.prateek.halodocapp.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prateek.halodocapp.R;
import com.prateek.halodocapp.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        // binding.detailsWebView.load

        binding.detailsWebView.loadUrl("http://www.google.com");
    }

}
