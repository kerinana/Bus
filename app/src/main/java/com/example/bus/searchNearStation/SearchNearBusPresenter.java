package com.example.bus.searchNearStation;

import com.example.bus.DataCallback;
import com.example.bus.PTXService;
import com.example.bus.RouteData;
import com.example.bus.nearbybusmodel.Neardata;
import com.example.bus.nearbybusmodel.NeardataItem;

import java.util.ArrayList;
import java.util.List;

public class SearchNearBusPresenter {

    Neardata data = new Neardata();
    PTXService service = new PTXService();
    List<NeardataItem> nearBusDatalist = data.getNeardata();
    SearchNearStationContract view;

    SearchNearBusPresenter(SearchNearStationContract view) {
        this.view = view;
    }

    public void getNearBus(double Latitude, double Longitude) {

        List<RouteData> resultList = new ArrayList<>();

        //把現在位置丟上網抓附近站牌資料
        service.getRoutePosition(Latitude, Longitude, new DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                for (int i=0;i<data.size();i++) {
                    for (int j = 0; j < data.get(i).getStops().size(); j++) {
                        RouteData lable = new RouteData();
                        lable.setPositionLat(data.get(i).getStationPosition().getPositionLat());
                        lable.setPositionLon(data.get(i).getStationPosition().getPositionLon());
                        lable.setStationAddress(data.get(i).getStationAddress());
                        lable.setRouteName(data.get(i).getStops().get(j).getRouteName());//221
                        lable.setStopName(data.get(i).getStops().get(j).getStopName());//中原公園
                        resultList.add(lable);
                    }
                }

                view.showNearStation(resultList);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

    }
}
