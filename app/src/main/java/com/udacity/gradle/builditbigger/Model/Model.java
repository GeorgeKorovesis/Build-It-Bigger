package com.udacity.gradle.builditbigger.Model;

import android.content.Context;
import android.support.v4.util.Pair;

import com.udacity.gradle.builditbigger.Contract.Contract;


public class Model implements Contract.Model{

    private Context context;
    private Contract.Presenter presenter;
    private EndpointsAsyncTask task;


    public Model(Context context, Contract.Presenter presenter) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public void tellJoke() {
        task = new EndpointsAsyncTask();
        task.setListener(this);
        task.execute(new Pair<>(context, ""));
    }

    @Override
    public void updateProgressBar(int status) {
        presenter.updateProgressBar(status);
    }
}
