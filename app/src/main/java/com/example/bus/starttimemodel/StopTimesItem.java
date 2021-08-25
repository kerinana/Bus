package com.example.bus.starttimemodel;

import com.google.gson.annotations.SerializedName;

public class StopTimesItem{

	@SerializedName("StopName")
	private StopName stopName;

	@SerializedName("DepartureTime")
	private String departureTime;

	@SerializedName("StopID")
	private String stopID;

	@SerializedName("StopUID")
	private String stopUID;

	@SerializedName("StopSequence")
	private int stopSequence;

	@SerializedName("ArrivalTime")
	private String arrivalTime;

	public StopName getStopName(){
		return stopName;
	}

	public String getDepartureTime(){
		return departureTime;
	}

	public String getStopID(){
		return stopID;
	}

	public String getStopUID(){
		return stopUID;
	}

	public int getStopSequence(){
		return stopSequence;
	}

	public String getArrivalTime(){
		return arrivalTime;
	}
}