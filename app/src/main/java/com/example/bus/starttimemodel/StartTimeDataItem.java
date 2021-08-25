package com.example.bus.starttimemodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class StartTimeDataItem{

	@SerializedName("VersionID")
	private int versionID;

	@SerializedName("SubRouteUID")
	private String subRouteUID;

	@SerializedName("Timetables")
	private List<TimetablesItem> timetables;

	@SerializedName("Frequencys")
	private List<FrequencysItem> frequencys;

	@SerializedName("UpdateTime")
	private String updateTime;

	@SerializedName("RouteName")
	private RouteName routeName;

	@SerializedName("RouteUID")
	private String routeUID;

	@SerializedName("RouteID")
	private String routeID;

	@SerializedName("SubRouteID")
	private String subRouteID;

	@SerializedName("SubRouteName")
	private SubRouteName subRouteName;

	@SerializedName("Direction")
	private int direction;

	public int getVersionID(){
		return versionID;
	}

	public String getSubRouteUID(){
		return subRouteUID;
	}

	public List<TimetablesItem> getTimetables(){
		return timetables;
	}

	public List<FrequencysItem> getFrequencys(){
		return frequencys;
	}

	public String getUpdateTime(){
		return updateTime;
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

	public String getSubRouteID(){
		return subRouteID;
	}

	public SubRouteName getSubRouteName(){
		return subRouteName;
	}

	public int getDirection(){
		return direction;
	}
}