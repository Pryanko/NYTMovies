package com.examle.libgo.nytmovies.Starting;

import android.content.SharedPreferences;

import com.examle.libgo.nytmovies.MoviesApiRequest.ApiService;
import com.examle.libgo.nytmovies.MoviesApiRequest.RealmHelper;
import com.examle.libgo.nytmovies.MoviesApiRequest.ResponseConverter;
import com.examle.libgo.nytmovies.Utils.ResponseHandler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by libgo on 28.11.2017.
 */
@Module
public class StartingModule {

    @Provides
    TimeResponse timeResponse(){
        return new TimeResponse();
    }

    @Provides
    ResponseHandler responseHandler(){
        return new ResponseHandler();
    }

    @Provides
    RealmHelper realmHelper(){
        return new RealmHelper();
    }

    @Provides
    ApiService apiService(RealmHelper realmHelper, TimeResponse timeResponse, ResponseConverter responseConverter){
        return new ApiService(realmHelper, timeResponse, responseConverter);
    }

    @Provides
    StartingPrsenter startingPresenter(ApiService apiService, ResponseHandler responseHandler) {
        return new StartingPrsenter(apiService, responseHandler);
    }


}
