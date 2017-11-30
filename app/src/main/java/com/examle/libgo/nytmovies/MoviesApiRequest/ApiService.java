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
import com.examle.libgo.nytmovies.Starting.TimeResponse;

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
    private TimeResponse timeResponse;
    private ResponseConverter responseConverter;
    private StartingPrsenter startingPrsenter;
    final private String API_KEY = "e6b1734db83649b7aefd602fa213fcda";
    final private String TAG = "Сервер";


    public ApiService(RealmHelper realmHelper, TimeResponse timeResponse, ResponseConverter responseConverter) {
        this.realmHelper = realmHelper;
        this.timeResponse = timeResponse;
        this.responseConverter = responseConverter;
    }


    public void getAllMovies() {
        downloadAllMovies();
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
                    movies = responseConverter.getMovies(resultList);
                    //Log.d("zzZZZ", movies.toString());
                    realmHelper.setMovies(movies);
                    realmHelper.startDBrecord();
                    String time = timeResponse.getTime();
                    Log.d("Time", time);
                }
            }

            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

                startingPrsenter.errorCall();
            }
        });
    }

    public void setPrsenter(StartingPrsenter prsenter) {
        this.startingPrsenter = prsenter;
        realmHelper.setStartingPrsenter(prsenter);
    }
}

