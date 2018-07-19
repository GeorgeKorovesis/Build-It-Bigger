package com.udacity.gradle.builditbigger.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.Contract.Contract;
import com.udacity.gradle.builditbigger.Presenter.FreePresenter;
import com.udacity.gradle.builditbigger.Presenter.Presenter;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragmentFree extends Fragment implements Contract.View {

    private ProgressBar bar;
    private FreePresenter presenter;

    public MainActivityFragmentFree() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);
        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new FreePresenter(getContext(), this);
        presenter.init();
        bar = view.findViewById(R.id.progressBar);
    }


    public void tellJoke() {
        presenter.tellJoke();
    }

    @Override
    public void onUpdateProgressBar(final int visibility) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bar.setVisibility(visibility);
            }
        });
    }
}
