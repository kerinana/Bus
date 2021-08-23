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