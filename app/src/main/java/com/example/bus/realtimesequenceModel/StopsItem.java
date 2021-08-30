package com.example.bus.realtimesequenceModel;

import com.google.gson.annotations.SerializedName;

public class StopsItem{

	@SerializedName("StopName")
	private StopName stopName;

	@SerializedName("StopBoarding")
	private int stopBoarding;

	@SerializedName("StopID")
	private String stopID;

	@SerializedName("StopPosition")
	private StopPosition stopPosition;

	@SerializedName("StopUID")
	private String stopUID;

	@SerializedName("StationID")
	private String stationID;

	@SerializedName("StopSequence")
	private int stopSequence;
	@SerializedName("RouteName")
	private RouteName RouteName;

	@SerializedName("RouteID")
	private String RouteID;

	public com.example.bus.realtimesequenceModel.RouteName getRouteName() {
		return RouteName;
	}

	public void setRouteName(com.example.bus.realtimesequenceModel.RouteName routeName) {
		RouteName = routeName;
	}

	public String getRouteID() {
		return RouteID;
	}

	public void setRouteID(String routeID) {
		RouteID = routeID;
	}

	public StopName getStopName(){
		return stopName;
	}

	public int getStopBoarding(){
		return stopBoarding;
	}

	public String getStopID(){
		return stopID;
	}

	public StopPosition getStopPosition(){
		return stopPosition;
	}

	public String getStopUID(){
		return stopUID;
	}

	public String getStationID(){
		return stationID;
	}

	public int getStopSequence(){
		return stopSequence;
	}
}