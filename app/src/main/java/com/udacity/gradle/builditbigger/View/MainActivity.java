package com.udacity.gradle.builditbigger.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity  {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {

        if (currentFragment instanceof MainActivityFragment)
            ((MainActivityFragment) currentFragment).tellJoke();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        currentFragment = fragment;
        super.onAttachFragment(fragment);
    }
}





