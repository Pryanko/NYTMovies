package com.examle.libgo.nytmovies.MoviesApiRequest;

import com.examle.libgo.nytmovies.Pojos.Link;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Multimedia;
import com.examle.libgo.nytmovies.Pojos.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libgo on 30.11.2017.
 */

public class ResponseConverter {




    public List<Movies> getMovies (List<Result> results){
        List<Movies> movies = new ArrayList<>();
        for (Result result : results) {
            Movies movie = new Movies();
            movie.setHeadline(result.getHeadline());
            movie.setDisplayTitle(result.getDisplayTitle());
            movie.setOpeningDate(result.getOpeningDate());
            movie.setCriticsPick(result.getCriticsPick());
            movie.setMpaaRating(result.getMpaaRating());
            movie.setSummaryShort(result.getSummaryShort());
            if(result.getMultimedia()!= null){
            Multimedia multimedia = result.getMultimedia();
            movie.setSrc(multimedia.getSrc());
            }
            if(result.getLink() != null) {
                Link link = result.getLink();
                movie.setUrl(link.getUrl());
            }
            movies.add(movie);
        }

        return movies;

    }
}
