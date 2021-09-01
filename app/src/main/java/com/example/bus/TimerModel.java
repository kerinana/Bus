package com.example.bus;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimerModel {

    public PTXService service = new PTXService();
    private Timer mTimer; //計時器，每1秒執行一次任務
    private MyTimerTask mTimerTask; //計時任務，判斷是否未操作時間到達3s
    private DataCallback<ArriveNotification> callback;
    private Handler handler = new Handler(Looper.getMainLooper());

    private static TimerModel instance=new TimerModel();
    private TimerModel(){}
    public static TimerModel getInstance(){
        return  instance;
    }
    public void registerCallback(DataCallback<ArriveNotification> call) {
        callback = call;
    }

    public void updataTime(String routeid, String stopid, int direction, int min) {
        MyTimerTask myTimerTask = new MyTimerTask(routeid, stopid, direction, min);
        startTimer(myTimerTask);
    }

    private class MyTimerTask extends TimerTask {

        private String routid;
        private String stopid;
        private int direction;
        private int min;

        MyTimerTask(String routid, String stopid, int direction, int min) {
            this.routid = routid;
            this.stopid = stopid;
            this.direction = direction;
            this.min = min;
        }

        @Override
        public void run() {
            service.getRouteTimeData(routid, new DataCallback<List<RouteData>>() {
                @Override
                public void onSuccess(List<RouteData> data) {
                    for (int i = 0; i < data.size(); i++) {
                        if ((data.get(i).getStopID().equals(stopid)) && (data.get(i).getDirection() == direction)) {
                            if (data.get(i).getEstimateTime() / 60 <= min) {
                                ArriveNotification lable = new ArriveNotification();
                                lable.setRouteName(data.get(i).getRouteName().getZhTw());
                                lable.setMin(min);
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        callback.onSuccess(lable);
                                        stopTimer();
                                    }
                                });

                            }
                        }
                    }
                    Log.d("BusRealTimeModel","到站囉");
                }

                @Override
                public void onFailure(String errorMessage) {

                }
            });
        }
    }

    //開始計時
    private void startTimer(MyTimerTask task) {
        mTimer = new Timer(true);
        mTimer.schedule(task, 0, 10000); //延時1000ms後執行，60s檢查一次
    }


    // 停止計時任務
    private void stopTimer() {
        mTimer.cancel();
    }
}
