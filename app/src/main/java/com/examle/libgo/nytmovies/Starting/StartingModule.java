package com.examle.libgo.nytmovies.Starting;

import dagger.Module;
import dagger.Provides;

/**
 * Created by libgo on 28.11.2017.
 */
@Module
public class StartingModule {

    @Provides
    StartingPrsenter startingPresenter() {
        return new StartingPrsenter();
    }


}
