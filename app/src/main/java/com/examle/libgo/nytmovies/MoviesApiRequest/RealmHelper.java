package com.examle.libgo.nytmovies.MoviesApiRequest;



import android.util.Log;

import com.examle.libgo.nytmovies.Pojos.Result;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by libgo on 28.11.2017.
 */

public class RealmHelper {

    private Realm moviesRealm;
    private List<Result> results;



    public void setResults(List<Result> list) {
        this.results = list;
    }

    public void DBrecord(){
        moviesRealmRecord();
    }


    private void moviesRealmRecord(){
       // if(Realm.getDefaultConfiguration().equals(null)) {
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
            RealmQuery<Result> query = moviesRealm.where(Result.class);
            RealmResults<Result> responsedb = query.findAll();
            Log.d("БД :", responsedb.toString() );
      //  }
        }





    }
}
