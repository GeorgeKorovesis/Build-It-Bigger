package com.udacity.gradle.builditbigger.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.Pair;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.BuildConfig;
import com.udacity.gradle.builditbigger.Contract.Contract;

import static android.content.Context.MODE_PRIVATE;

public class FreeModel implements Contract.Model{

    private Context context;
    private Contract.Presenter presenter;
    private EndpointsAsyncTask task;
    private InterstitialAd mInterstitialAd;
    private SharedPreferences preferences;
    private final String PREFS_NAME = "preferences";


    public FreeModel(Context context, Contract.Presenter presenter) {
        this.presenter = presenter;
        this.context = context;
    }

    public void init ()
    {
        if(!BuildConfig.PAID_VERSION) {
            createAdd();
        }
    }

    @Override
    public void tellJoke() {

        task = new EndpointsAsyncTask();
        task.setListener(this);

        if(!BuildConfig.PAID_VERSION) {

            preferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            boolean intAdShowed = preferences.getBoolean("IAdShown", false);

            if (intAdShowed) {
                task.execute(new Pair<>(context, ""));
            }
            else {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                    SharedPreferences.Editor editor = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putBoolean("IAdShown", true);
                    editor.apply();

                } else {
                    Log.d(getClass().getSimpleName(), "The interstitial wasn't loaded yet.");
                }
            }
        }
        else
            task.execute(new Pair<>(context, ""));

    }

    private void createAdd(){
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                task.execute(new Pair<>(context, ""));
            }
        });
    }

    @Override
    public void updateProgressBar(int status) {
        presenter.updateProgressBar(status);
    }

}
