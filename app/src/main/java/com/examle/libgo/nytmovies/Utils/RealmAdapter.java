package com.examle.libgo.nytmovies.Utils;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Pojos.Result;
import com.examle.libgo.nytmovies.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmList;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

/**
 * Created by libgo on 29.11.2017.
 */

public class RealmAdapter extends RecyclerView.Adapter<RealmAdapter.ViewHolder> {

    private Context context;
    public List<Movies> data;

    public RealmAdapter(RealmResults<Movies> data) {
        //super(data, autoUpdate);
        this.data = data;

        //setHasStableIds(true);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_movies, parent, false);
       context = parent.getContext();


       return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RealmAdapter.ViewHolder holder, int position) {
        final Movies movie = data.get(position);
        holder.textDisplayTitle.setText(movie.getDisplayTitle());
        holder.textDate.setText(movie.getOpeningDate());
        holder.textHeadLine.setText(movie.getHeadline());
        holder.textSummary.setText(movie.getSummaryShort());
        holder.progressBar.setVisibility(ProgressBar.VISIBLE);
        Picasso.with(context)
                .load(movie.getSrc())
                // .resize(300,200)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(ProgressBar.INVISIBLE);
                    }
                    @Override
                    public void onError() {

                    }
                });
    }


    @Override
    public int getItemCount() {
        if
                (data != null) {
            return data.size();
        }
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textDisplayTitle;
        TextView textDate;
        TextView textHeadLine;
        TextView textSummary;
        ImageView imageView;
        ProgressBar progressBar;


        ViewHolder(View view) {
            super(view);
            textDisplayTitle = (TextView) view.findViewById(R.id.textDisplayTitle);
            textDate = (TextView) view.findViewById(R.id.textDate);
            textHeadLine = (TextView) view.findViewById(R.id.textHeadLine);
            textSummary = (TextView) view.findViewById(R.id.textSummary);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
        }


    }
}
