package com.examle.libgo.nytmovies.MoviesApiRequest;

import android.util.Log;
import com.examle.libgo.nytmovies.Pojos.Link;
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
    private List<Result> results;
    private List<Multimedia> multimediaList;
    private List<Link> links;

    public void setStartingPrsenter(StartingPrsenter startingPrsenter) {  //На данный момент у меня некоторые недопонмание СУТИ RX - в данный момент тут не могу его применить, придется передать - экземпляр презентера
        this.startingPrsenter = startingPrsenter;                         //Я знаю что это дикое решение, но нет времени выяснять как правильно.
    }

    public void setResults(List<Result> results, List<Multimedia> multimediaList, List<Link> links) {
        this.results = results;
        this.multimediaList = multimediaList;
        this.links = links;
    }

    public void startDBrecord(){
        moviesRealmRecord();
        goodJob();
    }


    private void moviesRealmRecord(){
        if(results != null) {
            moviesRealm = Realm.getInstance(Realm.getDefaultConfiguration());

            for (Result result : results) {
                moviesRealm.beginTransaction();
                Result realmResult = moviesRealm.createObject(Result.class);
                realmResult.setDisplayTitle(result.getDisplayTitle());
                realmResult.setHeadline(result.getHeadline());
                realmResult.setSummaryShort(result.getSummaryShort());
                realmResult.setMpaaRating(result.getMpaaRating());
                realmResult.setOpeningDate(result.getOpeningDate());
                realmResult.setCriticsPick(result.getCriticsPick());
                // realmResult.setMultimedia(result.getMultimedia()); // Так не работаЭт - разбиваем на массивы уровнем выше)
                // realmResult.setLink(result.getLink());
                moviesRealm.commitTransaction();
              //  RealmQuery<Result> query = moviesRealm.where(Result.class);
              //  RealmResults<Result> responsedb = query.findAll();
              //  Log.d("БД :", responsedb.toString());
            }
        }

        if (multimediaList != null){

            for (Multimedia multimedia : multimediaList){
                moviesRealm.beginTransaction();
                Multimedia realmMult = moviesRealm.createObject(Multimedia.class);
                realmMult.setSrc(multimedia.getSrc());
                moviesRealm.commitTransaction();
            }
        }

        if (links != null) {

            for (Link link : links) {
                moviesRealm.beginTransaction();
                Link linkRealm = moviesRealm.createObject(Link.class);
                linkRealm.setUrl(link.getUrl());
                moviesRealm.commitTransaction();
             //   RealmQuery<Link> query = moviesRealm.where(Link.class);
             //   RealmResults<Link> realmResults = query.findAll();
             //   Log.d("БД линк :", realmResults.toString());

            }
        }
    }

    private void goodJob(){
        startingPrsenter.startNextActivity();
    }
}
