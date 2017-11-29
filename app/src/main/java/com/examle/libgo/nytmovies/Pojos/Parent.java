package com.examle.libgo.nytmovies.Pojos;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by libgo on 29.11.2017.
 */

public class Parent extends RealmObject {
    @SuppressWarnings("unused")
    private RealmList<Movies> itemList;

    public RealmList<Movies> getItemList() {
        return itemList;
    }

    public void setItemList(RealmList<Movies> realmList){
        this.itemList = realmList;
    }
}