package com.examle.libgo.nytmovies.MoviesApiRequest;

import android.util.Log;

import com.examle.libgo.nytmovies.Pojos.HeadResponse;
import com.examle.libgo.nytmovies.Pojos.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by libgo on 28.11.2017.
 */

public class ApiService {


    final private String API_KEY = "e6b1734db83649b7aefd602fa213fcda";
    final private String TAG = "Сервер";
    String spider = "Spider";


    public void getAllMovies(){
        downloadAllMovies();
    }

    public void getSearchMovies(){
        downloadSearchMovies();
    }



    private void downloadAllMovies() {
        RequestApi requestApi = RequestApi.retrofit.create(RequestApi.class);
        Call<HeadResponse> callAllMovies = requestApi.getAllMovies(API_KEY);
        callAllMovies.enqueue(new Callback<HeadResponse>() {
            @Override
            public void onResponse(Call<HeadResponse> call, Response<HeadResponse> response) {
                if(response.isSuccessful()) {
                    HeadResponse headResponse = response.body();
                    Log.d(TAG, headResponse.getStatus());
                }
            }
            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

            }
        });
    }

    private void downloadSearchMovies() {
        RequestApi requestApi = RequestApi.retrofit.create(RequestApi.class);
        Call<HeadResponse> callSearchMovies = requestApi.getSearchMovies(API_KEY, spider);
        callSearchMovies.enqueue(new Callback<HeadResponse>() {
            @Override
            public void onResponse(Call<HeadResponse> call, Response<HeadResponse> response) {
                if(response.isSuccessful()){
                    HeadResponse headResponse = response.body();
                    List<Result> resultList = headResponse.getResults();
                    for(Result result : resultList){
                        Log.d(TAG, result.getHeadline());
                    }
                }

            }

            @Override
            public void onFailure(Call<HeadResponse> call, Throwable t) {

            }
        });

    }





}
