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


    }
}
