package com.example.bus.searchBusStation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.R;
import com.example.bus.RouteData;
import com.example.bus.busRealTime.BusRealTime;
import com.example.bus.model.RouteDataSource;
import com.example.bus.model.RouteEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * 搜尋功能和連結likelist
 */
@RequiresApi(api = Build.VERSION_CODES.P)
public class SearchBusStation extends AppCompatActivity implements SearchBusStationContract {

    private RecyclerView recyclerViewSearchList;
    EditText edittext;
    SearchAdapter searchAdapter;
    int flag = 0;
    List<RouteData> labels = new ArrayList<>();

    private SearchBusPresenter presenter = new SearchBusPresenter(this);

    //進來判斷字串和資料有沒有一樣
    private List<RouteData> getLabels() {


        RouteDataSource dataSource = new RouteDataSource();//資料
        RouteData label1;
        if (flag == 0) {
            flag = 1;
        } else {
            for (RouteEntity entity : dataSource.getRouteEntityList()) {
                label1 = new RouteData();

                if (entity.getRouteName().getZhTw().startsWith(edittext.getText().toString())) {
                    label1.setRouteName(entity.getRouteName().getZhTw());
                    labels.add(label1);
                }
                // }
            }
        }

        return labels;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbusstation);

        // 初始化清單元件
        recyclerViewSearchList = findViewById(R.id.searchlist);
        // 表示列表是垂直往下
        recyclerViewSearchList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // 設定RecyclerView Adapter
        searchAdapter = new SearchAdapter(this);
        searchAdapter.setOnItemClickListener(new SearchAdapter.onItemClickListener() { //丟事情(就是下面包的東西)給listener(做畫面轉跳，跳到公車動態)
            @Override
            public void onClickHello(String id,String name) {
                Log.d("TEST","onClickHello");
               Intent intent= new Intent(SearchBusStation.this, BusRealTime.class);
               intent.putExtra("RouteID",id);
                intent.putExtra("Routename",name);
                //intent.putExtra("stopID",id);
               startActivity(intent);
            }
        });
        recyclerViewSearchList.setAdapter(searchAdapter);


        // 配置輸入介面
        edittext = findViewById(R.id.editTextTextPersonName);
        edittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { //"有"+count+"個字符僅僅從"+start+"開始要替換"+ after+"個字符所替換")

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { //"有"+count+"個字符從"+start+" 位置開始  已經被"+ before+"箇舊的字符")

            }


            @Override
            public void afterTextChanged(Editable s) {//"最終內容：" + s.toString());
                Log.d("TEST","afterTextChanged "+s.toString());
                presenter.doSearch(s.toString());
            }
        });


        // 取得公車資訊
        presenter.getBusInfo();
    }


    @Override
    public void showSearchResult(List<RouteData> routeEntityList) {

        searchAdapter.updateData(routeEntityList);

    }


}
