package com.example.bus.starttimemodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TimetablesItem{

	@SerializedName("ServiceDay")
	private ServiceDay serviceDay;

	@SerializedName("TripID")
	private String tripID;

	@SerializedName("StopTimes")
	private List<StopTimesItem> stopTimes;

	public ServiceDay getServiceDay(){
		return serviceDay;
	}

	public String getTripID(){
		return tripID;
	}

	public List<StopTimesItem> getStopTimes(){
		return stopTimes;
	}
}