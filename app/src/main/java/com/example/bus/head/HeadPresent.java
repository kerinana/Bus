package com.example.bus.head;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.view.View;

import com.example.bus.RouteData;

import java.util.ArrayList;
import java.util.List;

public class HeadPresent {

    List<RouteData> data =new ArrayList<>();
    private HeadContract view;
    public HeadPresent(HeadContract view){
        this.view=view;
    }

    public void getlikeitem(Context context){

        data.clear();
        //SharedPreferences的數量
        int number = context.getSharedPreferences("like", MODE_PRIVATE)
                .getAll().size();

        for(int i=0;i<number;i++){
            boolean like = context.getSharedPreferences("like", MODE_PRIVATE)
                    .contains("islike");
            String routeid = context.getSharedPreferences("like", MODE_PRIVATE)
                    .getString("RouteID","");

            String Departure = context.getSharedPreferences("like", MODE_PRIVATE)
                    .getString("Departure","");
            String Destination = context.getSharedPreferences("like", MODE_PRIVATE)
                    .getString("Destination","");

            String routename = context.getSharedPreferences("like", MODE_PRIVATE)
                    .getString("Routename","");


            RouteData label1 = new RouteData();
            label1.setDepartureStopNameZh(Departure);
            label1.setDestinationStopNameZh(Destination);
            label1.setRouteName(routename);
            label1.setRouteID(routeid);
            data.add(label1);
        }
        view.updateLike(data);

    }
}
