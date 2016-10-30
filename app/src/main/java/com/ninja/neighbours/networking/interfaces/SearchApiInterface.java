package com.ninja.neighbours.networking.interfaces;

import com.ninja.neighbours.networking.DataModels.SearchModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by niranjanb on 30/10/16.
 */

public interface SearchApiInterface {
    @GET("api")
    Observable<SearchModel> getSearchResults();
}
