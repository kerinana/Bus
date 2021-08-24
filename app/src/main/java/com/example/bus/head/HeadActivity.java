package com.example.bus.head;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    HeadPresent present =new HeadPresent(this);
    LikeAdapter likeAdapter=new LikeAdapter(this);
    //HeadPresent present;

    private List<RouteData> getLabels() {
        List<RouteData> labels = new ArrayList<>();
        //用資料
        RouteDataSource dataSource = new RouteDataSource();
        for (RouteEntity entity : dataSource.getRouteEntityList()) {
            RouteData label1 = new RouteData();
            label1.setRouteID(entity.getRouteID());
            label1.setDepartureStopNameZh(entity.getDepartureStopNameZh());
            label1.setDestinationStopNameZh(entity.getDestinationStopNameZh());
            label1.setRouteName(entity.getRouteName().getZhTw());
            labels.add(label1);
        }
        return labels;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head);

        //我的最愛清單
        recyclerViewSearchList = findViewById(R.id.mylikelist);
        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//表示列表是垂直往下

        //按下清單會跳到公車動態畫面
        likeAdapter = new LikeAdapter(this);
        likeAdapter.setOnItemClickListener(new LikeAdapter.onItemClickListener() { //丟事情(就是下面包的東西)給listener
            @Override
            public void onClickHello(String id,String name) {//(做畫面轉跳，跳到公車動態)
                Log.d("TEST","onClickHello");
                Intent intent= new Intent(HeadActivity.this, BusRealTime.class);
                intent.putExtra("RouteID",id);
                intent.putExtra("Routename",name);
                //intent.putExtra("stopID",id);
                startActivity(intent);
            }


        });
        recyclerViewSearchList.setAdapter(likeAdapter);



        //搜尋站牌按鈕
        button=findViewById(R.id.tosearchstationbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HeadActivity.this,SearchBusStation.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        present.getlikeitem(this);
    }
    //顯示我的最愛
    /**
     * 顯示我的最愛
     * @param likeList 為清單資訊
     * */

    @Override
    public void updateLike(List<RouteData> likeList) {
        //取出like清單

        likeAdapter.updateData(likeList);

    }
}
