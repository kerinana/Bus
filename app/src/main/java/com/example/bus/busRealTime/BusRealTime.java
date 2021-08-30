package com.example.bus.busRealTime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.DialogFragment;
import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.busCrossStation.BusCrossStation;
import com.example.bus.busSchedule.BusScheduleDialogFragment;
import com.example.bus.busStartTime.BusStartTime;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * 公車動態
 */
public class BusRealTime extends AppCompatActivity implements BusRealTimeContract {

    private RecyclerView busRealRecycle;
    private BusRealPresenter presenter = new BusRealPresenter(this);
    TextView routename;
    DialogFragment dialogFragment;
    BusScheduleDialogFragment scheduleDialogFragment;
    BusRealTimeAdapter BusRealTimeadapter;
    String stopid, stopname, stationid;
    int direction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String Routeid = intent.getStringExtra("RouteID");
        String Routename = intent.getStringExtra("Routename");


        setContentView(R.layout.busrealtime);

        routename = findViewById(R.id.routename);
        routename.setText(Routename);

        BusRealTimeadapter = new BusRealTimeAdapter(this, Routeid, () ->
                dialogFragment
                        .show(getSupportFragmentManager(), "DialogFragment")
        );
        //傳stopid給buscross
        BusRealTimeadapter.setOnItemClickListener(new BusRealTimeAdapter.onItemClickListener() {

            //傳stopid給buscross(為了按經此站的功能)
            public void onclic(String id, String name, String station, int directionid) {
                stopid = id;
                stopname = name;
                stationid = station;
                direction = directionid;
            }
        });
        busRealRecycle = findViewById(R.id.busreal);
        //做RecycleView的Adapter
        busRealRecycle.setAdapter(BusRealTimeadapter);
        busRealRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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

            public void onClickschedule(View view, final int position) {
                scheduleDialogFragment
                        .show(getSupportFragmentManager(), "DialogFragment");


            }

        });
        //回程按鈕
        Button backroute = findViewById(R.id.backroute);
        backroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getbackRouteInfo(Routeid, 1);
            }
        });
        //去程按鈕
        Button goroute = findViewById(R.id.goroute);
        goroute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getgoRouteInfo(Routeid, 0);
            }
        });
        scheduleDialogFragment = new BusScheduleDialogFragment();
        presenter.getgoRouteInfo(Routeid, 0);
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


    public void dotimecaculate() {  //算距離抵達時間還要多久、監聽busscheduledialogfragment是按幾分鐘
        scheduleDialogFragment.setOnItemClickListener(new BusScheduleDialogFragment.onItemClickListener() {

            public void onClickthree(View view, final int position) { //三分鐘
                startActivity(new Intent(BusRealTime.this, BusStartTime.class));
            }

            public void onClickfive(View view, final int position) { //五分鐘
                startActivity(new Intent(BusRealTime.this, BusStartTime.class));
            }

            public void onClickseven(View view, final int position) {//七分鐘
                startActivity(new Intent(BusRealTime.this, BusStartTime.class));
            }

            public void onClickeleven(View view, final int position) { //十一分鐘
                startActivity(new Intent(BusRealTime.this, BusStartTime.class));
            }

        });
    }

}
