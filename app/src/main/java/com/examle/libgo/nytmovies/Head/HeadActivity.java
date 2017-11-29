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

   /* @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //Integer w = view.getMeasuredWidthAndState();
        //Log.d("zzz", w.toString());

    }*/

    private void setUpRecyclerView() {
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
