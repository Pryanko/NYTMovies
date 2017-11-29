package com.examle.libgo.nytmovies.Starting;

import com.examle.libgo.nytmovies.MoviesApiRequest.ApiService;
import com.examle.libgo.nytmovies.MoviesApiRequest.RealmHelper;
import com.examle.libgo.nytmovies.Utils.ResponseHandler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by libgo on 28.11.2017.
 */
@Module
public class StartingModule {

    @Provides
    ResponseHandler responseHandler(){
        return new ResponseHandler();
    }

    @Provides
    RealmHelper realmHelper(){
        return new RealmHelper();
    }

    @Provides
    ApiService apiService(RealmHelper realmHelper){
        return new ApiService(realmHelper);
    }

    @Provides
    StartingPrsenter startingPresenter(ApiService apiService, ResponseHandler responseHandler) {
        return new StartingPrsenter(apiService, responseHandler);
    }


}
