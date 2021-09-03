package com.example.bus.busCrossStation;

import com.example.bus.ArriveNotification;
import com.example.bus.DataCallback;
import com.example.bus.EstimateArrivalInfo;
import com.example.bus.PTXService;
import com.example.bus.RouteData;
import com.example.bus.TimerModel;
import com.example.bus.model.RouteDataSource;
import com.example.bus.model.RouteEntity;
import com.example.bus.realtimemodel.RealTimeData;
import com.example.bus.realtimemodel.RealTimeDataItem;
import com.example.bus.realtimesequenceModel.RouteSequence;
import com.example.bus.realtimesequenceModel.RouteSequenceItem;

import java.util.ArrayList;
import java.util.List;

public class BusCrossStationPresenter {

    BusCrossStationContract view;
    PTXService service = new PTXService();

    BusCrossStationPresenter(BusCrossStationContract view) {
        this.view = view;
    }


    public void getcross(String Stationid, int direceion) {


        //拿stopid去sequence裡找有經過這個stopid的routeid routename  StopID 抓下來
        List<RouteData> templist = new ArrayList<>();


        service.getRouteStationDataById(Stationid, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                List<String> routeids = new ArrayList<>();
                List<EstimateArrivalInfo> estimateArrivalInfoList = new ArrayList<>();
                //抓routeid routename
                for (RouteData entity : data) {
                    for (int i = 0; i < entity.getStops().size(); i++) {
                        EstimateArrivalInfo estimateArrivalInfo = new EstimateArrivalInfo();
                        RouteData lable = new RouteData();
                        lable.setRouteName(entity.getStops().get(i).getRouteName());//路線名 紅9
                        lable.setRouteID(entity.getStops().get(i).getRouteID());//路線id
                        lable.setStopID(entity.getStops().get(i).getStopID());//站id
                        lable.setDirection(entity.getDirection());
                        lable.setStationID(Stationid);
                        templist.add(lable);
                        estimateArrivalInfo.setRouteId(entity.getStops().get(i).getRouteID());
                        estimateArrivalInfo.setStopId(entity.getStops().get(i).getStopID());
                        estimateArrivalInfoList.add(estimateArrivalInfo);
                        routeids.add(entity.getStops().get(i).getRouteID());
                    }
                }
                getGoRouteName(templist, direceion, routeids, estimateArrivalInfoList);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

    }

    /**
     * 取得去程路線名稱
     *
     * @param stationList 依指定station所收集起來list（含routeID routename)
     * @param  routeids 一串routeid，所有station中的routeid全部搜集起來
     */
    public void getGoRouteName(List<RouteData> stationList, int direceion, List<String> routeids, List<EstimateArrivalInfo> estimateArrivalInfoList) {


        //用RouteName找去程
        service.getRouteDataByIdByList(routeids, new DataCallback<List<RouteData>>() {
           //int  listSize=stationList.size();
            @Override
            public void onSuccess(List<RouteData> data) {
                for (int i = 0; i < stationList.size(); i++) {
                    for (int j = 0; j < data.size(); j++) {


                        if(stationList.get(i).getRouteID().equals(data.get(j).getRouteID())){
                            stationList.get(i).setDestinationStopNameZh(data.get(j).getDestinationStopNameZh());
                            stationList.get(i).setDepartureStopNameZh(data.get(j).getDepartureStopNameZh());
                        }
                    }
                }
                getTime(stationList, direceion, estimateArrivalInfoList);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

    }

    /**
     * 取得預估時間
     *
     * @param stationList 依指定station所收集起來list（含routeID routename 去程)
     * @param  estimateArrivalInfoList 把routeid和stopid綁定，一起去查預估時間
     */
    public void getTime(List<RouteData> stationList, int direceion, List<EstimateArrivalInfo> estimateArrivalInfoList) {

        //用routeid找預估時間(一個一個去抓)
        //判斷stopid相同就存時間
        service.getRouteTimeDataBylist(estimateArrivalInfoList, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                for (int j = 0; j < stationList.size(); j++) {
                    for (int i = 0; i < data.size(); i++) {
//

                        if ((data.get(i).getStopID().equals(stationList.get(j).getStopID()))  && (stationList.get(j).getRouteID().equals(data.get(i).getRouteID()))) {
                                stationList.get(j).setDirection(data.get(i).getDirection());
                                stationList.get(j).setEstimateTime(data.get(i).getEstimateTime());
                                stationList.get(j).setStopStatus(data.get(i).getStopStatus());

                        }
                    }
                }
                view.showCrossBus(stationList);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

    //通知更新到站提醒
    public void updateCallback() {
        TimerModel.getInstance().registerCallback(new DataCallback<ArriveNotification>() {
            @Override
            public void onSuccess(ArriveNotification data) {
                view.showArriveTimeDialog(data);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }

}
