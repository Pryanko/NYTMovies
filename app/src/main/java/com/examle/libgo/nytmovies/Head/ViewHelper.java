package com.examle.libgo.nytmovies.Head;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Utils.RealmAdapter;

import io.realm.Realm;

/**
 * Created by libgo on 30.11.2017.
 */

public class ViewHelper {

    private RealmAdapter realmAdapter;
    private Realm realm;



    public void startRecyclerview(RecyclerView recyclerView, HeadActivity headActivity){
        setUpRecyclerView(recyclerView, headActivity);
    }


    private void setUpRecyclerView(RecyclerView recyclerView, HeadActivity activity) {
        realm = Realm.getDefaultInstance();
        realmAdapter = new RealmAdapter(realm.where(Movies.class).findAll(), activity);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(realmAdapter);
        recyclerView.setHasFixedSize(true);
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //TouchHelperCallback touchHelperCallback = new TouchHelperCallback();
        //ItemTouchHelper touchHelper = new ItemTouchHelper(touchHelperCallback);
        // touchHelper.attachToRecyclerView(recyclerView);
    }
}
