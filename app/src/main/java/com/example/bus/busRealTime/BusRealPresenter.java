package com.example.bus.busRealTime;

import com.example.bus.DataCallback;
import com.example.bus.PTXService;
import com.example.bus.RouteData;

import java.util.ArrayList;
import java.util.List;

public class BusRealPresenter {
    PTXService service = new PTXService();
    //找到的資料結果
    private final List<RouteData> querResult = new ArrayList<>();
    private BusRealTime view;

    BusRealPresenter(BusRealTime view) {
        this.view = view;
    }

    /**
     * 公車動態資料，拿路線號碼、抵達時間、經過所有路線
     * 去程
     */
    public void getgoRouteInfo(String routeId,int direction) {

        querResult.clear();
        //取站牌順序
        service.getRouteSequenDataById(routeId, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {

                //（做站名）把realtimesequence的資料抓下來 存在querResult裡(用順序的資料)
                for (RouteData entitytime : data) {
                    RouteData label1;
                    //如果id相同 把路線號碼、抵達時間、經過所有路線、去返程、ＩＤ存起來
                    if (entitytime.getRouteID().equals(routeId)) {
                        // 存每個站牌資料
                        for (int j = 0; j < entitytime.getStops().size(); j++) {
                            label1 = new RouteData();
                            label1.setRouteName(entitytime.getRouteName());//紅9 紅25
                            label1.setDirection(entitytime.getDirection());//去返程
                            label1.setStopID(entitytime.getStops().get(j).getStopID());//路線ＩＤ
                            label1.setStopName(entitytime.getStops().get(j).getStopName());//路線名
                            label1.setStationID(entitytime.getStops().get(j).getStationID());//station
                            querResult.add(label1);
                        }
                        break;
                    }
                }
                gettimeInternet(routeId,direction);

            }

            @Override
            public void onFailure(String errorMessage) {
            }
        });


    }

    /**
     * 取得預估時間資料
     * @param  direction 用來判斷去程回程
     * */
    public void gettimeInternet(String routeId,int direction){
        //放預估時間
        service.getRouteTimeData(routeId, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                //（做抵達時間）把預估時間放進querResult（用預估時間的資料）
                for (int i = 0; i < querResult.size(); i++) {
                    for (RouteData entitytime : data) {
                        RouteData label1;

                        //找對應的 抵達時間 放入querResult
                        if ((entitytime.getDirection() == direction) && (querResult.get(i).getStopID().equals(entitytime.getStopID()))) {
                            querResult.get(i).setEstimateTime(entitytime.getEstimateTime() / 60);
                            querResult.get(i).setStopStatus(entitytime.getStopStatus());
                            break;
                        }
                    }
                }
                view.showRealtime(querResult);
            }

            @Override
            public void onFailure(String errorMessage) {

            }

        });

    }

    /**
     * 公車動態資料，拿路線號碼、抵達時間、經過所有路線
     * 回程
     */
    public void getbackRouteInfo(String Routeid,int direction) {

        querResult.clear();
        //取站牌順序
        service.getRouteSequenDataById(Routeid, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {

                //（做站名）把realtimesequence的資料抓下來 存在querResult裡(用順序的資料)
                for (RouteData entitytime : data) {
                    RouteData label1;
                    //如果id相同 把路線號碼、抵達時間、經過所有路線、去返程、ＩＤ存起來
                    if (entitytime.getRouteID().equals(Routeid)) {

                        // 存每個站牌資料
                        for (int j = 0; j < entitytime.getStops().size(); j++) {
                            label1 = new RouteData();
                            label1.setRouteName(entitytime.getRouteName());//紅9 紅25
                            label1.setDirection(entitytime.getDirection());//去返程
                            label1.setStopID(entitytime.getStops().get(j).getStopID());//路線ＩＤ
                            label1.setStopName(entitytime.getStops().get(j).getStopName());//路線名
                            label1.setStationID(entitytime.getStops().get(j).getStationID());//station
                            //label1.setStopStatus(entitytime.);
                            //如果是去程就存起來（回程沒存）
                            if (entitytime.getDirection() == 1) querResult.add(label1);//判斷去程
                        }

                    }
                }
                //取得預估時間
                gettimeInternet(Routeid,direction);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });
    }
}
