package com.example.bus.starttimemodel;

import com.google.gson.annotations.SerializedName;

public class StopName{

	@SerializedName("Zh_tw")
	private String zhTw;

	@SerializedName("En")
	private String en;

	public String getZhTw(){
		return zhTw;
	}

	public String getEn(){
		return en;
	}
}