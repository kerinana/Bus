package com.example.bus.busRealTime;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.AlertDialogFragment;
import com.example.bus.ArriveNotification;
import com.example.bus.DialogFragment;
import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.busCrossStation.BusCrossStation;
import com.example.bus.busSchedule.BusAlert;
import com.example.bus.busSchedule.BusScheduleDialogFragment;
import com.example.bus.busSchedule.BusSchedulePresent;
import com.example.bus.busStartTime.BusStartTime;

import java.util.List;

/**
 * 公車動態
 */
public class BusRealTime extends AppCompatActivity implements BusRealTimeContract {

    private RecyclerView busRealRecycle;
    private BusRealPresenter busRealPresenter = new BusRealPresenter(this);

    //BusSchedulePresent present = new BusSchedulePresent(this);

    TextView routename;
    DialogFragment dialogFragment;
    BusScheduleDialogFragment scheduleDialogFragment;
    BusRealTimeAdapter BusRealTimeadapter;
    String stopid, stopname, stationid;
    int direction;
    String Routeid;
    String Routename;
    int status;

    //BusRealPresenter busRealPresenter =new BusRealPresenter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();


        Routeid = intent.getStringExtra("RouteID");
        Routename = intent.getStringExtra("Routename");

        //通知更新到站提醒
        busRealPresenter.updateCallback();
        setContentView(R.layout.busrealtime);

        routename = findViewById(R.id.routename);
        routename.setText(Routename);

        BusRealTimeadapter = new BusRealTimeAdapter(this, Routeid, new BusRealTimeAdapter.OnOpenDialogListener() {
            @Override
            public void onOpenDialog(String id, String name, String station, int directionid,int statu) {
                stopid = id;
                stopname = name;
                stationid = station;
                direction = directionid;
                status=statu;
                openDialog();
            }
        });
        busRealRecycle = findViewById(R.id.busreal);
        //做RecycleView的Adapter
        busRealRecycle.setAdapter(BusRealTimeadapter);
        busRealRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        //回程按鈕
        Button backroute = findViewById(R.id.backroute);
        backroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busRealPresenter.getbackRouteInfo(Routeid, 1);
            }
        });
        //去程按鈕
        Button goroute = findViewById(R.id.goroute);
        goroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busRealPresenter.getgoRouteInfo(Routeid, 0);
            }
        });

        busRealPresenter.getgoRouteInfo(Routeid, 0);
        initializeDialog();
    }

    private void initializeDialog(){
        dialogFragment = new DialogFragment();
        //做dialog的畫面轉跳
        dialogFragment.setOnItemClickListener(new DialogFragment.onItemClickListener() { //丟事情(就是下面包的東西)給listener做
            //跳畫面到發車時刻(在聽DialogFragment的發車時刻)
            public void onClickstarttime(View view, final int position) {
                Intent intent = new Intent(BusRealTime.this, BusStartTime.class);
                intent.putExtra("RouteID", Routeid);
                intent.putExtra("Routename", Routename);
                startActivity(intent);
            }

            //跳畫面到經此站的公車(在聽DialogFragment的經過此站)
            public void onClickscrossbus(View view, final int position) {
                Intent intent = new Intent(BusRealTime.this, BusCrossStation.class);
                intent.putExtra("stopid", stopid);
                intent.putExtra("stopname", stopname);
                intent.putExtra("RouteID", Routeid);
                intent.putExtra("Routename", Routename);
                intent.putExtra("Stationid", stationid);
                intent.putExtra("Direction", direction);
                startActivity(intent);
            }

            //到站提醒
            public void onClickschedule(View view, final int position) {
                openScheduleDialog();
            }

        });
        scheduleDialogFragment = new BusScheduleDialogFragment();
        scheduleDialogFragment.setOnItemClickListener(new BusScheduleDialogFragment.onItemClickListener() {

            public void onClickthree(int position) { //三分鐘
                busRealPresenter.updateCallback();
                busRealPresenter.updateEstimae(Routeid, stopid, direction, 3,status);

            }

            public void onClickfive(int position) { //五分鐘
                busRealPresenter.updateCallback();
                busRealPresenter.updateEstimae(Routeid, stopid, direction, 5,status);
            }

            public void onClickseven(int position) {//七分鐘
                busRealPresenter.updateCallback();
                busRealPresenter.updateEstimae(Routeid, stopid, direction, 7,status);
            }

            public void onClickeleven(int position) { //十一分鐘
                busRealPresenter.updateCallback();
                busRealPresenter.updateEstimae(Routeid, stopid, direction, 11,status);
            }

        });
    }

    private void openDialog(){
        dialogFragment
                .show(getSupportFragmentManager(), "DialogFragment");
    }

    private void openScheduleDialog(){
        scheduleDialogFragment
                .show(getSupportFragmentManager(), "DialogFragment");
    }

    @Override
    protected void onResume() {
        super.onResume();
        busRealPresenter.updateCallback();
    }


    //到站通知
    public void showArriveTimeDialog(ArriveNotification data) {
        Log.d("BusRealTime","到站囉");
        AlertDialogFragment dialogFragment = new AlertDialogFragment(data);
        dialogFragment
                .show(getSupportFragmentManager(), "alertDialogFragment");
    }

    @Override
    public void showRoute() {

    }

    @Override
    public void showRealtime() {

    }

    /**
     * 顯示路線的時間和站牌
     */
    public void showRealtime(List<RouteData> queryResult) {
        //更新路線(stop)
        BusRealTimeadapter.UpDateRoute(queryResult);
    }

}
