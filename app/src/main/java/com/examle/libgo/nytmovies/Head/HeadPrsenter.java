package com.examle.libgo.nytmovies.Head;

import android.support.v7.widget.RecyclerView;
import com.examle.libgo.nytmovies.MoviesApiRequest.SearchApiServise;
import com.examle.libgo.nytmovies.Pojos.Movies;
import com.examle.libgo.nytmovies.Presenters;

import java.util.List;


/**
 * Created by libgo on 29.11.2017.
 */

public class HeadPrsenter implements Presenters {


    private ViewHelper viewHelper;
    private SearchApiServise searchApiServise;
    private HeadActivity activity;
    private RecyclerView recyclerView;


    HeadPrsenter(ViewHelper viewHelper, SearchApiServise searchApiServise) {
        this.viewHelper = viewHelper;
        this.searchApiServise = searchApiServise;
    }
    void setActivity (HeadActivity headActivity, RecyclerView recyclerView){
        this.activity = headActivity;
        this.recyclerView = recyclerView;
    }

    @Override
    public void createView() {

    }

    @Override
    public void errorCall() {

    }

    public void searchCall(String search){
        searchApiServise.setHeadPrsenter(this);
        searchApiServise.getSearchMovies(search);
    }

    void startView(){
        viewHelper.setHeadActivity(activity);
        viewHelper.setRecyclerView(recyclerView);
        viewHelper.startRecyclerview();

    }

    public void startSearchView (List<Movies> movies){
        viewHelper.startRecyclerViewSearch(movies);
    }
}
