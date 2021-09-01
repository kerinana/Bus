package com.example.bus.searchNearStation;

import com.example.bus.ArriveNotification;
import com.example.bus.RouteData;

import java.util.List;

public interface SearchNearStationContract {

    /**
     * 顯示附近公車站牌
     *
     * @param nearStation 附近的所有站牌
     */
    void showNearStation(List<RouteData> nearStation);
    //顯示到站更新
     void showArriveTimeDialog(ArriveNotification data) ;

}
