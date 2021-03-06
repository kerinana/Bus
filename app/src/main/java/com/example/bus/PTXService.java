package com.example.bus;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;

public class PTXService {

    //Model

    /***API invoker***/

    //路徑資料
    public void getRouteData(String routeName, DataCallback<List<RouteData>> callback) {
        requestRouteDataByRouteName("NewTaipei", routeName, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });
    }

    public void getRouteDataById(String routeid, DataCallback<List<RouteData>> callback) {
        requestRouteDataById("NewTaipei", routeid, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });
    }

    public void getRouteDataByIdByList(List<String> routeids, DataCallback<List<RouteData>> callback) {
        requestRouteDataByIdList("NewTaipei", routeids, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });
    }

    //預估時間
    public void getRouteTimeData(String routeID, DataCallback<List<RouteData>> callback) {
        requestRouteTimeDataByRouteID("NewTaipei", routeID, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });
    }
    public void getRouteTimeDataBylist(List<EstimateArrivalInfo> estimateArrivalInfoList, DataCallback<List<RouteData>> callback) {
        requestRouteTimeDataByRouteIDByList("NewTaipei", estimateArrivalInfoList, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });
    }


    //站牌名順序
    public void getRouteSequenDataById(String routeId, DataCallback<List<RouteData>> callback) {
        requestRouteSequenDataByRouteID("NewTaipei", routeId, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });

    }

    //Station
    public void getRouteStationDataById(String stationId, DataCallback<List<RouteData>> callback) {
        requestRouteStationDataByRouteID("NewTaipei", stationId, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });

    }

    //以routeid抓發車時刻表
    public void getRouteStartTimeByRouteID(String routeId, DataCallback<List<RouteData>> callback) {
        requestRouteStartTimeByRouteID("NewTaipei", routeId, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });

    }

    public void getRoutePosition(double Latitude, double Longitude, DataCallback<List<RouteData>> callback) {
        requestRoutePosition("NewTaipei", Latitude, Longitude, new RequestCallback() {
            @Override
            public void onSuccess(String json) {
                Gson gson = new Gson();
                Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteData.class).getType();
                List<RouteData> result = gson.fromJson(json, routeEntityTypeToken);
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(String errorMessage) {
                callback.onFailure(errorMessage);
            }
        });

    }

    /***Url Generate***/
    //去網路抓資料，以現在位置抓附近站牌
    private void requestRoutePosition(String city, double Latitude, double Longitude, RequestCallback callback) {
        String filter = "nearby( " + Latitude + "," + Longitude + "," + "1000" + ")";
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/Station/City/" + city + "?$spatialFilter=" + filter + "&$format=JSON";
        request(url, callback);
    }

    //去網路抓資料，以routeid，抓發車時刻
    private void requestRouteStartTimeByRouteID(String city, String routeid, RequestCallback callback) {
        String filter = "RouteID eq " + "'" + routeid + "'";
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/Schedule/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }

    //去網路抓資料，以routeid為搜尋的，抓station
    private void requestRouteStationDataByRouteID(String city, String stationId, RequestCallback callback) {
        String filter = "StationID eq " + "'" + stationId + "'";
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/Station/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }

    //去網路抓資料，以routeid為搜尋的，抓時間
    private void requestRouteTimeDataByRouteID(String city, String routeID, RequestCallback callback) {
        String filter = "RouteID eq " + "'" + routeID + "'";
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/EstimatedTimeOfArrival/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }
    //去網路抓資料，以routeid為搜尋的，抓時間(用list)
    private void requestRouteTimeDataByRouteIDByList(String city, List<EstimateArrivalInfo> estimateArrivalInfoList, RequestCallback callback) {
        String filter = "";

        for(int i = 0; i < estimateArrivalInfoList.size(); i++){
            filter+="RouteID eq '"+estimateArrivalInfoList.get(i).routeId +"' and StopID eq '" +estimateArrivalInfoList.get(i).stopId+"'";
            if (i != estimateArrivalInfoList.size() - 1) filter+=" or ";

        }

        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/EstimatedTimeOfArrival/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }

    //抓順序
    private void requestRouteSequenDataByRouteID(String city, String routeID, RequestCallback callback) {
        String filter = "RouteID eq " + "'" + routeID + "'";
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/DisplayStopOfRoute/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }

    //去網路抓資料，以routename為搜尋的，抓路線名
    private void requestRouteDataByRouteName(String city, String routeName, RequestCallback callback) {
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/Route/City/" + city + "/" + routeName + "?$format=JSON";
        request(url, callback);
    }

    //以routeid，抓路線名
    private void requestRouteDataById(String city, String routeId, RequestCallback callback) {
        String filter = "RouteID eq " + "'" + routeId + "'";
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/Route/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }

    private void requestRouteDataByIdList(String city, List<String> routeId, RequestCallback callback) {
        StringBuilder filter = new StringBuilder();
        for (int i = 0; i < routeId.size(); i++) {
            filter.append("RouteID eq " + "'").append(routeId.get(i)).append("'");
            if (i != routeId.size() - 1) filter.append(" or ");
        }
        String url = "https://ptx.transportdata.tw/MOTC/v2/Bus/Route/City/" + city + "?$filter=" + filter + "&$format=JSON";
        request(url, callback);
    }


    /****Network Request*****/

    private void request(String apiUrl, RequestCallback callback) {
        RequestAsyncTask task = new RequestAsyncTask(apiUrl, callback);
        task.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private static class RequestAsyncTask extends AsyncTask<String, Void, String> {

        private RequestCallback callback;
        private final String apiUrl;

        public RequestAsyncTask(String apiUrl, RequestCallback callback) {
            this.callback = callback;
            this.apiUrl = apiUrl;
        }

        @Override
        protected String doInBackground(String... strings) {
            //加了http的協定的與網頁做連線的方法
            HttpURLConnection connection;

            // 申請的APPID
            String APPID = "5a3d0f61d01f437193f3d619cdf0c893";
            // 申請的APPKey
            String APPKey = "5ZXmS2l8zmsNlupniW0Eg8TETp8";

            // 取得當下的UTC時間，Java8有提供時間格式DateTimeFormatter.RFC_1123_DATE_TIME
            String xdate = getServerTime();
            String SignDate = "x-date: " + xdate;
            String respond = "";

            String Signature = "";
            try {
                // 取得加密簽章
                Signature = HMAC_SHA1.Signature(SignDate, APPKey);
            } catch (SignatureException e1) {
                Log.e("SignatureTest", e1.toString());
            }

            System.out.println("Signature :" + Signature);
            String sAuth = "hmac username=\"" + APPID + "\", algorithm=\"hmac-sha1\", headers=\"x-date\", signature=\""
                    + Signature + "\"";
            System.out.println(sAuth);
            try {
                URL url = new URL(apiUrl);
                //getProtocol 獲取協議名稱
                //不區分大小寫的判斷是否相同
                if ("https".equalsIgnoreCase(url.getProtocol())) {
                    SslUtils.ignoreSsl();
                }
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");//設置請求方式
                connection.setRequestProperty("Authorization", sAuth);//設置請求屬性
                connection.setRequestProperty("x-date", xdate);
                connection.setRequestProperty("Accept-Encoding", "gzip");
                connection.setDoInput(true);//允許連線時收資料
                //connection.setDoOutput(true);//允許連線時送資料

                //回傳狀態
                respond = connection.getResponseCode() + " " + connection.getResponseMessage();
                System.out.println("回傳狀態:" + respond);
                BufferedReader in;

                // 判斷來源是否為gzip
                //一種HTTP壓縮演算法，Web伺服器和瀏覽器間傳輸壓縮內容的方法
                //取得資料流後存起來
                if ("gzip".equals(connection.getContentEncoding())) {
                    InputStreamReader reader = new InputStreamReader(new GZIPInputStream(connection.getInputStream()));
                    in = new BufferedReader(reader);
                } else {
                    InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                    in = new BufferedReader(reader);
                }

                // 返回的數據已經過解壓
                StringBuffer buffer = new StringBuffer();
                // 讀取回傳資料
                String line, response = "";
                while ((line = in.readLine()) != null) {
                    response += (line + "\n");
                }
                return response;

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        // 取得當下UTC時間
        public static String getServerTime() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return dateFormat.format(calendar.getTime());
        }


        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.isEmpty()) {
                callback.onFailure("can't receive data");
            } else {
                callback.onSuccess(s);
            }
            callback = null;
        }
    }

    //網路請求Callback
    private interface RequestCallback {
        void onSuccess(String json);

        void onFailure(String errorMessage);
    }
}
