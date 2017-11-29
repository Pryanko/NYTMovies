package com.examle.libgo.nytmovies.Head;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.examle.libgo.nytmovies.MoviesApp;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.R;
import com.examle.libgo.nytmovies.Utils.RealmAdapter;
import io.realm.Realm;


public class HeadActivity extends AppCompatActivity {

    HeadPrsenter headPrsenter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        headPrsenter = MoviesApp.getAppComponent().getHeadPresenter();
        headPrsenter.createView();
        headPrsenter.setActivity(this);
        headPrsenter.startView(recyclerView);
    }




}
