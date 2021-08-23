package com.example.bus.realtimesequenceModel;

import com.google.gson.annotations.SerializedName;

public class StopPosition{

	@SerializedName("PositionLon")
	private double positionLon;

	@SerializedName("GeoHash")
	private String geoHash;

	@SerializedName("PositionLat")
	private double positionLat;

	public double getPositionLon(){
		return positionLon;
	}

	public String getGeoHash(){
		return geoHash;
	}

	public double getPositionLat(){
		return positionLat;
	}
}