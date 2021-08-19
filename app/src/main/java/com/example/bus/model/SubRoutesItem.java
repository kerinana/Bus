package com.example.bus.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SubRoutesItem{

	@SerializedName("SubRouteUID")
	private String subRouteUID;

	@SerializedName("FirstBusTime")
	private String firstBusTime;

	@SerializedName("HolidayFirstBusTime")
	private String holidayFirstBusTime;

	@SerializedName("LastBusTime")
	private String lastBusTime;

	@SerializedName("HolidayLastBusTime")
	private String holidayLastBusTime;

	@SerializedName("SubRouteID")
	private String subRouteID;

	@SerializedName("SubRouteName")
	private SubRouteName subRouteName;

	@SerializedName("Direction")
	private int direction;

	@SerializedName("OperatorIDs")
	private List<String> operatorIDs;

	public void setSubRouteName(SubRouteName subRouteName) {
		this.subRouteName = subRouteName;
	}

	public String getSubRouteUID(){
		return subRouteUID;
	}

	public String getFirstBusTime(){
		return firstBusTime;
	}

	public String getHolidayFirstBusTime(){
		return holidayFirstBusTime;
	}

	public String getLastBusTime(){
		return lastBusTime;
	}

	public String getHolidayLastBusTime(){
		return holidayLastBusTime;
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

	public List<String> getOperatorIDs(){
		return operatorIDs;
	}
}