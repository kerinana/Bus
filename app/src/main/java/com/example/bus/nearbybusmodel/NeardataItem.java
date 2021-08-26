package com.example.bus.nearbybusmodel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class NeardataItem {

    @SerializedName("VersionID")
    private int versionID;

    @SerializedName("StationName")
    private StationName stationName;

    @SerializedName("LocationCityCode")
    private String locationCityCode;

    @SerializedName("StationAddress")
    private String stationAddress;

    @SerializedName("UpdateTime")
    private String updateTime;

    @SerializedName("Stops")
    private List<StopsItem> stops;

    @SerializedName("StationPosition")
    private StationPosition stationPosition;

    @SerializedName("StationID")
    private String stationID;

    @SerializedName("StationUID")
    private String stationUID;

    @SerializedName("Bearing")
    private String bearing;

    public int getVersionID() {
        return versionID;
    }

    public StationName getStationName() {
        return stationName;
    }

    public String getLocationCityCode() {
        return locationCityCode;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public List<StopsItem> getStops() {
        return stops;
    }

    public StationPosition getStationPosition() {
        return stationPosition;
    }

    public String getStationID() {
        return stationID;
    }

    public String getStationUID() {
        return stationUID;
    }

    public String getBearing() {
        return bearing;
    }
}