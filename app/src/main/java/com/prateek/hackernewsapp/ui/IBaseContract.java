package com.prateek.hackernewsapp.ui;

/**
 * Created by prateek on 22/9/17.
 */

public interface IBaseContract {

    interface IBaseView {
        void startProgress();

        void stopProgress();

        void showError();

        void hideKeyboard();
    }

    interface IBasePresenter {

        void onCreate();

        void onStart();

        void onResume();

        void onPause();

        void onStop();
    }

}
