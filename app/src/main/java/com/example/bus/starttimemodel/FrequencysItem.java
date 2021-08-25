package com.example.bus.starttimemodel;

import com.google.gson.annotations.SerializedName;

public class FrequencysItem{

	@SerializedName("EndTime")
	private String endTime;

	@SerializedName("ServiceDay")
	private ServiceDay serviceDay;

	@SerializedName("MaxHeadwayMins")
	private int maxHeadwayMins;

	@SerializedName("StartTime")
	private String startTime;

	@SerializedName("MinHeadwayMins")
	private int minHeadwayMins;

	public String getEndTime(){
		return endTime;
	}

	public ServiceDay getServiceDay(){
		return serviceDay;
	}

	public int getMaxHeadwayMins(){
		return maxHeadwayMins;
	}

	public String getStartTime(){
		return startTime;
	}

	public int getMinHeadwayMins(){
		return minHeadwayMins;
	}
}