package com.example.bus.busCrossStation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.example.bus.busRealTime.BusRealPresenter;
import com.example.bus.busRealTime.BusRealTime;
import com.example.bus.busStartTime.BusStartTime;
import com.example.bus.searchBusStation.SearchAdapter;
import com.example.bus.searchBusStation.SearchBusStation;

import java.util.ArrayList;
import java.util.List;

public class BusCrossStation extends AppCompatActivity implements BusCrossStationContract {

    RecyclerView busCrossRecycle;
    BusCrossStationPresenter presenter = new BusCrossStationPresenter(this);

    BusCrossStationAdapter busCrossStationAdapter = new BusCrossStationAdapter(this);

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscrossatation);

        //從busreal來
        Intent intent = getIntent();
        String stopid = intent.getStringExtra("stopid");
        String stopname = intent.getStringExtra("stopname");
        String Routeid = intent.getStringExtra("RouteID");
        String Routename = intent.getStringExtra("Routename");
        String Stationid = intent.getStringExtra("Stationid");
        int direceion =intent.getIntExtra("Direction",0);

        TextView stationname = findViewById(R.id.station);
        stationname.setText(stopname);

        busCrossRecycle = findViewById(R.id.buscross);
        busCrossRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        busCrossStationAdapter = new BusCrossStationAdapter(this);
        busCrossStationAdapter.setOnItemClickListener(new BusCrossStationAdapter.onItemClickListener() { //丟事情(就是下面包的東西)給listener做
            //跳畫面到發車時刻
            public void onClickHello(View view, int position, String routeid, String routename) {
                Intent intent = new Intent(BusCrossStation.this, BusRealTime.class);
                intent.putExtra("RouteID", routeid);
                intent.putExtra("Routename", routename);
                //intent.putExtra("stopID",id);
                startActivity(intent);

            }
        });
        busCrossRecycle.setAdapter(busCrossStationAdapter);
        presenter.getcross(Stationid,direceion);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.updateCallback();
    }

    /**
     * 更新畫面
     *
     * @param templist 為所有經過此站牌的資訊
     */
    @Override
    public void showCrossBus(List<RouteData> templist) {
        busCrossStationAdapter.update(templist);

    }

    //到站通知
    public void showArriveTimeDialog(ArriveNotification data) {
        Log.d("BusCross","到站囉");
        AlertDialogFragment dialogFragment = new AlertDialogFragment(data);
        dialogFragment
                .show(getSupportFragmentManager(), "alertDialogFragment");

    }

}
