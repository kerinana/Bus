package com.example.bus.head;

import static android.content.Context.MODE_PRIVATE;

import static com.example.bus.Const.PREF_KEY_BUS_FAVORITE_ROUTE;
import static com.example.bus.Const.PREF_NAME_BUS_APP_DATA;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.example.bus.RouteData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HeadPresent {

    List<RouteData> data =new ArrayList<>();
    private HeadContract view;
    public HeadPresent(HeadContract view){
        this.view=view;
    }


    /**
     * 取得我的最愛清單
     * */

    public void getlikeitem(Context context){

        Gson gson=new Gson();
        //拿list轉為json，即可儲存到SharedPreferences中
        List<RouteData> alterSamples;
        //讀檔
        SharedPreferences pref = context.getSharedPreferences(PREF_NAME_BUS_APP_DATA, MODE_PRIVATE);
        //把資料從SharedPreferences取出來
        String likedata = pref.getString(PREF_KEY_BUS_FAVORITE_ROUTE, "[]");//第二格是找不到PREF_KEY_BUS_FAVORITE_ROUTE時，回傳[]
        //把格式轉成List<Routedata>的格式
        Type routeEntityTypeToken = TypeToken.getParameterized(List.class, com.example.bus.RouteData.class).getType();
        alterSamples = gson.fromJson(likedata, routeEntityTypeToken);

        view.updateLike(alterSamples);

    }
}
