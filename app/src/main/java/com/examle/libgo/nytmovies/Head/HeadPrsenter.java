package com.examle.libgo.nytmovies.Head;

import android.support.v7.widget.RecyclerView;

import com.examle.libgo.nytmovies.Presenters;
import com.examle.libgo.nytmovies.StartingActivity;

/**
 * Created by libgo on 29.11.2017.
 */

public class HeadPrsenter implements Presenters {


    private ViewHelper viewHelper;
    HeadActivity activity;


    public HeadPrsenter(ViewHelper viewHelper) {
        this.viewHelper = viewHelper;
    }
    public void setActivity (HeadActivity headActivity){
        this.activity = headActivity;
    }

    @Override
    public void createView() {


    }

    @Override
    public void errorCall() {

    }

    public void startView(RecyclerView recyclerView){
        viewHelper.startRecyclerview(recyclerView,activity);

    }
}
