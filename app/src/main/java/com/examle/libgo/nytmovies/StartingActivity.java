package com.examle.libgo.nytmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.examle.libgo.nytmovies.Starting.StartingPrsenter;

import io.realm.Realm;

public class StartingActivity extends AppCompatActivity {

    StartingPrsenter startingPrsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        startingPrsenter = MoviesApp.getAppComponent().getStartingPresenter();
        startingPrsenter.createView();
        startingPrsenter.setActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
//    Realm realm = Realm.getInstance(Realm.getDefaultConfiguration());

}
