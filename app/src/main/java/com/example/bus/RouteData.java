package com.example.bus;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteData {
    String RouteUID,RouteID,DepartureStopNameZh,DestinationStopNameZh,RouteName;


    //List<String> StopName;//站牌名
    int DutyStatus;//1開始 2結束 0正常
    int A2EventType;//1進站 0離站
//    Date GPSTime;//距離抵達站牌多久的時間
//    Date UpdateTime;//平台更新時間

    int GPSTime;//距離抵達站牌多久的時間
    int UpdateTime;//平台更新時間
    String StopName ;


    public int getGPSTime() {
        return GPSTime;
    }

    public void setGPSTime(int GPSTime) {
        this.GPSTime = GPSTime;
    }

    public  int getUpdateTime() {
        return  UpdateTime;
    }

    public void setUpdateTime(int updateTime) {
        UpdateTime=updateTime;
    }

    public String getStopName() {
        return StopName;
    }

    public void setStopName(String stopName) {
        StopName=stopName;
    }

    public int getDutyStatus() {
        return DutyStatus;
    }

    public void setDutyStatus(int dutyStatus) {
        DutyStatus = dutyStatus;
    }

    public int getA2EventType() {
        return A2EventType;
    }

    public void setA2EventType(int a2EventType) {
        A2EventType = a2EventType;
    }

//    public Date getGPSTime() {
//        return GPSTime;
//    }
//
//    public void setGPSTime(int year, int month, int date) {
//        this.GPSTime = GPSTime;
//    }
//
//    public Date getUpdateTime() {
//        return UpdateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        UpdateTime = updateTime;
//    }


    //=======================================================================
    Boolean isLike=false;

    public Boolean getLike() {
        return isLike;
    }

    public void setLike(Boolean like) {
        isLike = like;
    }

    public String getRouteUID() {
        return RouteUID;
    }

    public void setRouteUID(String routeUID) {
        RouteUID = routeUID;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String routeID) {
        RouteID = routeID;
    }

    public String getDepartureStopNameZh() {
        return DepartureStopNameZh;
    }

    public void setDepartureStopNameZh(String departureStopNameZh) {
        DepartureStopNameZh = departureStopNameZh;
    }

    public String getDestinationStopNameZh() {
        return DestinationStopNameZh;
    }

    public void setDestinationStopNameZh(String destinationStopNameZh) {
        DestinationStopNameZh = destinationStopNameZh;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }
}
