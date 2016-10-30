package com.ninja.neighbours.networking;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by niranjanb on 30/10/16.
 */

public class SearchApiAdapter {
    public static Retrofit getSearchAdapter() {
        return new Retrofit.Builder()
                .baseUrl("https://myneighbourhood.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
