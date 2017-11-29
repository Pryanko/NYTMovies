package com.examle.libgo.nytmovies.Utils;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.examle.libgo.nytmovies.Head.HeadActivity;
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
    private List<Movies> data;
    private HeadActivity headActivity;

    public RealmAdapter(RealmResults<Movies> data, HeadActivity headActivity) {
        //super(data, autoUpdate);
        this.data = data;
        this.headActivity = headActivity;

        //setHasStableIds(true);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_movies, parent, false);
       //itemView.setOnClickListener(headActivity);
       context = parent.getContext();
       return new ViewHolder(itemView);
    }

   /* @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

    }*/

    @Override
    public void onBindViewHolder(RealmAdapter.ViewHolder holder, int position) {
        final Movies movie = data.get(position);
        holder.textDisplayTitle.setText(movie.getDisplayTitle());
        holder.textDate.setText(movie.getOpeningDate());
        holder.textHeadLine.setText(movie.getHeadline());
        holder.textSummary.setText(movie.getSummaryShort());
        holder.progressBar.setVisibility(ProgressBar.VISIBLE);
        holder.textViewReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(movie.getUrl()));
                headActivity.startActivity(intent);

            }
        });



        Picasso.with(context)
                .load(movie.getSrc())
                .error(R.drawable.movies)
                .resize(660,440)
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(ProgressBar.INVISIBLE);
                    }
                    @Override
                    public void onError() {
                        holder.progressBar.setVisibility(ProgressBar.INVISIBLE);
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
        TextView textViewReadMore;




        ViewHolder(View view) {
            super(view);
            textViewReadMore = (TextView) view.findViewById(R.id.textViewReadMore);
            textDisplayTitle = (TextView) view.findViewById(R.id.textDisplayTitle);
            textDate = (TextView) view.findViewById(R.id.textDate);
            textHeadLine = (TextView) view.findViewById(R.id.textHeadLine);
            textSummary = (TextView) view.findViewById(R.id.textSummary);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);


        }


    }
}
