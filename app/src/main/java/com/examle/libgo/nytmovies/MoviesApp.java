package com.examle.libgo.nytmovies;

import android.app.Application;

/**
 * Created by libgo on 28.11.2017.
 */

public class MoviesApp extends Application {


    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent.create();

    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
