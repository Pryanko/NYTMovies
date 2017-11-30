package com.examle.libgo.nytmovies.Head;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.examle.libgo.nytmovies.MoviesApp;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.R;
import com.examle.libgo.nytmovies.Utils.RealmAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


public class HeadActivity extends AppCompatActivity {

    HeadPrsenter headPrsenter;

    RecyclerView recyclerView;
    @BindView(R.id.editTextSearch)
    EditText editTextSearch;
    @BindView(R.id.imageView2)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        ButterKnife.bind(this);
        headPrsenter = MoviesApp.getAppComponent().getHeadPresenter();
        headPrsenter.createView();
        headPrsenter.setActivity(this, recyclerView);
        headPrsenter.startView();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                headPrsenter.searchCall(editTextSearch.getText().toString());
            }
        });
    }
}
