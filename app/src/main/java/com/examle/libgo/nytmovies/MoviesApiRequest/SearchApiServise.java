package com.examle.libgo.nytmovies.MoviesApiRequest;

import android.util.Log;
import android.widget.Toast;

import com.examle.libgo.nytmovies.Head.HeadPrsenter;
import com.examle.libgo.nytmovies.Pojos.HeadResponse;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by libgo on 30.11.2017.
 */

public class SearchApiServise {
    private HeadPrsenter headPrsenter;
    private ResponseConverter responseConverter;
    final private String API_KEY = "e6b1734db83649b7aefd602fa213fcda";

    public SearchApiServise(ResponseConverter responseConverter) {
        this.responseConverter = responseConverter;
    }

    public void setHeadPrsenter (HeadPrsenter headPrsenter){
        this.headPrsenter = headPrsenter;
    }

    public void getSearchMovies(String search) {
        downloadSearchMovies(search);
    }
    private void downloadSearchMovies(String search) {
        RequestApi requestApi = RequestApi.retrofit.create(RequestApi.class);
        Call<HeadResponse> callSearchMovies = requestApi.getSearchMovies(API_KEY, search);
        callSearchMovies.enqueue(new Callback<HeadResponse>() {
            @Override
            public void onResponse(Call<HeadResponse> call, Response<HeadResponse> response) {
                if (response.isSuccessful()) {
                    HeadResponse headResponse = response.body();
                    List<Result> resultList = headResponse.getResults();
                    List<Movies> movies = new ArrayList<>();
                    movies = responseConverter.getMovies(resultList);
                    headPrsenter.startSearchView(movies);
                }
            }
            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

            }
        });

    }

}
