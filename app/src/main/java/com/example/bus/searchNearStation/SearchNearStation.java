package com.example.bus.searchNearStation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.bus.AlertDialogFragment;
import com.example.bus.ArriveNotification;
import com.example.bus.DataCallback;
import com.example.bus.PTXService;
import com.example.bus.R;
import com.example.bus.RouteData;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
// [START maps_marker_on_map_ready]
public class SearchNearStation extends AppCompatActivity
        implements OnMapReadyCallback, EasyPermissions.PermissionCallbacks, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, SearchNearStationContract {

    // [START_EXCLUDE]
    // [START maps_marker_get_map_async]
    //取得地圖片段的處理常式，然後使用 getMapAsync() 註冊地圖

    private LocationCallback locationCallback;
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mMap;
    Location nowLocation;
    SearchNearBusPresenter presenter = new SearchNearBusPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_maps);
        EasyPermissions.requestPermissions(this, "可以給我權限ㄇ", 1000, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.updateCallback();
    }

    /**
     * 重寫onRequestPermissionsResult，用於接受請求結果
     *
     * @param requestCode  請求的code
     * @param permissions  一些列的請求權限
     * @param grantResults 用戶授權的結果
     *                     權限回調監聽器
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //將請求結果傳遞EasyPermission庫處理
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * 請求權限成功。
     * 可以彈窗顯示結果，也可執行具體需要的邏輯操作
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List perms) {
        //連線到google api，依api規範建立物件（未真正連線）
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)   //加入連線後要回報的對象
                    .addOnConnectionFailedListener(this)//加入連線後失敗要回報的對象
                    .addApi(LocationServices.API)//本次連線會使用到的api
                    .build();

        }
        mGoogleApiClient.connect();
        Toast.makeText(this, "用戶授權成功", Toast.LENGTH_LONG).show();


        //取得google map物件
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...
                }
            }
        };

        //get可取得各類系統服務
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        String provider = "gps";
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);//存取位置


        //如果不是null讓畫面移到那裡
        if (location != null) {
            Log.i("LOCATION", location.getLatitude() + "/" + location.getLongitude());
            LatLng now = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(now, 15));
            mMap.addMarker(new MarkerOptions()
                    .position(now)
                    .title("現在位置"));
        }


    }

    /**
     * 請求權限失敗
     */
    @Override
    public void onPermissionsDenied(int requestCode, List perms) {
        Toast.makeText(this, "用戶授權失敗", Toast.LENGTH_LONG).show();
        /**
         * 若是在權限彈窗中，用戶勾選瞭'NEVER ASK AGAIN.'或者'不在提示'，且拒絕權限。
         * 這時候，需要跳轉到設置界面去，讓用戶手動開啟。
         */
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }


    //放取得的位置程式碼放這
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //取得目前裝置位置
        LocationServices.getFusedLocationProviderClient(this).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    LatLng now = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(now, 15f));
                    mMap.addMarker(new MarkerOptions()
                            .position(now)
                            .title("現在位置"));
                }
                presenter.getNearBus(location.getLatitude(), location.getLongitude());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    /**
     * @param nearStation 附近所有的站牌
     */
    @Override
    public void showNearStation(List<RouteData> nearStation) {

        for (int i = 0; i < nearStation.size(); i++) {
            LatLng sydney = new LatLng(nearStation.get(i).getPositionLat(), nearStation.get(i).getPositionLon());
            this.mMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                    .title(nearStation.get(i).getStopName().getZhTw()))
                    .setSnippet(nearStation.get(i).getStationAddress());

            // [START_EXCLUDE silent]
            this.mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    //到站通知
    public void showArriveTimeDialog(ArriveNotification data) {
        Log.d("BusRealTime","到站囉");
        AlertDialogFragment dialogFragment = new AlertDialogFragment(data);
        dialogFragment
                .show(getSupportFragmentManager(), "alertDialogFragment");
    }
}
