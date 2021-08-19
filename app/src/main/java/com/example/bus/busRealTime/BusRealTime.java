package com.example.bus.busRealTime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.DialogFragment;
import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.busCrossStation.BusCrossStation;
import com.example.bus.busCrossStation.busSchedule.BusScheduleDialogFragment;
import com.example.bus.busStartTime.BusStartTime;

import java.util.ArrayList;
import java.util.List;

/**
 * 公車動態
 */
public class BusRealTime extends AppCompatActivity implements BusRealTimeContract {

    private RecyclerView busRealRecycle;
    TextView text;
    DialogFragment dialogFragment;
    BusScheduleDialogFragment scheduleDialogFragment;

    private List<RouteData> getLabels() {
        List<RouteData> labels = new ArrayList<>();
        RouteData label1 = new RouteData();
        label1.setRouteID("1");
        label1.setDepartureStopNameZh("蘆洲");
        label1.setDestinationStopNameZh("北車");
        label1.setRouteName("221");
        label1.setStopName("中原公園");
        RouteData label2 = new RouteData();
        label2.setGPSTime(6);
        label2.setStopName("中公園");
        RouteData label3 = new RouteData();
        label3.setGPSTime(7);
        label3.setStopName("原公園");
        RouteData label4 = new RouteData();
        label4.setGPSTime(8);
        label4.setStopName("中原園");
        RouteData label5 = new RouteData();
        label5.setGPSTime(9);
        label5.setStopName("中原公");
        RouteData label6 = new RouteData();
        label6.setGPSTime(10);
        label6.setStopName("中原公園");
        RouteData label7 = new RouteData();
        label7.setGPSTime(11);
        label7.setStopName("中公園");
        RouteData label8 = new RouteData();
        label8.setGPSTime(12);

        label8.setStopName("原公園");
        RouteData label9 = new RouteData();
        label9.setGPSTime(13);

        label9.setStopName("中原園");
        RouteData label10 = new RouteData();
        label10.setGPSTime(14);

        label10.setStopName("中原公");
        RouteData label11 = new RouteData();
        label11.setGPSTime(5);

        label11.setStopName("中原公園");
        RouteData label12 = new RouteData();
        label12.setGPSTime(6);

        label12.setStopName("中公園");
        RouteData label13 = new RouteData();
        label13.setGPSTime(7);

        label13.setStopName("原公園");
        RouteData label14 = new RouteData();
        label14.setGPSTime(8);

        label14.setStopName("中原園");
        RouteData label15 = new RouteData();
        label15.setGPSTime(9);

        label15.setStopName("中原公");
        RouteData label16 = new RouteData();
        label16.setGPSTime(10);

        label16.setStopName("中原公園");
        RouteData label17 = new RouteData();
        label17.setGPSTime(11);

        label17.setStopName("中公園");
        RouteData label18 = new RouteData();
        label18.setGPSTime(12);

        label18.setStopName("原公園");
        RouteData label19 = new RouteData();
        label19.setGPSTime(13);

        label19.setStopName("中原園");
        RouteData label20 = new RouteData();
        label20.setStopName("中原公");
        label20.setGPSTime(5);

        label8.setStopName("原公園");
        RouteData label91 = new RouteData();
        label91.setGPSTime(13);

        label91.setStopName("中原園");
        RouteData label101 = new RouteData();
        label101.setGPSTime(14);

        label101.setStopName("中原公");
        RouteData label112 = new RouteData();
        label112.setGPSTime(5);

        label112.setStopName("中原公園");
        RouteData label123 = new RouteData();
        label123.setGPSTime(6);

        label12.setStopName("中公園");
        RouteData label122 = new RouteData();
        label122.setGPSTime(7);

        label122.setStopName("原公園");
        RouteData label124 = new RouteData();
        label124.setGPSTime(8);

        label124.setStopName("中原園");
        RouteData label125 = new RouteData();
        label125.setGPSTime(9);

        label125.setStopName("中原公");
        RouteData label126 = new RouteData();
        label126.setGPSTime(10);

        label126.setStopName("中原公園");
        RouteData label137 = new RouteData();
        label137.setGPSTime(11);

        label137.setStopName("中公園");
        RouteData label128 = new RouteData();
        label128.setGPSTime(12);

        label128.setStopName("原公園");
        RouteData label129 = new RouteData();
        label129.setGPSTime(13);

        label129.setStopName("中原園");
        RouteData label220 = new RouteData();
        label220.setStopName("中原公");
        label220.setGPSTime(5);


        labels.add(label220);
        labels.add(label129);
        labels.add(label128);
        labels.add(label137);
        labels.add(label126);
        labels.add(label125);
        labels.add(label124);
        labels.add(label122);
        labels.add(label123);
        labels.add(label112);
        labels.add(label123);
        labels.add(label101);
        labels.add(label91);


        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);
        labels.add(label9);
        labels.add(label10);
        labels.add(label11);
        labels.add(label12);
        labels.add(label13);
        labels.add(label14);
        labels.add(label15);
        labels.add(label16);
        labels.add(label17);
        labels.add(label18);
        labels.add(label19);
        labels.add(label20);


        return labels;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.busrealtime);
        busRealRecycle = findViewById(R.id.busreal);
        dialogFragment = new DialogFragment();
        scheduleDialogFragment = new BusScheduleDialogFragment();
        showRealtime();
    }


    @Override
    public void showRoute() {//顯示路線名稱

        text = findViewById(R.id.routename);
        text.setText("221");
        showRealtime();

    }

    @Override
    public void showRealtime() { //顯示路線的時間和站牌

        //做dialog的畫面轉跳
        dialogFragment.setOnItemClickListener(new DialogFragment.onItemClickListener() { //丟事情(就是下面包的東西)給listener做
            //跳畫面到發車時刻
            public void onClickstarttime(View view, final int position) {
                startActivity(new Intent(BusRealTime.this, BusStartTime.class));
            }


            //跳畫面到經此站的公車
            public void onClickscrossbus(View view, final int position) {
                startActivity(new Intent(BusRealTime.this, BusCrossStation.class));
            }

            public void onClickschedule(View view, final int position) {
                scheduleDialogFragment
                        .show(getSupportFragmentManager(), "DialogFragment");


            }

        });


        busRealRecycle.setAdapter(new BusRealTimeAdapter(this, getLabels(), () ->
                dialogFragment
                        .show(getSupportFragmentManager(), "DialogFragment")
        ));


        busRealRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }


    public void dotimecaculate(){  //算距離抵達時間還要多久、監聽busscheduledialogfragment是按幾分鐘
        scheduleDialogFragment.setOnItemClickListener(new BusScheduleDialogFragment.onItemClickListener(){

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
