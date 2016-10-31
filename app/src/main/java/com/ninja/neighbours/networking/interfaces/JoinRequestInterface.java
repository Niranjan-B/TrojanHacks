package com.ninja.neighbours.networking.interfaces;

import com.ninja.neighbours.networking.DataModels.JoinRequestResponseModel;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by niranjanb on 30/10/16.
 */

public interface JoinRequestInterface {
    @POST("api/join")
    Observable<JoinRequestResponseModel> postJoinRequestToServer(@QueryMap Map<String, String> queryMap);
}
