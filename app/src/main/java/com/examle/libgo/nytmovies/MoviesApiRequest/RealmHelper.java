package com.examle.libgo.nytmovies.MoviesApiRequest;

import android.util.Log;
import com.examle.libgo.nytmovies.Pojos.Link;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Multimedia;
import com.examle.libgo.nytmovies.Pojos.Result;
import com.examle.libgo.nytmovies.Starting.StartingPrsenter;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by libgo on 28.11.2017.
 */

public class RealmHelper {

    private StartingPrsenter startingPrsenter;
    private Realm moviesRealm;
    private List<Movies> movies;

     void setStartingPrsenter(StartingPrsenter startingPrsenter) {  //На данный момент у меня некоторые недопонмание СУТИ RX - в данный момент тут не могу его применить, придется передать - экземпляр презентера
        this.startingPrsenter = startingPrsenter;                         //Я знаю что это дикое решение, но нет времени выяснять как правильно.
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

     void startDBrecord(){
        moviesRealmRecord();
        goodJob();
    }


    private void moviesRealmRecord(){
        if(movies != null) {
            moviesRealm = Realm.getDefaultInstance();

            for (Movies movies : movies) {
                moviesRealm.beginTransaction();
                Movies realmMovies = moviesRealm.createObject(Movies.class);
                realmMovies.setDisplayTitle(movies.getDisplayTitle());
                realmMovies.setHeadline(movies.getHeadline());
                realmMovies.setOpeningDate(movies.getOpeningDate());
                realmMovies.setSummaryShort(movies.getSummaryShort());
                realmMovies.setMpaaRating(movies.getMpaaRating());
                realmMovies.setCriticsPick(movies.getCriticsPick());
                realmMovies.setUrl(movies.getUrl());
                realmMovies.setSrc(movies.getSrc());
                Log.d("zzzzz", movies.getUrl());
                moviesRealm.commitTransaction();
            }
            Log.d("БД :", moviesRealm.toString());
        }
    }

    private void goodJob(){
        startingPrsenter.startNextActivity();
    }
}
