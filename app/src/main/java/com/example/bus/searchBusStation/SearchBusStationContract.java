package com.example.bus.searchBusStation;

import com.example.bus.ArriveNotification;
import com.example.bus.RouteData;
import com.example.bus.model.RouteEntity;

import java.util.List;

public interface SearchBusStationContract {

    /**
     * 顯示查詢結果
     *
     * @param routeEntityList 要顯示在畫面上的資訊
     */
    void showSearchResult(List<RouteData> routeEntityList);
    //顯示到站更新
     void showArriveTimeDialog(ArriveNotification data) ;
//
}
