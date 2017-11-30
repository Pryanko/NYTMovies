package com.examle.libgo.nytmovies.Head;

import com.examle.libgo.nytmovies.MoviesApiRequest.ApiService;
import com.examle.libgo.nytmovies.MoviesApiRequest.ResponseConverter;
import com.examle.libgo.nytmovies.MoviesApiRequest.SearchApiServise;
import com.examle.libgo.nytmovies.Utils.RealmAdapter;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by libgo on 29.11.2017.
 */
@Module
public class HeadModule {

    @Provides
    ResponseConverter responseConverter() {
        return new ResponseConverter();
    }

   @Provides
    SearchApiServise searchApiServise(ResponseConverter responseConverter){
       return new SearchApiServise(responseConverter);
   }


    @Provides
    ViewHelper viewHelper(){
        return new ViewHelper();
    }

    @Provides
    HeadPrsenter headPrsenter(ViewHelper viewHelper, SearchApiServise searchApiServise){
        return new HeadPrsenter(viewHelper, searchApiServise);
    }

}
