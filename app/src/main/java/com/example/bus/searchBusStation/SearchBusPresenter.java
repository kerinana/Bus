package com.example.bus.searchBusStation;

import com.example.bus.RouteData;
import com.example.bus.model.RouteDataSource;
import com.example.bus.model.RouteEntity;

import java.util.ArrayList;
import java.util.List;

public class SearchBusPresenter {
    private SearchBusStationContract view;
    // 查詢結果
    private final List<RouteData> queryResult = new ArrayList<>();

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
        queryResult.clear();
        //routeEntityList取出來，一個一個放進labels裡
        for (RouteEntity entity : routeEntityList) {
            RouteData label1 = new RouteData();
            label1.setDepartureStopNameZh(entity.getDepartureStopNameZh());
            label1.setDestinationStopNameZh(entity.getDestinationStopNameZh());
            label1.setRouteName(entity.getRouteName().getZhTw());
            label1.setRouteID(entity.getRouteID());

            queryResult.add(label1);
        }

        //傳資料給view
        view.showSearchResult(queryResult);
    }

    /**
     * 將輸入資料和所有路線資料比對
     * @param input 搜尋的輸入字串
     */
    public void doSearch(String input){

        List<RouteData> searchResult = new ArrayList<>();
        for (RouteData entity : queryResult) {

            //比對結果相同時，把資料傳給view
            if (entity.getRouteName().contains(input)){
                searchResult.add(entity);
            }

        }
        //傳資料給view
        view.showSearchResult(searchResult);

    }
}
