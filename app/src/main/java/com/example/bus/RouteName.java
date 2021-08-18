package com.example.bus;

import com.google.gson.annotations.SerializedName;

public class RouteName{

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