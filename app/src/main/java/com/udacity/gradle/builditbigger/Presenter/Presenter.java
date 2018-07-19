package com.udacity.gradle.builditbigger.Presenter;

import android.content.Context;
import android.support.v4.util.Pair;

import com.udacity.gradle.builditbigger.Contract.Contract;
import com.udacity.gradle.builditbigger.Model.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.Model.Model;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    private Context context;
    private Model model;

    public Presenter(Context context, Contract.View view) {
        this.view = view;
        this.context = context;
    }

    public void init (){
        this.model = new Model(context, this);
    }

    @Override
    public void updateProgressBar(int status) {
        view.onUpdateProgressBar(status);
    }

    @Override
    public void tellJoke() {
        model.tellJoke();
    }


}
