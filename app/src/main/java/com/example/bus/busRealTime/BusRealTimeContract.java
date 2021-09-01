package com.example.bus.busRealTime;

import com.example.bus.ArriveNotification;

public interface BusRealTimeContract {

    void showRoute();


    /**
     * 顯示路線名稱和抵達時間
     * */
    void showRealtime();
    //到站通知
     void showArriveTimeDialog(ArriveNotification data);



}
