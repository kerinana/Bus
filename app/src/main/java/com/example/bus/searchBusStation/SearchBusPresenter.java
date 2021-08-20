package com.example.bus.searchBusStation;

import com.example.bus.RouteData;
import com.example.bus.model.RouteDataSource;
import com.example.bus.model.RouteEntity;

import java.util.ArrayList;
import java.util.List;

public class SearchBusPresenter {
    SearchBusStationContract view;

    SearchBusPresenter(SearchBusStationContract view) {
        this.view = view;
    }

    RouteDataSource dataSource = new RouteDataSource();

    /**
     * 查詢公車號碼、起迄站資訊
     */
    public void getBusInfo() {
        //取得資料
        List<RouteEntity> routeEntityList = dataSource.getRouteEntityList();
        //轉成List<RouteData>
        List<RouteData> labels = new ArrayList<>();
        //routeEntityList取出來，一個一個放進labels裡
        for (RouteEntity entity : routeEntityList) {
            RouteData label1 = new RouteData();
            label1.setDepartureStopNameZh(entity.getDepartureStopNameZh());
            label1.setDestinationStopNameZh(entity.getDestinationStopNameZh());
            label1.setRouteName(entity.getRouteName().getZhTw());
            labels.add(label1);
        }

        //傳資料給view
        view.showSearchResult(labels);
    }
}
