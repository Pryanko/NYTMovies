package com.examle.libgo.nytmovies.Head;

import dagger.Module;
import dagger.Provides;

/**
 * Created by libgo on 29.11.2017.
 */
@Module
public class HeadModule {

    @Provides
    HeadPrsenter headPrsenter(){
        return new HeadPrsenter();
    }

}
