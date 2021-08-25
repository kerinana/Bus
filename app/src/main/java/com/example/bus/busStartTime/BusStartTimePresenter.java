package com.example.bus.busStartTime;

import android.view.View;

import com.example.bus.RouteData;
import com.example.bus.realtimemodel.RealTimeData;
import com.example.bus.realtimemodel.RealTimeDataItem;
import com.example.bus.realtimesequenceModel.RouteSequence;
import com.example.bus.realtimesequenceModel.RouteSequenceItem;
import com.example.bus.starttimemodel.StartTimeData;
import com.example.bus.starttimemodel.StartTimeDataItem;
import com.example.bus.starttimemodel.TimetablesItem;

import java.util.ArrayList;
import java.util.List;

public class BusStartTimePresenter {
    StartTimeData realTimeData = new StartTimeData();//時間
    private final List<RouteData> weekdays = new ArrayList<>();
    private final List<RouteData> weekend = new ArrayList<>();
    BusStartTime view;

    BusStartTimePresenter(BusStartTime view){
        this.view=view;
    }




    /**
     * 取得發車資訊
     */
    public void getBusStartTime(String Routeid) {
        Routeid="10261";
        List<StartTimeDataItem> realDataList = realTimeData.getStartTimeData();

        //（做站名）把realtimesequence的資料抓下來 存在querResult裡(用順序的資料)
        for (StartTimeDataItem entitytime : realDataList) {
            RouteData label1;
            //for() {
                //如果id相同 把路線號碼、抵達時間、經過所有路線、去返程、ＩＤ存起來
                if (entitytime.getRouteID().equals(Routeid)) {

                    //存每個時間
                    for (TimetablesItem entitytime2 : entitytime.getTimetables()) {

                        if (entitytime2.getServiceDay().getSunday()==1) {
                            label1 = new RouteData();
                            label1.setRouteName(entitytime.getRouteName().getZhTw());//紅9 紅25
                            label1.setDirection(entitytime.getDirection());//去返程
                            label1.setArrivalTime(entitytime2.getStopTimes().get(0).getArrivalTime());//取得車子抵達時間
                            label1.setServiceDay(entitytime2.getServiceDay());//取得服務日期
                            weekdays.add(label1);
                        } else if (entitytime2.getServiceDay().getMonday()==1) {
                            label1 = new RouteData();
                            label1.setRouteName(entitytime.getRouteName().getZhTw());//紅9 紅25
                            label1.setDirection(entitytime.getDirection());//去返程
                            label1.setArrivalTime(entitytime2.getStopTimes().get(0).getArrivalTime());//取得車子抵達時間
                            label1.setServiceDay(entitytime2.getServiceDay());//取得服務日期
                            weekend.add(label1);
                        }
                    }
                }
            //}

        }
        view.updateweekend(weekend);
        view.updateweekdays(weekdays);


    }
}
