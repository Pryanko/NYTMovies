package com.examle.libgo.nytmovies.Head;

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
    ViewHelper viewHelper(){
        return new ViewHelper();
    }

    @Provides
    HeadPrsenter headPrsenter(ViewHelper viewHelper){
        return new HeadPrsenter(viewHelper);
    }

}
