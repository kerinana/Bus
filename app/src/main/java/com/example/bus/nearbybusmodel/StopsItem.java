package com.example.bus.nearbybusmodel;

import com.example.bus.realtimesequenceModel.StopName;
import com.google.gson.annotations.SerializedName;

public class StopsItem{

	@SerializedName("StopName")
	private StopName stopName;

	@SerializedName("StopID")
	private String stopID;

	@SerializedName("StopUID")
	private String stopUID;

	@SerializedName("RouteName")
	private RouteName routeName;

	@SerializedName("RouteUID")
	private String routeUID;

	@SerializedName("RouteID")
	private String routeID;

	public StopName getStopName(){
		return stopName;
	}

	public String getStopID(){
		return stopID;
	}

	public String getStopUID(){
		return stopUID;
	}

	public RouteName getRouteName(){
		return routeName;
	}

	public String getRouteUID(){
		return routeUID;
	}

	public String getRouteID(){
		return routeID;
	}
}