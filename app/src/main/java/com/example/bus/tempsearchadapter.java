//package com.example.bus.searchBusStation;
//
//import android.content.Intent;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.annotation.RequiresApi;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.bus.R;
//import com.example.bus.RouteData;
//import com.example.bus.busRealTime.BusRealTime;
//import com.example.bus.model.RouteDataSource;
//import com.example.bus.model.RouteEntity;
//import com.google.gson.Gson;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * 搜尋功能和連結likelist
// * */
//@RequiresApi(api = Build.VERSION_CODES.P)
//public class SearchBusStation extends AppCompatActivity implements SearchBusStationContract{
//
//    private RecyclerView recyclerViewSearchList;
//    String jsonStr="[{\"RouteUID\":\"TPE10415\",\"RouteID\":\"10415\",\"RouteName\":{\"Zh_tw\":\"221\",\"En\":\"221\"},\"DepartureStopNameZh\":\"蘆洲\",\"DestinationStopNameZh\":\"臺北車站\"}]";
//    Gson gson;
//    SearchAdapter searchAdapter;
//
//
//
//    private List<RouteData> getLabels() {
//        List<RouteData> labels = new ArrayList<>();
//        RouteDataSource dataSource =new RouteDataSource();
//        RouteEntity entity;
////        for( entity:dataSource.getRouteEntityList()){
////            if(entity.getRouteName().getZhTw().equals()){
////                RouteData label1 = new RouteData();
////                label1.getRouteName();
////            }
////
////
////        }
////
//        RouteData label1 = new RouteData();
//        label1.setRouteID("1");
//        label1.setDepartureStopNameZh("蘆洲");
//        label1.setDestinationStopNameZh("北車");
//        label1.setRouteName("221");
//        labels.add(label1);
//        return labels;
//    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.searchbusstation);
//        recyclerViewSearchList = findViewById(R.id.searchlist);
//        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));//表示列表是垂直往下
//        searchAdapter=new SearchAdapter(this,getLabels());
//
//        getLabels();
//        showSearchResult();
//    }
//
//
//
//
//    @Override
//    public void search() {
//
//
//    }
//
//    @Override
//    public void showSearchResult() {
//        searchAdapter.setOnItemClickListener(new SearchAdapter.onItemClickListener() { //丟事情(就是下面包的東西)給listener做
//            @Override
//            public void onClickHello(View view, final int position) {
//                startActivity(new Intent(SearchBusStation.this, BusRealTime.class));
//            }
//        });
//        recyclerViewSearchList.setAdapter(searchAdapter);
//    }
//
//
//}
