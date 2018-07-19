package com.udacity.gradle.builditbigger.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.Pair;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.BuildConfig;
import com.udacity.gradle.builditbigger.Contract.Contract;
import com.udacity.gradle.builditbigger.Model.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.Model.FreeModel;

import static android.content.Context.MODE_PRIVATE;

public class FreePresenter implements Contract.Presenter{
    private Contract.View view;
    private Context context;
    private FreeModel model;

//    private EndpointsAsyncTask task;
    private InterstitialAd mInterstitialAd;
    private SharedPreferences preferences;
    private final String PREFS_NAME = "preferences";


    public FreePresenter(Context context, Contract.View view ){
        this.view = view;
        this.context = context;
    }

    public void init(){
        model = new FreeModel(context, this);
        model.init();
    }

    @Override
    public void updateProgressBar(int status) {
        System.out.println("&&&&&Presenter update Bar");
        view.onUpdateProgressBar(status);
    }

    @Override
    public void tellJoke() {
        model.tellJoke();
    }
}
