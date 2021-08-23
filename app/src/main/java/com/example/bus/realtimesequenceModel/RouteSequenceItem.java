package com.example.bus.realtimesequenceModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RouteSequenceItem{

	@SerializedName("VersionID")
	private int versionID;

	@SerializedName("UpdateTime")
	private String updateTime;

	@SerializedName("RouteName")
	private RouteName routeName;

	@SerializedName("Stops")
	private List<StopsItem> stops;

	@SerializedName("RouteUID")
	private String routeUID;

	@SerializedName("RouteID")
	private String routeID;

	@SerializedName("Direction")
	private int direction;

	public int getVersionID(){
		return versionID;
	}

	public String getUpdateTime(){
		return updateTime;
	}

	public RouteName getRouteName(){
		return routeName;
	}

	public List<StopsItem> getStops(){
		return stops;
	}

	public String getRouteUID(){
		return routeUID;
	}

	public String getRouteID(){
		return routeID;
	}

	public int getDirection(){
		return direction;
	}
}