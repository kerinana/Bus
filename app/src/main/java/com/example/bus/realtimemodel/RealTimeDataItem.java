package com.example.bus.realtimemodel;

import com.google.gson.annotations.SerializedName;

public class RealTimeDataItem{

	@SerializedName("StopName")
	private StopName stopName;

	@SerializedName("StopID")
	private String stopID;

	@SerializedName("StopStatus")
	private int stopStatus;

	@SerializedName("UpdateTime")
	private String updateTime;

	@SerializedName("StopUID")
	private String stopUID;

	@SerializedName("RouteName")
	private RouteName routeName;

	@SerializedName("EstimateTime")
	private int estimateTime;

	@SerializedName("RouteUID")
	private String routeUID;

	@SerializedName("RouteID")
	private String routeID;

	@SerializedName("SrcUpdateTime")
	private String srcUpdateTime;

	@SerializedName("Direction")
	private int direction;

	public StopName getStopName(){
		return stopName;
	}

	public String getStopID(){
		return stopID;
	}

	public int getStopStatus(){
		return stopStatus;
	}

	public String getUpdateTime(){
		return updateTime;
	}

	public String getStopUID(){
		return stopUID;
	}

	public RouteName getRouteName(){
		return routeName;
	}

	public int getEstimateTime(){
		return estimateTime;
	}

	public String getRouteUID(){
		return routeUID;
	}

	public String getRouteID(){
		return routeID;
	}

	public String getSrcUpdateTime(){
		return srcUpdateTime;
	}

	public int getDirection(){
		return direction;
	}
}