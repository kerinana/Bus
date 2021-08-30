package com.example.bus;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

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
        requestRouteDataByRouteName("Taipei", routeName, new RequestCallback() {
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
        requestRouteTimeDataByRouteID("Taipei", routeID, new RequestCallback() {
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
    public void getRouteSequenDataById(String routeId, DataCallback<List<RouteData>> callback) {
        requestRouteSequenDataByRouteID("Taipei", routeId, new RequestCallback() {
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

    //去網路抓資料，以routeid為搜尋的，抓時間
    private void requestRouteTimeDataByRouteID(String city, String routeID, RequestCallback callback) {
        String filter = "RouteID eq " + "'" + routeID + "'";
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


    /****Network Request*****/

    private void request(String apiUrl, RequestCallback callback) {
        RequestAsyncTask task = new RequestAsyncTask(apiUrl, callback);
        task.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private static class RequestAsyncTask extends AsyncTask<String, Void, String> {

        private  RequestCallback callback;
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
            if(s.isEmpty()){
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
