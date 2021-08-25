package com.example.bus.starttimemodel;

import com.google.gson.annotations.SerializedName;

public class ServiceDay{

	@SerializedName("Monday")
	private int monday;

	@SerializedName("Thursday")
	private int thursday;

	@SerializedName("Friday")
	private int friday;

	@SerializedName("Sunday")
	private int sunday;

	@SerializedName("Wednesday")
	private int wednesday;

	@SerializedName("Tuesday")
	private int tuesday;

	@SerializedName("Saturday")
	private int saturday;

	public int getMonday(){
		return monday;
	}

	public int getThursday(){
		return thursday;
	}

	public int getFriday(){
		return friday;
	}

	public int getSunday(){
		return sunday;
	}

	public int getWednesday(){
		return wednesday;
	}

	public int getTuesday(){
		return tuesday;
	}

	public int getSaturday(){
		return saturday;
	}
}