package com.example.bus.busSchedule;

import com.example.bus.ArriveNotification;

public interface BusAlertContract {

    //到站通知
     void showArriveTimeDialog(ArriveNotification data);
}
