package com.example.bus;

//import com.example.bus.realtimemodel.StopName;
import com.example.bus.nearbybusmodel.StationName;
import com.example.bus.nearbybusmodel.StationPosition;
import com.example.bus.realtimesequenceModel.RouteName;
import com.example.bus.realtimesequenceModel.StopName;
import com.example.bus.realtimesequenceModel.StopsItem;
import com.example.bus.starttimemodel.FrequencysItem;
import com.example.bus.starttimemodel.ServiceDay;

import java.util.List;

import com.example.bus.starttimemodel.TimetablesItem;
import com.google.gson.annotations.SerializedName;

public class RouteData {
    String RouteUID;
    String RouteID;
    String DepartureStopNameZh;
    String DestinationStopNameZh;
    RouteName RouteName;


    //List<String> StopName;//站牌名
    int DutyStatus;//1開始 2結束 0正常
    int A2EventType;//1進站 0離站
    Boolean  isLike = false;

    int GPSTime;//距離抵達站牌多久的時間
    String UpdateTime;//平台更新時間
    StopName StopName;//路線名稱
    int EstimateTime;//預估時間
    int StopSequence;//站牌順序
    int StopStatus =4;// 車輛狀態備註 : [0:'正常',1:'尚未發車',2:'交管不停靠',3:'末班車已過',4:'今日未營運']
    int Direction ;//去返程(該方向指的是此車牌車輛目前所在路線的去返程方向，非指站站牌所在路線的去返程方向，使用時請加值業者多加注意) : [0:'去程',1:'返程',2:'迴圈',255:'未知']
    String StopID;
    ServiceDay ServiceDay;
    String ArrivalTime;
    String StationID;
    Double PositionLon;
    Double PositionLat;
    String StationAddress;
    List<StopsItem> Stops;
    private List<FrequencysItem> Frequencys;
    private List<TimetablesItem> Timetables;
    private StationPosition StationPosition;
    private StationName StationName;

    public com.example.bus.nearbybusmodel.StationPosition getStationPosition() {
        return StationPosition;
    }

    public void setStationPosition(com.example.bus.nearbybusmodel.StationPosition stationPosition) {
        StationPosition = stationPosition;
    }

    public com.example.bus.nearbybusmodel.StationName getStationName() {
        return StationName;
    }

    public void setStationName(com.example.bus.nearbybusmodel.StationName stationName) {
        StationName = stationName;
    }

    public List<FrequencysItem> getFrequencys() {
        return Frequencys;
    }

    public void setFrequencys(List<FrequencysItem> frequencys) {
        Frequencys = frequencys;
    }

    public List<TimetablesItem> getTimetables() {
        return Timetables;
    }

    public void setTimetables(List<TimetablesItem> timetables) {
        this.Timetables = timetables;
    }

    public List<StopsItem> getStops() {
        return Stops;
    }

    public void setStops(List<StopsItem> stops) {
        Stops = stops;
    }

    public String getStationAddress() {
        return StationAddress;
    }

    public void setStationAddress(String stationAddress) {
        StationAddress = stationAddress;
    }

    public Double getPositionLon() {
        return PositionLon;
    }

    public void setPositionLon(Double positionLon) {
        PositionLon = positionLon;
    }

    public Double getPositionLat() {
        return PositionLat;
    }

    public void setPositionLat(Double positionLat) {
        PositionLat = positionLat;
    }

    public String getStationID() {
        return StationID;
    }

    public void setStationID(String stationID) {
        StationID = stationID;
    }

    public com.example.bus.starttimemodel.ServiceDay getServiceDay() {
        return ServiceDay;
    }

    public void setServiceDay(com.example.bus.starttimemodel.ServiceDay serviceDay) {
        ServiceDay = serviceDay;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getStopID() {
        return StopID;
    }

    public void setStopID(String stopID) {
        StopID = stopID;
    }

    public int getStopSequence() {
        return StopSequence;
    }

    public void setStopSequence(int stopSequence) {
        StopSequence = stopSequence;
    }

    public int getStopStatus() {
        return StopStatus;
    }

    public void setStopStatus(int stopStatus) {
        StopStatus = stopStatus;
    }

    public int getDirection() {
        return Direction;
    }

    public void setDirection(int direction) {
        Direction = direction;
    }

    public int getEstimateTime() {
        return EstimateTime;
    }

    public void setEstimateTime(int estimateTime) {
        EstimateTime = estimateTime;
    }

    public int getGPSTime() {
        return GPSTime;
    }

    public void setGPSTime(int GPSTime) {
        this.GPSTime = GPSTime;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public StopName getStopName() {
        return StopName;
    }

    public void setStopName(StopName stopName) {
        StopName = stopName;
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

    public RouteName getRouteName() {
        return RouteName;
    }

    public void setRouteName(RouteName routeName) {
        RouteName = routeName;
    }
}
