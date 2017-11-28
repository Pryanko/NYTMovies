package com.examle.libgo.nytmovies.MoviesApiRequest;

import com.examle.libgo.nytmovies.Pojos.HeadResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by libgo on 28.11.2017.
 */

public interface RequestApi {

    @GET("all.json")
    Call<HeadResponse> getAllMovies (@Query ("api-key") String key);


    @GET("search.json")
    Call<HeadResponse> getSearchMovies (@Query("api-key") String key, @Query("query") String searchmovies);



    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/movies/v2/reviews/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

//https://api.nytimes.com/svc/movies/v2/reviews/all.json?api-key=e6b1734db83649b7aefd602fa213fcda
