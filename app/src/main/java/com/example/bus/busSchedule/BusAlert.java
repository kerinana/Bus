package com.example.bus.busSchedule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.bus.AlertDialogFragment;
import com.example.bus.ArriveNotification;
import com.example.bus.DataCallback;
import com.example.bus.PTXService;
import com.example.bus.R;
import com.example.bus.RouteData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BusAlert extends AppCompatActivity implements BusAlertContract{

    String stopid, routid;
    int direction;
    int time;
    BusSchedulePresent present = new BusSchedulePresent(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        routid = intent.getStringExtra("routeid");
        stopid = intent.getStringExtra("stopid");
        direction = intent.getIntExtra("direction", 0);
        time = intent.getIntExtra("time", 0);



    }

    @Override
    protected void onResume() {
        super.onResume();
        present.updateCallback();
        present.updateEstimae(routid, stopid, direction, time);

    }
    //到站通知
    public void showArriveTimeDialog(ArriveNotification data) {
        Log.d("BusAlert","到站囉");
        AlertDialogFragment dialogFragment = new AlertDialogFragment(data);
        dialogFragment
                .show(getSupportFragmentManager(), "alertDialogFragment");

    }
}
