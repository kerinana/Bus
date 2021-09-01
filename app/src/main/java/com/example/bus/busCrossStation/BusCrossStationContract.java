package com.example.bus.busCrossStation;

import com.example.bus.ArriveNotification;
import com.example.bus.RouteData;

import java.util.List;

public interface BusCrossStationContract {

    /**
     * 更新畫面
     * @param templist 經過此路線的所有公車資訊
     * */
    void showCrossBus(List<RouteData> templist);

    //到站通知
     void showArriveTimeDialog(ArriveNotification data);


}
