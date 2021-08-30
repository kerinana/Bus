package com.example.bus.busCrossStation;

import com.example.bus.DataCallback;
import com.example.bus.PTXService;
import com.example.bus.RouteData;
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

    public void getcross(String Stationid,String stopid,int direceion) {


        //拿stopid去sequence裡找有經過這個stopid的routeid routename  StopID 抓下來
        RouteSequence sequence = new RouteSequence();
        List<RouteSequenceItem> sequencelist = sequence.getRouteSequence();
        List<RouteData> templist = new ArrayList<>();

        RouteDataSource dataSource = new RouteDataSource();
        List<RouteEntity> dataSourcelist = dataSource.getRouteEntityList();//取得資料

        RealTimeData realtime = new RealTimeData();
        List<RealTimeDataItem> realTimeDataList = realtime.getRealTimeData();


        service.getRouteStationDataById(Stationid, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                //抓routeid routename
                for (RouteData entity : data) {
                    for (int i = 0; i < entity.getStops().size(); i++) {
                            RouteData lable = new RouteData();
                            lable.setRouteName(entity.getStops().get(i).getRouteName());//路線名 紅9
                            lable.setRouteID(entity.getStops().get(i).getRouteID());//路線id
                            lable.setStopID(entity.getStops().get(i).getStopID());//站id
                            templist.add(lable);
                    }
                }
                getGoRouteName(templist,stopid,direceion);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

    }
    /**
     * 取得去程路線名稱
     * @param stationList 依指定station所收集起來list（含routeID routename)
     * */
    public void getGoRouteName(List<RouteData> stationList,String stopid,int direceion){

        int j=0;
        for (RouteData entity : stationList) {

            //用RouteName找去程
            service.getRouteDataById(entity.getRouteID(), new DataCallback<List<RouteData>>() {
                @Override
                public void onSuccess(List<RouteData> data) {
                    for(int i=0;i<data.size();i++) {

                        if(direceion==0)entity.setDestinationStopNameZh(data.get(i).getDestinationStopNameZh());//
                        else entity.setDepartureStopNameZh(data.get(i).getDepartureStopNameZh());
                        entity.setDirection(direceion);
                    }
                    getTime(stationList,stopid,direceion);
                }

                @Override
                public void onFailure(String errorMessage) {

                }
            });

        }
    }
    /**
     * 取得預估時間
     * @param stationList 依指定station所收集起來list（含routeID routename 去程)
     * */
    public void getTime(List<RouteData> stationList,String stopid,int direceion){
        for(RouteData entity:stationList) {
            //用routeid找預估時間(一個一個去抓)
            //判斷stopid相同就存時間
            service.getRouteTimeData(entity.getRouteID(), new DataCallback<List<RouteData>>() {
                @Override
                public void onSuccess(List<RouteData> data) {
                    for(int i=0;i<data.size();i++) {
                        if ((data.get(i).getStopID().equals(entity.getStopID()))&& (direceion== data.get(i).getDirection())){
                            entity.setEstimateTime(data.get(i).getEstimateTime());
                            entity.setStopStatus(data.get(i).getStopStatus());
                        }
                    }
                    view.showCrossBus(stationList);
                }

                @Override
                public void onFailure(String errorMessage) {

                }
            });
        }
    }

}
