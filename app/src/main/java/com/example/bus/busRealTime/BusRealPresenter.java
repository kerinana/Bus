package com.example.bus.busRealTime;

import com.example.bus.RouteData;
import com.example.bus.realtimemodel.RealTimeData;
import com.example.bus.realtimemodel.RealTimeDataItem;
import com.example.bus.realtimesequenceModel.RouteSequence;
import com.example.bus.realtimesequenceModel.RouteSequenceItem;

import java.util.ArrayList;
import java.util.List;

public class BusRealPresenter {
    RealTimeData realTimeData= new RealTimeData();//時間
    RouteSequence routeSequenceData= new RouteSequence();//路線順序

    //找到的資料結果
    private final List<RouteData> querResult = new ArrayList<>();//
    private final List<RouteData> Result = new ArrayList<>();//最後結果
    private  BusRealTime view;

    BusRealPresenter(BusRealTime view){
        this.view=view;
    }
    /**
     * 公車動態資料，拿路線號碼、抵達時間、經過所有路線
     * 去程
     * */
    public void getgoRouteInfo(String Routeid){

        querResult.clear();
        List<RealTimeDataItem> realDataList= realTimeData.getRealTimeData();
         List<RouteSequenceItem> routeSequenceList= routeSequenceData.getRouteSequence();


        //（做站名）把realtimesequence的資料抓下來 存在querResult裡(用順序的資料)
        for (RouteSequenceItem entitytime : routeSequenceList ) {
            RouteData label1 ;
            //如果id相同 把路線號碼、抵達時間、經過所有路線、去返程、ＩＤ存起來
            if(entitytime.getRouteID().equals(Routeid)) {

                //存每個站牌資料
                for(int j=0;j<entitytime.getStops().size();j++){
                    label1 = new RouteData();
                    label1.setRouteName(entitytime.getRouteName().getZhTw());//紅9 紅25
                    label1.setDirection(entitytime.getDirection());//去返程
                    label1.setStopID(entitytime.getStops().get(j).getStopID());//路線ＩＤ
                    label1.setStopName(entitytime.getStops().get(j).getStopName());//路線名
                    //label1.setStopStatus(entitytime.);
                    //如果是去程就存起來（回程沒存）
                    if(entitytime.getDirection()==0)querResult.add(label1);//判斷去程
                }
            }
        }


        //（做抵達時間）把預估時間放進querResult（用預估時間的資料）
        for(int i=0;i<querResult.size();i++) {
                for (RealTimeDataItem entitytime : realDataList ) {
                    RouteData label1 ;

                    //找對應的 抵達時間 放入querResult
                    if ((entitytime.getDirection()==0)&&(querResult.get(i).getStopID().equals(entitytime.getStopID()))) {
                        querResult.get(i).setEstimateTime(entitytime.getEstimateTime()/60);
                        querResult.get(i).setStopStatus(entitytime.getStopStatus());
                        break;
                    }
            }

        }
         view.showRealtime(querResult);
    }



    /**
     * 公車動態資料，拿路線號碼、抵達時間、經過所有路線
     * 回程
     * */
    public void getbackRouteInfo(String Routeid){

        querResult.clear();
        List<RealTimeDataItem> realDataList= realTimeData.getRealTimeData();
        List<RouteSequenceItem> routeSequenceList= routeSequenceData.getRouteSequence();


        //（做站名）把realtimesequence的資料抓下來 存在querResult裡(用順序的資料)
        for (RouteSequenceItem entitytime : routeSequenceList ) {
            RouteData label1 ;
            //如果id相同 把路線號碼、抵達時間、經過所有路線、去返程、ＩＤ存起來
            if(entitytime.getRouteID().equals(Routeid)) {

                //存每個站牌資料
                for(int j=0;j<entitytime.getStops().size();j++){
                    label1 = new RouteData();
                    label1.setRouteName(entitytime.getRouteName().getZhTw());//紅9 紅25
                    label1.setDirection(entitytime.getDirection());//去返程
                    label1.setStopID(entitytime.getStops().get(j).getStopID());//路線ＩＤ
                    label1.setStopName(entitytime.getStops().get(j).getStopName());//路線名
                    if(entitytime.getDirection()==1)querResult.add(label1);//判斷回程
                }
            }
        }


        //（做抵達時間）把預估時間放進querResult（用預估時間的資料）
        for(int i=0;i<querResult.size();i++) {
            for (RealTimeDataItem entitytime : realDataList ) {
                RouteData label1 ;

                //如果預估時間的站名和

                if ((entitytime.getDirection()==1)&&(querResult.get(i).getStopID().equals(entitytime.getStopID()))) {
                    querResult.get(i).setEstimateTime(entitytime.getEstimateTime()/60);
                    querResult.get(i).setStopStatus(entitytime.getStopStatus());
                    break;
                }
            }

        }
        view.showRealtime(querResult);
    }


}
