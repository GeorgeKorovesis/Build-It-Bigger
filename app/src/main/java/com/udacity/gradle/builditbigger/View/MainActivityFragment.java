package com.udacity.gradle.builditbigger.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.Contract.Contract;
import com.udacity.gradle.builditbigger.Presenter.Presenter;
import com.udacity.gradle.builditbigger.R;


/**
 * A placeholder fragment containing a simple view.
 */
    public class MainActivityFragment extends Fragment implements Contract.View {

    private ProgressBar bar;
    private Presenter presenter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new Presenter(getContext(),this );
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
