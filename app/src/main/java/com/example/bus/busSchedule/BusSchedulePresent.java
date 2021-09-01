package com.example.bus.busSchedule;
import android.util.Log;

import com.example.bus.ArriveNotification;
import com.example.bus.DataCallback;
import com.example.bus.TimerModel;

public class BusSchedulePresent {
    BusAlertContract view;

    public BusSchedulePresent(BusAlertContract con ){
        view=con;
    }

    //通知更新到站提醒
    public void updateCallback() {
        TimerModel.getInstance().registerCallback(new DataCallback<ArriveNotification> () {
            @Override
            public void onSuccess(ArriveNotification data) {
                Log.d("BusRealTimePresenter","到站囉");
                view.showArriveTimeDialog(data);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    public void updateEstimae(String routeid, String stopid, int direction, int time) {

        TimerModel.getInstance().updataTime(routeid, stopid, direction, time);
    }

}
