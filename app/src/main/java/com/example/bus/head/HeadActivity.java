package com.example.bus.head;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.SignatureTest;
import com.example.bus.busRealTime.BusRealTime;
import com.example.bus.searchBusStation.SearchBusStation;
import com.example.bus.searchNearStation.SearchNearStation;

import java.util.ArrayList;
import java.util.List;

public class HeadActivity extends AppCompatActivity implements HeadContract {

    RecyclerView recyclerViewSearchList;
    Button button;
    List<RouteData> test = new ArrayList<>();
    HeadPresent present = new HeadPresent(this, this);
    LikeAdapter likeAdapter = new LikeAdapter(this);
    SignatureTest signtest = new SignatureTest();
    //HeadPresent present;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head);


        Button nearbutton = findViewById(R.id.tosearchnearstationbutton);
        nearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadActivity.this, SearchNearStation.class);
                startActivity(intent);
            }
        });
        //我的最愛清單
        recyclerViewSearchList = findViewById(R.id.mylikelist);
        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//表示列表是垂直往下

        //按下清單會跳到公車動態畫面
        likeAdapter = new LikeAdapter(this);
        likeAdapter.setOnItemClickListener(new LikeAdapter.onItemClickListener() { //丟事情(就是下面包的東西)給listener
            @Override
            public void onClickHello(String id, String name) {//(做畫面轉跳，跳到公車動態)
                Log.d("TEST", "onClickHello");
                Intent intent = new Intent(HeadActivity.this, BusRealTime.class);
                intent.putExtra("RouteID", id);
                intent.putExtra("Routename", name);
                //intent.putExtra("stopID",id);
                startActivity(intent);
            }

            //按取消時，回傳位置，再去present做
            public void onClicklikecancel(int position) {
                present.cancellike(position);
            }


        });
        recyclerViewSearchList.setAdapter(likeAdapter);


        //搜尋站牌按鈕
        button = findViewById(R.id.tosearchstationbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadActivity.this, SearchBusStation.class);
                startActivity(intent);
            }
        });

//        signtest.getRouteData("9", new SignatureTest.DataCallback<List<RouteData>>() {
//            @Override
//            public void onSuccess(List<RouteData> data) {
//
//            }
//
//            @Override
//            public void onFailure(String errorMessage) {
//
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        present.getlikeitem(this);
    }

    /**
     * 更新我的最愛畫面
     *
     * @param likeList 為清單資訊
     */

    @Override
    public void updateLike(List<RouteData> likeList) {
        //取出like清單

        likeAdapter.updateData(likeList);

    }
}
