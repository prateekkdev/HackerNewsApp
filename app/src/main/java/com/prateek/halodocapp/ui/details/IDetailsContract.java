package com.prateek.halodocapp.ui.details;

/**
 * Created by prateek.kesarwani on 02/09/17.
 */

public interface IDetailsContract {

    interface IDetailsView {
        void startProgress();

        void stopProgress();

        void showError();

        void initWebView();
    }

    interface IDetailsPresenter {

    }
}