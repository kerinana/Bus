package com.example.bus;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("GPSTime")
	private String gPSTime;

	@SerializedName("Speed")
	private double speed;

	@SerializedName("OperatorID")
	private String operatorID;

	@SerializedName("RouteUID")
	private String routeUID;

	@SerializedName("RouteID")
	private String routeID;

	@SerializedName("SrcUpdateTime")
	private String srcUpdateTime;

	@SerializedName("Direction")
	private int direction;

	@SerializedName("SubRouteUID")
	private String subRouteUID;

	@SerializedName("Azimuth")
	private double azimuth;

	@SerializedName("PlateNumb")
	private String plateNumb;

	@SerializedName("BusPosition")
	private BusPosition busPosition;

	@SerializedName("UpdateTime")
	private String updateTime;

	@SerializedName("RouteName")
	private RouteName routeName;

	@SerializedName("SubRouteID")
	private String subRouteID;

	@SerializedName("SubRouteName")
	private SubRouteName subRouteName;

	@SerializedName("DutyStatus")
	private int dutyStatus;

	@SerializedName("BusStatus")
	private int busStatus;

	public String getGPSTime(){
		return gPSTime;
	}

	public double getSpeed(){
		return speed;
	}

	public String getOperatorID(){
		return operatorID;
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

	public String getSubRouteUID(){
		return subRouteUID;
	}

	public double getAzimuth(){
		return azimuth;
	}

	public String getPlateNumb(){
		return plateNumb;
	}

	public BusPosition getBusPosition(){
		return busPosition;
	}

	public String getUpdateTime(){
		return updateTime;
	}

	public RouteName getRouteName(){
		return routeName;
	}

	public String getSubRouteID(){
		return subRouteID;
	}

	public SubRouteName getSubRouteName(){
		return subRouteName;
	}

	public int getDutyStatus(){
		return dutyStatus;
	}

	public int getBusStatus(){
		return busStatus;
	}
}