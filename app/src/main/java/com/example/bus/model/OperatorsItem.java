package com.example.bus.model;

import com.google.gson.annotations.SerializedName;

public class OperatorsItem{

	@SerializedName("OperatorNo")
	private String operatorNo;

	@SerializedName("OperatorName")
	private OperatorName operatorName;

	@SerializedName("OperatorCode")
	private String operatorCode;

	@SerializedName("OperatorID")
	private String operatorID;

	public String getOperatorNo(){
		return operatorNo;
	}

	public OperatorName getOperatorName(){
		return operatorName;
	}

	public String getOperatorCode(){
		return operatorCode;
	}

	public String getOperatorID(){
		return operatorID;
	}
}