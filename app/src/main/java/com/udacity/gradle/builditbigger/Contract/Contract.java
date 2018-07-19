package com.udacity.gradle.builditbigger.Contract;

public interface Contract {

    interface Presenter{
        void updateProgressBar (int status);
        void tellJoke ();
    }

    interface View{
        void onUpdateProgressBar (int status);
    }

    interface Model{
        void tellJoke ();
        void updateProgressBar (int status);
    }

}
