package com.examle.libgo.nytmovies.Head;

import android.graphics.Movie;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Utils.RealmAdapter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by libgo on 30.11.2017.
 */

public class ViewHelper {


    Realm realm;
    private RecyclerView recyclerView;
    private HeadActivity headActivity;

    public void setRecyclerView (RecyclerView recyclerView){
        this.recyclerView = recyclerView;
    }
    public void setHeadActivity (HeadActivity headActivity){
        this.headActivity = headActivity;
    }

    public void startRecyclerview(){
        setUpRecyclerView(recyclerView);
    }

    public void startRecyclerViewSearch(List<Movies> movies){
        setSearchRecyclercView(recyclerView, movies);
    }


    private void setSearchRecyclercView(RecyclerView recyclerView, List<Movies> movies){
        RealmAdapter realmAdapter = new RealmAdapter(movies, headActivity);
        //realmAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(headActivity));
        recyclerView.setAdapter(realmAdapter);
        recyclerView.setHasFixedSize(true);
    }





    private void setUpRecyclerView(RecyclerView recyclerView) {
        realm = Realm.getDefaultInstance();
        RealmAdapter realmAdapter = new RealmAdapter(realm.where(Movies.class).findAll(), headActivity);
        recyclerView.setLayoutManager(new LinearLayoutManager(headActivity));
        recyclerView.setAdapter(realmAdapter);
        recyclerView.setHasFixedSize(true);
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //TouchHelperCallback touchHelperCallback = new TouchHelperCallback();
        //ItemTouchHelper touchHelper = new ItemTouchHelper(touchHelperCallback);
        // touchHelper.attachToRecyclerView(recyclerView);
    }
}
