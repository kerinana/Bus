package com.example.bus.searchBusStation;

import static android.content.Context.MODE_PRIVATE;

import static com.example.bus.Const.PREF_KEY_BUS_FAVORITE_ROUTE;
import static com.example.bus.Const.PREF_NAME_BUS_APP_DATA;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.bus.RouteData;
import com.example.bus.SignatureTest;
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
    SignatureTest signtest = new SignatureTest();
    List<RouteData> routeDataList = new ArrayList<>();
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

        queryResult.clear();
        //routeEntityList取出來，一個一個放進labels裡
        for (RouteData entity : routeDataList) {
            RouteData label1 = new RouteData();
            label1.setDepartureStopNameZh(entity.getDepartureStopNameZh());
            label1.setDestinationStopNameZh(entity.getDestinationStopNameZh());
            label1.setRouteName(entity.getRouteName());
            label1.setRouteID(entity.getRouteID());

            //從sharepreference裡拿like清單的like資訊
            Gson gson = new Gson();
            List<RouteData> alterSamples;
            SharedPreferences pref = context.getSharedPreferences(PREF_NAME_BUS_APP_DATA, MODE_PRIVATE);
            String likedata = pref.getString(PREF_KEY_BUS_FAVORITE_ROUTE, "[]");//第二格是找不到PREF_KEY_BUS_FAVORITE_ROUTE時，回傳[]
            Type routeEntityTypeToken = TypeToken.getParameterized(List.class, com.example.bus.RouteData.class).getType();
            alterSamples = gson.fromJson(likedata, routeEntityTypeToken);
            for (int i = 0; i < alterSamples.size(); i++) {
                //如果在我的最愛清單中就把它存true
                if (alterSamples.get(i).getRouteName().equals(entity.getRouteName())) {
                    label1.setLike(true);
                    break;
                }
            }

            queryResult.add(label1);
        }

        //傳資料給view
        view.showSearchResult(queryResult);
    }

    /**
     * 將輸入的資料丟上網比對後
     * 抓下資料
     * 顯示出來
     *
     * @param input 搜尋的輸入字串
     */
    public void doSearch(String input) {
        signtest.getRouteData(input, new SignatureTest.DataCallback<List<RouteData>>() {
            @Override
            public void onSuccess(List<RouteData> data) {
                routeDataList.clear();
                routeDataList.addAll(data);

                //判斷星號
                islikeitem(routeDataList);

                //傳資料給view
                view.showSearchResult(routeDataList);
            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });


    }

    /**
     * 從sharepreferencr裡拿資料出來
     * 判斷是否有加星號
     */
    public void islikeitem(List<RouteData> datalist) {

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

        //比對輸入的資料是否有加過星星
        for(RouteData entity :datalist){
            for(int i=0;i<alterSamples.size();i++) {
                if (alterSamples.get(i).getRouteName().getZhTw().equals(entity.getRouteName().getZhTw())) {
                    entity.setLike(true);
                }
            }
        }


    }

    /**
     * 把資料加入我的最愛(存進sharepreference)
     *
     * @param data 要加入我的最愛的公車路線的資料
     */
    @SuppressLint("ApplySharedPref")
    public void addToLike(RouteData data) {

        boolean flag = true;
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

        //  判斷資料相同時，不做下面的if（就是不加入新資料）
        for (int i = 0; i < alterSamples.size(); i++) {
            if (alterSamples.get(i).getRouteName().getZhTw().equals(data.getRouteName().getZhTw())) {
                flag = false;
            }
            ;
        }
        //把新的資料加入舊的清單中
        if (flag) {
            alterSamples.add(data);
            SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME_BUS_APP_DATA, MODE_PRIVATE).edit();

            //把alterSamples轉成json
            String json = gson.toJson(alterSamples);

            //放進editor
            editor.putString(PREF_KEY_BUS_FAVORITE_ROUTE, json);
            editor.commit();
        }

    }

    /**
     * 取消星星(存進sharepreference)
     *
     * @param routename 為要刪除的routename
     */
    public void cancellike(String routename) {

        int i;
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

        //找清單中的第幾個和要刪除的資料一樣
        for (i = 0; i < alterSamples.size(); i++) {
            if (alterSamples.get(i).getRouteName().getZhTw().equals(routename)) break;

        }
        //把要刪除的刪掉
        alterSamples.remove(i);

        //開始編輯
        SharedPreferences.Editor editor = context.getSharedPreferences(PREF_NAME_BUS_APP_DATA, MODE_PRIVATE).edit();

        //把alterSamples轉成json
        String json = gson.toJson(alterSamples);

        //放進editor
        editor.putString(PREF_KEY_BUS_FAVORITE_ROUTE, json);
        editor.commit();

    }
}
