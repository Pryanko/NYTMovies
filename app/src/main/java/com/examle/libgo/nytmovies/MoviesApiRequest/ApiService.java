package com.examle.libgo.nytmovies.MoviesApiRequest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.examle.libgo.nytmovies.Pojos.HeadResponse;
import com.examle.libgo.nytmovies.Pojos.Link;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Multimedia;
import com.examle.libgo.nytmovies.Pojos.Result;
import com.examle.libgo.nytmovies.Starting.StartingPrsenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by libgo on 28.11.2017.
 */

public class ApiService {

    private RealmHelper realmHelper;
    private StartingPrsenter startingPrsenter;
    final private String API_KEY = "e6b1734db83649b7aefd602fa213fcda";
    final private String TAG = "Сервер";
    String spider = "Spider";


    public ApiService(RealmHelper realmHelper) {
        this.realmHelper = realmHelper;
    }


    public void getAllMovies() {
        downloadAllMovies();
    }

    public void getSearchMovies() {
        downloadSearchMovies();
    }


    private void downloadAllMovies() {
        RequestApi requestApi = RequestApi.retrofit.create(RequestApi.class);
        Call<HeadResponse> callAllMovies = requestApi.getAllMovies(API_KEY);
        callAllMovies.enqueue(new Callback<HeadResponse>() {
            @Override
            public void onResponse(Call<HeadResponse> call, Response<HeadResponse> response) {
                if (response.isSuccessful()) {
                    HeadResponse headResponse = response.body();
                    Log.d(TAG, headResponse.getStatus());
                    List<Result> resultList = headResponse.getResults();
                    List<Movies> movies = new ArrayList<>();
                    for (Result result : resultList) {
                        Movies movie = new Movies();
                        movie.setHeadline(result.getHeadline());
                        movie.setDisplayTitle(result.getDisplayTitle());
                        movie.setOpeningDate(result.getOpeningDate());
                        movie.setCriticsPick(result.getCriticsPick());
                        movie.setMpaaRating(result.getMpaaRating());
                        movie.setSummaryShort(result.getSummaryShort());
                        Multimedia multimedia = result.getMultimedia();
                        movie.setSrc(multimedia.getSrc());
                        Link link = result.getLink();
                        movie.setUrl(link.getUrl());
                        movies.add(movie);
                    }
                    realmHelper.setMovies(movies);
                    realmHelper.startDBrecord();
                }
            }

            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

                startingPrsenter.errorCall();
            }
        });
    }


    private void downloadSearchMovies() {
        RequestApi requestApi = RequestApi.retrofit.create(RequestApi.class);
        Call<HeadResponse> callSearchMovies = requestApi.getSearchMovies(API_KEY, spider);
        callSearchMovies.enqueue(new Callback<HeadResponse>() {
            @Override
            public void onResponse(Call<HeadResponse> call, Response<HeadResponse> response) {
                if (response.isSuccessful()) {
                    HeadResponse headResponse = response.body();
                    List<Result> resultList = headResponse.getResults();
                    for (Result result : resultList) {
                        Log.d(TAG, result.getHeadline());
                    }
                }

            }

            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

            }
        });

    }

    public void setPrsenter(StartingPrsenter prsenter) {
        this.startingPrsenter = prsenter;
        realmHelper.setStartingPrsenter(prsenter);
    }
}

