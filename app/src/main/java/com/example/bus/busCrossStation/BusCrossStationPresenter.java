package com.example.bus.busCrossStation;

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

    BusCrossStationPresenter(BusCrossStationContract view) {
        this.view = view;
    }

    public void getcross(String Stationid) {


        //拿stopid去sequence裡找有經過這個stopid的routeid routename  StopID 抓下來
        RouteSequence sequence = new RouteSequence();
        List<RouteSequenceItem> sequencelist = sequence.getRouteSequence();
        List<RouteData> templist = new ArrayList<>();

        RouteDataSource dataSource = new RouteDataSource();
        List<RouteEntity> dataSourcelist = dataSource.getRouteEntityList();//取得資料

        RealTimeData realtime = new RealTimeData();
        List<RealTimeDataItem> realTimeDataList = realtime.getRealTimeData();


        //抓routeid routename
        for (RouteSequenceItem entity : sequencelist) {

            for (int i = 0; i < entity.getStops().size(); i++) {
                if (entity.getStops().get(i).getStationID().equals(Stationid)) {
                    RouteData lable = new RouteData();
                    lable.setRouteName(entity.getRouteName());//路線名 紅9
                    lable.setRouteID(entity.getRouteID());//路線id
                    lable.setStopID(entity.getStops().get(i).getStopID());//站id
                    templist.add(lable);
                }

            }
        }
        //抓去程
        for (RouteEntity entity : dataSourcelist) {
            int i = 0;
            for (RouteData entity2 : templist) {
                if (entity.getRouteID().equals(entity2.getRouteID())) {
                    entity2.setDestinationStopNameZh(entity.getDestinationStopNameZh());//尾站名
                    entity2.setDirection(entity.getSubRoutes().get(i).getDirection());//去返程 : [0:'去程',1:'返程',
                }
                i++;
            }
        }
        //抓預估時間
        for (RealTimeDataItem entity : realTimeDataList) {
            for (RouteData entity2 : templist) {
                //判斷如果stopid direction routeid相同就抓預估時間
                if ((entity.getRouteID().equals(entity2.getRouteID())) && (entity.getStopID().equals(entity2.getStopID())) && (entity.getDirection() == entity2.getDirection())) {
                    entity2.setEstimateTime(entity.getEstimateTime());//尾站名
                }
            }
        }
        //templist為所有抓到的資料
        view.showCrossBus(templist);
    }

}
