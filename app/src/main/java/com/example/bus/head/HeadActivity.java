package com.example.bus.head;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.busRealTime.BusRealTime;
import com.example.bus.model.RouteDataSource;
import com.example.bus.model.RouteEntity;
import com.example.bus.searchBusStation.SearchAdapter;
import com.example.bus.searchBusStation.SearchBusStation;

import java.util.ArrayList;
import java.util.List;

public class HeadActivity extends AppCompatActivity implements HeadContract{

    RecyclerView recyclerViewSearchList;
    Button button;
    List<RouteData> test = new ArrayList<>();

    private List<RouteData> getLabels() {
        List<RouteData> labels = new ArrayList<>();
//        RouteData label1 = new RouteData();
//        label1.setRouteID("1");
//        label1.setDepartureStopNameZh("蘆洲");
//        label1.setDestinationStopNameZh("北車");
//        label1.setRouteName("221");
//        labels.add(label1);
        //用資料
        RouteDataSource dataSource = new RouteDataSource();
        for (RouteEntity entity : dataSource.getRouteEntityList()) {
            RouteData label1 = new RouteData();
            label1.setRouteID(entity.getRouteID());
            label1.setDepartureStopNameZh(entity.getDepartureStopNameZh());
            label1.setDestinationStopNameZh(entity.getDestinationStopNameZh());
            label1.setRouteName(entity.getRouteName().getZhTw());
//            label1.setStopName("中原公園");
            labels.add(label1);
        }
        return labels;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head);
        button=findViewById(R.id.tosearchstationbutton);
        recyclerViewSearchList = findViewById(R.id.mylikelist);
        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//表示列表是垂直往下
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HeadActivity.this,SearchBusStation.class);
                startActivity(intent);
            }
        });

        updateLike(test);

    }




    @Override
    public void updateLike(List<RouteData> likeList) {
        SearchAdapter searchAdapter=new SearchAdapter(this);
        searchAdapter.updateData(getLabels());
        searchAdapter.setOnItemClickListener(new SearchAdapter.onItemClickListener() { //丟事情給listener做
            @Override
            public void onClickHello(String id,String name) {
                startActivity(new Intent(HeadActivity.this,BusRealTime.class));
            }
        });
        recyclerViewSearchList.setAdapter(searchAdapter);
    }
}
