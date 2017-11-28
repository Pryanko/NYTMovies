package com.examle.libgo.nytmovies.MoviesApiRequest;

import android.util.Log;

import com.examle.libgo.nytmovies.Pojos.HeadResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by libgo on 28.11.2017.
 */

public class ApiService {


    final private String API_KEY = "e6b1734db83649b7aefd602fa213fcda";
    final private String TAG = "Код ответа";

    private void getAllMovies() {
        RequestApi requestApi = RequestApi.retrofit.create(RequestApi.class);
        Call<HeadResponse> callAllMovies = requestApi.getAllMovies(API_KEY);
        callAllMovies.enqueue(new Callback<HeadResponse>() {
            @Override
            public void onResponse(Call<HeadResponse> call, Response<HeadResponse> response) {
                HeadResponse headResponse = response.body();
                Log.d(TAG, headResponse.getStatus());
            }
            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

            }
        });
    }





}
