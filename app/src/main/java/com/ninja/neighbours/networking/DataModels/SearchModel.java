package com.ninja.neighbours.networking.DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niranjanb on 30/10/16.
 */

public class SearchModel {

    @SerializedName("buildings")
    @Expose
    private List<Building> buildings = new ArrayList<Building>();

    /**
     *
     * @return
     * The buildings
     */
    public List<Building> getBuildings() {
        return buildings;
    }

    /**
     *
     * @param buildings
     * The buildings
     */
    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }


}