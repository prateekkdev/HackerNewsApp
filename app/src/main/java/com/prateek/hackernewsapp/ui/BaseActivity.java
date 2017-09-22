package com.prateek.hackernewsapp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

import com.prateek.hackernewsapp.ui.IBaseContract;

/**
 * Created by prateek on 22/9/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseContract.IBaseView {

    @Override
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }
}