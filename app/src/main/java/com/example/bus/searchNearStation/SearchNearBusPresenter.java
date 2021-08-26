package com.example.bus.searchNearStation;

import com.example.bus.RouteData;
import com.example.bus.nearbybusmodel.Neardata;
import com.example.bus.nearbybusmodel.NeardataItem;

import java.util.ArrayList;
import java.util.List;

public class SearchNearBusPresenter {

    Neardata data = new Neardata();
    List<NeardataItem> nearBusDatalist = data.getNeardata();
    SearchNearStationContract view;

    SearchNearBusPresenter(SearchNearStationContract view) {
        this.view = view;
    }

    public void getNearBus() {

        List<RouteData> resultList = new ArrayList<>();


        for (NeardataItem entity : nearBusDatalist) {


            for (int j = 0; j < entity.getStops().size(); j++) {
                RouteData lable = new RouteData();
                lable.setPositionLat(entity.getStationPosition().getPositionLat());
                lable.setPositionLon(entity.getStationPosition().getPositionLon());
                lable.setRouteName(entity.getStops().get(j).getRouteName().getZhTw());//221
                lable.setStopName(entity.getStops().get(j).getStopName());//中原公園
                lable.setStationAddress(entity.getStationAddress());
                resultList.add(lable);
            }
        }
        view.showNearStation(resultList);
    }
}
