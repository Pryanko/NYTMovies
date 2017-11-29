package com.examle.libgo.nytmovies.Head;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.examle.libgo.nytmovies.MoviesApp;
import com.examle.libgo.nytmovies.R;

public class HeadActivity extends AppCompatActivity {

    HeadPrsenter headPrsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        headPrsenter = MoviesApp.getAppComponent().getHeadPresenter();

    }
}
