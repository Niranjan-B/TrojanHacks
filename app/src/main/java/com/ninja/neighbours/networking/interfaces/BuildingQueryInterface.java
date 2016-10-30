package com.ninja.neighbours.networking.interfaces;

import com.ninja.neighbours.networking.DataModels.BuildingQueryModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by niranjanb on 30/10/16.
 */

public interface BuildingQueryInterface {
    @GET("api/search/{apt}")
    Observable<BuildingQueryModel> getParticularBuilding(@Path("apt") String apt);
}
