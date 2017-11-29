package com.examle.libgo.nytmovies;


import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Result;

import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by libgo on 29.11.2017.
 */

public class RealmAdapter extends RealmRecyclerViewAdapter<Movies, RealmAdapter.MyViewHolder> {

    public RealmAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate) {
        super(data, autoUpdate);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_starting, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public List<Result> data;

        MyViewHolder(View view) {
            super(view);
            // title = (TextView) view.findViewById(R.id.textview);

        }


    }
}
