package com.examle.libgo.nytmovies.Starting;

import android.content.Intent;

import com.examle.libgo.nytmovies.Head.HeadActivity;
import com.examle.libgo.nytmovies.MoviesApiRequest.ApiService;
import com.examle.libgo.nytmovies.Presenters;
import com.examle.libgo.nytmovies.StartingActivity;

/**
 * Created by libgo on 28.11.2017.
 */

public class StartingPrsenter implements Presenters {

    private ApiService apiService;
    private StartingActivity activity;

    public StartingPrsenter(ApiService apiService){
        this.apiService = apiService;
    }

    public void setActivity (StartingActivity startingActivity){
        this.activity = startingActivity;
    }


    @Override
    public void createView() {
        apiService.getAllMovies();
        apiService.setPrsenter(this);
        // apiService.getSearchMovies();
    }


    public void startNextActivity(){
        nextActivity(activity);
    }

    private void nextActivity(StartingActivity activity){
        Intent intent = new Intent(activity, HeadActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }
}
