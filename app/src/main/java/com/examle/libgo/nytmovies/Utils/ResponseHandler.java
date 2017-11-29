package com.examle.libgo.nytmovies.Utils;

import android.content.Intent;
import android.widget.Toast;

import com.examle.libgo.nytmovies.Head.HeadActivity;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.StartingActivity;

import io.realm.Realm;

/**
 * Created by libgo on 29.11.2017.
 */

public class ResponseHandler {

    private StartingActivity startingActivity;
    private Realm realm;


    public void setStartingActivity(StartingActivity startingActivity){
        this.startingActivity = startingActivity;
    }

    public void setOffLine(){
        offLineStart(startingActivity);
    }

    private void offLineStart(StartingActivity startingActivity){
        realm = Realm.getDefaultInstance();
        Movies movies = realm.where(Movies.class).equalTo("id", 20).findFirst();
        if(movies == null){
            Toast toast = Toast.makeText(startingActivity, "Нет подключения к интернету", Toast.LENGTH_LONG);
            toast.show();
            startingActivity.finish(); // Так делать нельзя)
        }
        else {
            Intent intent = new Intent(startingActivity, HeadActivity.class);
            startingActivity.startActivity(intent);
            startingActivity.finish();
        }



    }




}
