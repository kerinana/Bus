package com.example.bus.busStartTime;
import com.example.bus.DataCallback;
import com.example.bus.PTXService;
import com.example.bus.RouteData;
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
    PTXService service=new PTXService();

    BusStartTimePresenter(BusStartTime view){
        this.view=view;
    }




    /**
     * 取得發車資訊
     */
    public void getBusStartTime(String Routeid) {

        service.getRouteStartTimeByRouteID(Routeid, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                if (data.get(0).getTimetables() != null){

                    for (int i = 0; i < data.get(0).getTimetables().size(); i++) {
                        if (data.get(0).getTimetables().get(i).getServiceDay().getSunday() == 1) {
                            RouteData label1 = new RouteData();
                            label1.setRouteName(data.get(0).getRouteName());//紅9 紅25
                            label1.setDirection(data.get(0).getDirection());//去返程
                            label1.setArrivalTime(data.get(0).getTimetables().get(i).getStopTimes().get(0).getArrivalTime());//取得車子抵達時間
                            label1.setServiceDay(data.get(0).getTimetables().get(i).getServiceDay());//取得服務日期
                            weekend.add(label1);
                        } else if (data.get(0).getTimetables().get(i).getServiceDay().getMonday() == 1) {
                            RouteData label1 = new RouteData();
                            label1.setRouteName(data.get(0).getRouteName());//紅9 紅25
                            label1.setDirection(data.get(0).getDirection());//去返程
                            label1.setArrivalTime(data.get(0).getTimetables().get(i).getStopTimes().get(0).getArrivalTime());//取得車子抵達時間
                            label1.setServiceDay(data.get(0).getTimetables().get(i).getServiceDay());//取得服務日期
                            weekdays.add(label1);
                        }
                    }
            }
                else {
                    for (int i = 0; i < data.get(0).getFrequencys().size(); i++) {
                        if (data.get(0).getFrequencys().get(i).getServiceDay().getSunday() == 1) {
                            RouteData label1 = new RouteData();
                            label1.setRouteName(data.get(0).getRouteName());//紅9 紅25
                            label1.setDirection(data.get(0).getDirection());//去返程
                            label1.setArrivalTime(data.get(0).getFrequencys().get(i).getStartTime());//取得車子抵達時間
                            label1.setServiceDay(data.get(0).getFrequencys().get(i).getServiceDay());//取得服務日期
                            weekend.add(label1);
                        } else if (data.get(0).getFrequencys().get(i).getServiceDay().getMonday() == 1) {
                            RouteData label1 = new RouteData();
                            label1.setRouteName(data.get(0).getRouteName());//紅9 紅25
                            label1.setDirection(data.get(0).getDirection());//去返程
                            label1.setArrivalTime(data.get(0).getFrequencys().get(i).getStartTime());//取得車子抵達時間
                            label1.setServiceDay(data.get(0).getFrequencys().get(i).getServiceDay());//取得服務日期
                            weekdays.add(label1);
                        }
                    }

                }



                view.updateweekend(weekend);
                view.updateweekdays(weekdays);

            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

    }
}
