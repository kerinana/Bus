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
    //???????????????????????????????????????????????? getMapAsync() ????????????

    private LocationCallback locationCallback;
    private GoogleApiClient mGoogleApiClient;
    private GoogleMap mMap;
    Location nowLocation;
    SearchNearBusPresenter presenter = new SearchNearBusPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_maps);
        EasyPermissions.requestPermissions(this, "?????????????????????", 1000, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.updateCallback();
    }

    /**
     * ??????onRequestPermissionsResult???????????????????????????
     *
     * @param requestCode  ?????????code
     * @param permissions  ????????????????????????
     * @param grantResults ?????????????????????
     *                     ?????????????????????
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //?????????????????????EasyPermission?????????
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    /**
     * ?????????????????????
     * ??????????????????????????????????????????????????????????????????
     *
     * @param requestCode
     * @param perms
     */
    @Override
    public void onPermissionsGranted(int requestCode, List perms) {
        //?????????google api??????api???????????????????????????????????????
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)   //?????????????????????????????????
                    .addOnConnectionFailedListener(this)//???????????????????????????????????????
                    .addApi(LocationServices.API)//???????????????????????????api
                    .build();

        }
        mGoogleApiClient.connect();
        Toast.makeText(this, "??????????????????", Toast.LENGTH_LONG).show();


        //??????google map??????
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

        //get???????????????????????????
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        String provider = "gps";
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);//????????????


        //????????????null?????????????????????
        if (location != null) {
            Log.i("LOCATION", location.getLatitude() + "/" + location.getLongitude());
            LatLng now = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(now, 15));
            mMap.addMarker(new MarkerOptions()
                    .position(now)
                    .title("????????????"));
        }


    }

    /**
     * ??????????????????
     */
    @Override
    public void onPermissionsDenied(int requestCode, List perms) {
        Toast.makeText(this, "??????????????????", Toast.LENGTH_LONG).show();
        /**
         * ??????????????????????????????????????????'NEVER ASK AGAIN.'??????'????????????'?????????????????????
         * ?????????????????????????????????????????????????????????????????????
         */
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }


    //?????????????????????????????????
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //????????????????????????
        LocationServices.getFusedLocationProviderClient(this).getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    LatLng now = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(now, 15f));
                    mMap.addMarker(new MarkerOptions()
                            .position(now)
                            .title("????????????"));
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
     * @param nearStation ?????????????????????
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
    //????????????
    public void showArriveTimeDialog(ArriveNotification data) {
        Log.d("BusRealTime","?????????");
        AlertDialogFragment dialogFragment = new AlertDialogFragment(data);
        dialogFragment
                .show(getSupportFragmentManager(), "alertDialogFragment");
    }
}
