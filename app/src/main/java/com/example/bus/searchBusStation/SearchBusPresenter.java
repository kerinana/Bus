package com.example.bus.searchBusStation;

import static android.content.Context.MODE_PRIVATE;

import static com.example.bus.Const.PREF_KEY_BUS_FAVORITE_ROUTE;
import static com.example.bus.Const.PREF_NAME_BUS_APP_DATA;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.bus.RouteData;
import com.example.bus.model.RouteDataSource;
import com.example.bus.model.RouteEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SearchBusPresenter {
    private final Context context;
    private final SearchBusStationContract view;
    // 查詢結果
    private final List<RouteData> queryResult = new ArrayList<>();

    private final RouteDataSource dataSource = new RouteDataSource();

    SearchBusPresenter(Context context, SearchBusStationContract view) {
        this.view = view;
        this.context = context;
    }

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
     *
     * @param input 搜尋的輸入字串
     */
    public void doSearch(String input) {

        List<RouteData> searchResult = new ArrayList<>();
        for (RouteData entity : queryResult) {

            //比對結果相同時，把資料傳給view
            if (entity.getRouteName().contains(input)) {
                searchResult.add(entity);
            }

        }
        //傳資料給view
        view.showSearchResult(searchResult);

    }

    /**
     * 把資料加入我的最愛
     *
     * @param data 要加入我的最愛的公車路線的資料
     */
    @SuppressLint("ApplySharedPref")
    public void addToLike(RouteData data) {

                boolean flag=true;
                Gson gson = new Gson();

                //拿list轉為json，即可儲存到SharedPreferences中
                List<RouteData> alterSamples;
                //讀檔
                SharedPreferences pref = context.getSharedPreferences(PREF_NAME_BUS_APP_DATA, MODE_PRIVATE);
                //把資料從SharedPreferences取出來
                String likedata = pref.getString(PREF_KEY_BUS_FAVORITE_ROUTE, "[]");//第二格是找不到PREF_KEY_BUS_FAVORITE_ROUTE時，回傳[]
                //把格式轉成List<Routedata>的格式
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, com.example.bus.RouteData.class).getType();
                alterSamples = gson.fromJson(likedata, routeEntityTypeToken);

                //  判斷資料相同時，不做下面的if（就是去加入新資料）
                for(int i=0;i<alterSamples.size();i++){
                    if(alterSamples.get(i).getRouteName().equals(data.getRouteName())){
                        flag=false;
                    };
                }
                //把新的資料加入舊的清單中
                if(flag) {
                    alterSamples.add(data);


                    SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME_BUS_APP_DATA, MODE_PRIVATE).edit();

                    //把alterSamples轉成json
                    String json = gson.toJson(alterSamples);

                    //放進editor
                    editor.putString(PREF_KEY_BUS_FAVORITE_ROUTE, json);
                    editor.commit();
                }

    }
}
