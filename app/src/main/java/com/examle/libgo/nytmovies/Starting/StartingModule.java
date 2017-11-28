package com.examle.libgo.nytmovies.Starting;

import com.examle.libgo.nytmovies.MoviesApiRequest.ApiService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by libgo on 28.11.2017.
 */
@Module
public class StartingModule {

    @Provides
    ApiService apiService(){
        return new ApiService();
    }

    @Provides
    StartingPrsenter startingPresenter(ApiService apiService) {
        return new StartingPrsenter(apiService);
    }


}
