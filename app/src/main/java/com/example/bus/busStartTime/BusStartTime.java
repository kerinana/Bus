package com.example.bus.busStartTime;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bus.R;
import com.example.bus.RouteData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BusStartTime extends AppCompatActivity implements BusStartTimeContract{

    BusStartTimePresenter presenter = new BusStartTimePresenter(this);
    String str = "", str2 = "";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busschedule);
        Intent intent = getIntent();
        String Routeid = intent.getStringExtra("RouteID");
        String Routename = intent.getStringExtra("Routename");

        TextView textView = findViewById(R.id.textView);
        textView.setText(Routename + "發車時刻表");


        //去抓時刻表
        presenter.getBusStartTime(Routeid);

        TextView weekdays = findViewById(R.id.weekdays);
        TextView weekend = findViewById(R.id.weekend);

        weekdays.setText(str);
        weekend.setText(str2);


    }

    /**
     * 顯示平日
     */
    public void updateweekdays(List<RouteData> queryResult) {

        int i = 1;

        //時間做排序
        Collections.sort(queryResult, (d1, d2) -> {
            String time1 = d1.getArrivalTime();
            String time2 = d2.getArrivalTime();
            //得到需要的時間格式
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date1, date2;
            try {
                //把資料轉換為時間格式
                date1 = format.parse(time1);
                date2 = format.parse(time2);
                if (date1 == null || date2 == null) return 0;
                return date1.compareTo(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0;
        });

        //排好的時間傳給textview去set
        for (RouteData query : queryResult) {
            if (i % 5 == 0) this.str += "  " + query.getArrivalTime() + "\n";
            else this.str += "  " + query.getArrivalTime();
            i++;
        }

    }

    /**
     * 顯示假日
     */
    public void updateweekend(List<RouteData> queryResult) {

        int i = 1;

        //時間做排序
        Collections.sort(queryResult, (d1, d2) -> {
            String time1 = d1.getArrivalTime();
            String time2 = d2.getArrivalTime();
            //得到需要的時間格式
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date date1, date2;
            try {
                //把資料轉換為時間格式
                date1 = format.parse(time1);
                date2 = format.parse(time2);
                if (date1 == null || date2 == null) return 0;
                return date1.compareTo(date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return 0;
        });

        //排好的時間傳給textview去set
        for (RouteData query : queryResult) {
            if (i % 5 == 0) this.str2 += "  " + query.getArrivalTime() + "\n";
            else this.str2 += "  " + query.getArrivalTime();
            i++;
        }

    }
}
