package com.example.bus.nearbybusmodel;

import com.google.gson.annotations.SerializedName;

public class StationName{

	@SerializedName("Zh_tw")
	private String zhTw;

	public String getZhTw(){
		return zhTw;
	}
}