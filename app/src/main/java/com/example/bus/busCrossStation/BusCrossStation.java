package com.example.bus.busCrossStation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.DialogFragment;
import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.busRealTime.BusRealTime;
import com.example.bus.busStartTime.BusStartTime;
import com.example.bus.searchBusStation.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class BusCrossStation extends AppCompatActivity implements BusCrossStationContract {

    RecyclerView busCrossRecycle;

    BusCrossStationAdapter busCrossStationAdapter;
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buscrossatation);
        busCrossRecycle=findViewById(R.id.buscross);

         busCrossStationAdapter= new BusCrossStationAdapter(this,getLabels());
        busCrossRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        showCrossBus();

    }
    private List<RouteData> getLabels() {
        List<RouteData> labels = new ArrayList<>();
        RouteData label1 = new RouteData();
        label1.setRouteID("1");
        label1.setDepartureStopNameZh("蘆洲");
        label1.setDestinationStopNameZh("北車");
        label1.setRouteName("221");
        label1.setStopName("尾站1");
        RouteData label2 = new RouteData();
        label2.setGPSTime(6);
        label2.setStopName("尾站2");
        label2.setRouteName("221");
        RouteData label3 = new RouteData();
        label3.setGPSTime(7);
        label3.setStopName("尾站3");
        label3.setRouteName("221");
        RouteData label4 = new RouteData();
        label4.setGPSTime(8);
        label4.setStopName("尾站4");
        label4.setRouteName("2");
        RouteData label5 = new RouteData();
        label5.setGPSTime(9);
        label5.setStopName("尾站5");
        label5.setRouteName("1");
        RouteData label6 = new RouteData();
        label6.setGPSTime(10);
        label6.setStopName("尾站6");
        label6.setRouteName("21");
        RouteData label7 = new RouteData();
        label7.setGPSTime(11);
        label7.setStopName("尾站7");
        label7.setRouteName("223");
        RouteData label8 = new RouteData();
        label8.setGPSTime(12);
        label8.setRouteName("221");
        label8.setStopName("尾站7");


        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
        labels.add(label6);
        labels.add(label7);
        labels.add(label8);


        return labels;
    }

    @Override
    public void showCrossBus() {//Recycleview的顯示

        busCrossStationAdapter.setOnItemClickListener( new BusCrossStationAdapter.onItemClickListener() { //丟事情(就是下面包的東西)給listener做
                    //跳畫面到發車時刻
                    public void onClickHello(View view, final int position) {
                        startActivity(new Intent(BusCrossStation.this, BusRealTime.class));
                    }
                });

        busCrossRecycle.setAdapter( busCrossStationAdapter);

    }

}
