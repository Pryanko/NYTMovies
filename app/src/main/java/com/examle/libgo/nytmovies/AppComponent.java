package com.examle.libgo.nytmovies;

import com.examle.libgo.nytmovies.Head.HeadModule;
import com.examle.libgo.nytmovies.Head.HeadPrsenter;
import com.examle.libgo.nytmovies.Starting.StartingModule;
import com.examle.libgo.nytmovies.Starting.StartingPrsenter;

import dagger.Component;

/**
 * Created by libgo on 28.11.2017.
 */
@Component (modules = {StartingModule.class, HeadModule.class})
public interface AppComponent {

    StartingPrsenter getStartingPresenter();

    HeadPrsenter getHeadPresenter();

}
