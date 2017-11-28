package com.examle.libgo.nytmovies.Starting;

import com.examle.libgo.nytmovies.MoviesApiRequest.ApiService;
import com.examle.libgo.nytmovies.Presenters;

/**
 * Created by libgo on 28.11.2017.
 */

public class StartingPrsenter implements Presenters {

    private ApiService apiService;

    public StartingPrsenter(ApiService apiService){
        this.apiService = apiService;
    }


    @Override
    public void createView() {
        apiService.getAllMovies();
        // apiService.getSearchMovies();
    }
}
