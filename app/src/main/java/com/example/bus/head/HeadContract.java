package com.example.bus.head;

import com.example.bus.RouteData;

import java.util.List;

public interface HeadContract {

     /**
      * 更新我的最愛畫面
      * @param likeList 為清單資訊
      * */
     void updateLike(List<RouteData> likeList);
}
