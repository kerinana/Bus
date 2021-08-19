package com.example.bus.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RouteEntity {

	@SerializedName("ProviderID")
	private String providerID;

	@SerializedName("CityCode")
	private String cityCode;

	@SerializedName("VersionID")
	private int versionID;

	@SerializedName("FareBufferZoneDescriptionEn")
	private String fareBufferZoneDescriptionEn;

	@SerializedName("Operators")
	private List<OperatorsItem> operators;

	@SerializedName("BusRouteType")
	private int busRouteType;

	@SerializedName("AuthorityID")
	private String authorityID;

	@SerializedName("HasSubRoutes")
	private boolean hasSubRoutes;

	@SerializedName("DepartureStopNameZh")
	private String departureStopNameZh;

	@SerializedName("RouteUID")
	private String routeUID;

	@SerializedName("RouteID")
	private String routeID;

	@SerializedName("City")
	private String city;

	@SerializedName("DepartureStopNameEn")
	private String departureStopNameEn;

	@SerializedName("TicketPriceDescriptionZh")
	private String ticketPriceDescriptionZh;

	@SerializedName("DestinationStopNameEn")
	private String destinationStopNameEn;

	@SerializedName("TicketPriceDescriptionEn")
	private String ticketPriceDescriptionEn;

	@SerializedName("SubRoutes")
	private List<SubRoutesItem> subRoutes;

	public void setRouteName(RouteName routeName) {
		this.routeName = routeName;
	}

	@SerializedName("UpdateTime")
	private String updateTime;

	@SerializedName("RouteName")
	private RouteName routeName;

	@SerializedName("FareBufferZoneDescriptionZh")
	private String fareBufferZoneDescriptionZh;

	@SerializedName("RouteMapImageUrl")
	private String routeMapImageUrl;

	@SerializedName("DestinationStopNameZh")
	private String destinationStopNameZh;

	public String getProviderID(){
		return providerID;
	}

	public String getCityCode(){
		return cityCode;
	}

	public int getVersionID(){
		return versionID;
	}

	public String getFareBufferZoneDescriptionEn(){
		return fareBufferZoneDescriptionEn;
	}

	public List<OperatorsItem> getOperators(){
		return operators;
	}

	public int getBusRouteType(){
		return busRouteType;
	}

	public String getAuthorityID(){
		return authorityID;
	}

	public boolean isHasSubRoutes(){
		return hasSubRoutes;
	}

	public String getDepartureStopNameZh(){
		return departureStopNameZh;
	}

	public String getRouteUID(){
		return routeUID;
	}

	public String getRouteID(){
		return routeID;
	}

	public String getCity(){
		return city;
	}

	public String getDepartureStopNameEn(){
		return departureStopNameEn;
	}

	public String getTicketPriceDescriptionZh(){
		return ticketPriceDescriptionZh;
	}

	public String getDestinationStopNameEn(){
		return destinationStopNameEn;
	}

	public String getTicketPriceDescriptionEn(){
		return ticketPriceDescriptionEn;
	}

	public List<SubRoutesItem> getSubRoutes(){
		return subRoutes;
	}

	public String getUpdateTime(){
		return updateTime;
	}

	public RouteName getRouteName(){
		return routeName;
	}

	public String getFareBufferZoneDescriptionZh(){
		return fareBufferZoneDescriptionZh;
	}

	public String getRouteMapImageUrl(){
		return routeMapImageUrl;
	}

	public String getDestinationStopNameZh(){
		return destinationStopNameZh;
	}


}