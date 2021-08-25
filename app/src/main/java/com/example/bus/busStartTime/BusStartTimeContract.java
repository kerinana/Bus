package com.example.bus.busStartTime;

import com.example.bus.RouteData;

import java.util.List;

public interface BusStartTimeContract {

    /**
     * 顯示假日
     * @param  queryResult 要顯示的發車時間
     */
      void updateweekend(List<RouteData> queryResult) ;
    /**
     * 顯示平日
     *  @param  queryResult 要顯示的發車時間
     */
     void updateweekdays(List<RouteData> queryResult);
}
