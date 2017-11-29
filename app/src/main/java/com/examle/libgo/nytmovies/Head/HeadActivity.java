package com.examle.libgo.nytmovies.Head;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.examle.libgo.nytmovies.MoviesApp;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Parent;
import com.examle.libgo.nytmovies.R;
import com.examle.libgo.nytmovies.Utils.RealmAdapter;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class HeadActivity extends AppCompatActivity {

    HeadPrsenter headPrsenter;

    Realm realm;
    RecyclerView recyclerView;
    RealmAdapter realmAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        headPrsenter = MoviesApp.getAppComponent().getHeadPresenter();

        realm = Realm.getDefaultInstance();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        setUpRecyclerView();
    }



    private void setUpRecyclerView() {
        //RealmResults<Movies> moviesRealmList = realm.where(Movies.class).findAll();
        realmAdapter = new RealmAdapter(realm.where(Movies.class).findAll());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(realmAdapter);
        recyclerView.setHasFixedSize(true);
       // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        //TouchHelperCallback touchHelperCallback = new TouchHelperCallback();
        //ItemTouchHelper touchHelper = new ItemTouchHelper(touchHelperCallback);
       // touchHelper.attachToRecyclerView(recyclerView);
    }


}
