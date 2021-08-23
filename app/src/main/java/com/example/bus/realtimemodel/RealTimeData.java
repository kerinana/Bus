package com.example.bus.realtimemodel;

import java.lang.reflect.Type;
import java.util.List;

import com.example.bus.model.RouteEntity;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class RealTimeData{


	String JSON="[{\"StopUID\":\"TPE196691\",\"StopID\":\"196691\",\"StopName\":{\"Zh_tw\":\"蘆洲區公所\",\"En\":\"Luzhou District Office\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1778,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE174178\",\"StopID\":\"174178\",\"StopName\":{\"Zh_tw\":\"民族路口\",\"En\":\"Minzu Rd. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2689,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE174179\",\"StopID\":\"174179\",\"StopName\":{\"Zh_tw\":\"捷運蘆洲站\",\"En\":\"MRT Luzhou Sta.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2769,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE174176\",\"StopID\":\"174176\",\"StopName\":{\"Zh_tw\":\"捷運蘆洲站\",\"En\":\"MRT  Luzhou Sta.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1193,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197889\",\"StopID\":\"197889\",\"StopName\":{\"Zh_tw\":\"中原公園\",\"En\":\"Zhongyuan Park\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":382,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197887\",\"StopID\":\"197887\",\"StopName\":{\"Zh_tw\":\"長榮光明路口\",\"En\":\"Changrong & Guangming Rd. Intersection\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":258,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197888\",\"StopID\":\"197888\",\"StopName\":{\"Zh_tw\":\"長榮中原路口\",\"En\":\"Changrong & Zhongyuan Rd. Intersection\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":308,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197881\",\"StopID\":\"197881\",\"StopName\":{\"Zh_tw\":\"長榮中原路口\",\"En\":\"Changrong & Zhongyuan Rd. Intersection\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":846,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197882\",\"StopID\":\"197882\",\"StopName\":{\"Zh_tw\":\"長榮光明路口\",\"En\":\"Changrong & Guangming Rd. Intersection\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":905,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197880\",\"StopID\":\"197880\",\"StopName\":{\"Zh_tw\":\"中原公園\",\"En\":\"Zhongyuan Park\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":782,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197885\",\"StopID\":\"197885\",\"StopName\":{\"Zh_tw\":\"長榮路\",\"En\":\"Changrong Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":121,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197886\",\"StopID\":\"197886\",\"StopName\":{\"Zh_tw\":\"永平市場\",\"En\":\"Yongping Market\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":180,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197883\",\"StopID\":\"197883\",\"StopName\":{\"Zh_tw\":\"永平市場\",\"En\":\"Yongping Market\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":981,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197884\",\"StopID\":\"197884\",\"StopName\":{\"Zh_tw\":\"長榮路\",\"En\":\"Changrong Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1046,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197892\",\"StopID\":\"197892\",\"StopName\":{\"Zh_tw\":\"蘆洲總站\",\"En\":\"Luzhou Bus Terminal\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":618,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197890\",\"StopID\":\"197890\",\"StopName\":{\"Zh_tw\":\"柳堤公園\",\"En\":\"Liudi Park\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":453,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197891\",\"StopID\":\"197891\",\"StopName\":{\"Zh_tw\":\"忠義國小\",\"En\":\"Zhongyi Elementary School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":498,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197878\",\"StopID\":\"197878\",\"StopName\":{\"Zh_tw\":\"忠義國小\",\"En\":\"Zhongyi Elementary School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":671,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197879\",\"StopID\":\"197879\",\"StopName\":{\"Zh_tw\":\"柳堤公園\",\"En\":\"Liudi Park\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":738,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE197877\",\"StopID\":\"197877\",\"StopName\":{\"Zh_tw\":\"蘆洲總站\",\"En\":\"Luzhou Bus Terminal\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":639,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10593\",\"StopID\":\"10593\",\"StopName\":{\"Zh_tw\":\"士林區行政中心(基河)\",\"En\":\"Shilin Admin. Center\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":641,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10595\",\"StopID\":\"10595\",\"StopName\":{\"Zh_tw\":\"公教住宅\",\"En\":\"Civil Service Housing\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":696,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10597\",\"StopID\":\"10597\",\"StopName\":{\"Zh_tw\":\"士林市場(銘傳會館)\",\"En\":\"Shilin Market (Ming Chuan Hostel)\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":750,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10599\",\"StopID\":\"10599\",\"StopName\":{\"Zh_tw\":\"捷運劍潭站(北藝中心)\",\"En\":\"MRT Jiantan Sta.(Taipei Performing Arts Center)\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":838,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10579\",\"StopID\":\"10579\",\"StopName\":{\"Zh_tw\":\"集賢路\",\"En\":\"Jixian Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":2173,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10571\",\"StopID\":\"10571\",\"StopName\":{\"Zh_tw\":\"鷺江國小(三民路)\",\"En\":\"Lujiang Elementary School(Sanmin Rd.)\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1809,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10573\",\"StopID\":\"10573\",\"StopName\":{\"Zh_tw\":\"溪墘\",\"En\":\"Xiqian\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1945,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10575\",\"StopID\":\"10575\",\"StopName\":{\"Zh_tw\":\"捷運徐匯中學站(集賢路)\",\"En\":\"MRT. St. Ignatius High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":2015,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10577\",\"StopID\":\"10577\",\"StopName\":{\"Zh_tw\":\"尼加拉瓜公園\",\"En\":\"Nicaragua Park\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":2119,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10581\",\"StopID\":\"10581\",\"StopName\":{\"Zh_tw\":\"五華街口\",\"En\":\"Wuhua St. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":2215,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10583\",\"StopID\":\"10583\",\"StopName\":{\"Zh_tw\":\"新北高中\",\"En\":\"New Taipei Senior High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":196,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10585\",\"StopID\":\"10585\",\"StopName\":{\"Zh_tw\":\"五華國小\",\"En\":\"Wuhua Elementary School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":274,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10587\",\"StopID\":\"10587\",\"StopName\":{\"Zh_tw\":\"重陽橋\",\"En\":\"Chongyang Bridge\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":418,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10589\",\"StopID\":\"10589\",\"StopName\":{\"Zh_tw\":\"陽明高中\",\"En\":\"Yangming High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":549,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10557\",\"StopID\":\"10557\",\"StopName\":{\"Zh_tw\":\"民族民義街口\",\"En\":\"Minzu and Minyi Intersection\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1477,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10559\",\"StopID\":\"10559\",\"StopName\":{\"Zh_tw\":\"水河里\",\"En\":\"Shueihe Village\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1531,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10553\",\"StopID\":\"10553\",\"StopName\":{\"Zh_tw\":\"仁愛國小\",\"En\":\"Renai Elementary School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1316,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10555\",\"StopID\":\"10555\",\"StopName\":{\"Zh_tw\":\"仁愛街口\",\"En\":\"Renai Rd. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1419,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10561\",\"StopID\":\"10561\",\"StopName\":{\"Zh_tw\":\"樓厝一\",\"En\":\"LouCuo 1\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1560,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10563\",\"StopID\":\"10563\",\"StopName\":{\"Zh_tw\":\"復興路\",\"En\":\"Fuxing Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1599,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10565\",\"StopID\":\"10565\",\"StopName\":{\"Zh_tw\":\"民權路口\",\"En\":\"Minquan Rd. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1674,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10567\",\"StopID\":\"10567\",\"StopName\":{\"Zh_tw\":\"捷運三民高中站(復興路)\",\"En\":\"MRT.SanMin High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":1733,\"StopStatus\":1,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10635\",\"StopID\":\"10635\",\"StopName\":{\"Zh_tw\":\"樓厝一\",\"En\":\"LouCuo 1\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2380,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10637\",\"StopID\":\"10637\",\"StopName\":{\"Zh_tw\":\"民族民義街口\",\"En\":\"Minzu and Minyi Intersection\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2437,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10639\",\"StopID\":\"10639\",\"StopName\":{\"Zh_tw\":\"仁愛街口\",\"En\":\"Renai Rd. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2516,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10631\",\"StopID\":\"10631\",\"StopName\":{\"Zh_tw\":\"民權路口\",\"En\":\"Minquan Rd. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2266,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10633\",\"StopID\":\"10633\",\"StopName\":{\"Zh_tw\":\"復興路\",\"En\":\"Fuxing Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2325,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10641\",\"StopID\":\"10641\",\"StopName\":{\"Zh_tw\":\"仁愛國小\",\"En\":\"Renai Elementary School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2596,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10609\",\"StopID\":\"10609\",\"StopName\":{\"Zh_tw\":\"五華國小\",\"En\":\"Wuhua Elementary School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1509,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10613\",\"StopID\":\"10613\",\"StopName\":{\"Zh_tw\":\"五華街口\",\"En\":\"Wuhua St. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1723,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10615\",\"StopID\":\"10615\",\"StopName\":{\"Zh_tw\":\"集賢路\",\"En\":\"Jixian Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1768,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10617\",\"StopID\":\"10617\",\"StopName\":{\"Zh_tw\":\"尼加拉瓜公園\",\"En\":\"Nicaragua Park\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1816,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10619\",\"StopID\":\"10619\",\"StopName\":{\"Zh_tw\":\"捷運徐匯中學站(集賢路)\",\"En\":\"MRT. St. Ignatius High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1871,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10611\",\"StopID\":\"10611\",\"StopName\":{\"Zh_tw\":\"新北高中\",\"En\":\"New Taipei Senior High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1575,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10623\",\"StopID\":\"10623\",\"StopName\":{\"Zh_tw\":\"溪墘\",\"En\":\"XiQian\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2021,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10625\",\"StopID\":\"10625\",\"StopName\":{\"Zh_tw\":\"鷺江國小(三民路)\",\"En\":\"Lujiang Elementary School(Sanmin Rd.)\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2091,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10627\",\"StopID\":\"10627\",\"StopName\":{\"Zh_tw\":\"捷運三民高中站\",\"En\":\"MRT Sanmin Senior High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2199,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10629\",\"StopID\":\"10629\",\"StopName\":{\"Zh_tw\":\"捷運三民高中站(復興路)\",\"En\":\"MRT. St. Ignatius High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":2207,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10621\",\"StopID\":\"10621\",\"StopName\":{\"Zh_tw\":\"民和公寓\",\"En\":\"Minhe Apartment\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1965,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10601\",\"StopID\":\"10601\",\"StopName\":{\"Zh_tw\":\"大南路口\",\"En\":\"Danan Rd. Entrance\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1053,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10603\",\"StopID\":\"10603\",\"StopName\":{\"Zh_tw\":\"士商路\",\"En\":\"Shishang Rd.\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1138,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10605\",\"StopID\":\"10605\",\"StopName\":{\"Zh_tw\":\"陽明高中\",\"En\":\"Yangming High School\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1205,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE10607\",\"StopID\":\"10607\",\"StopName\":{\"Zh_tw\":\"重陽橋\",\"En\":\"Chongyang Bridge\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1349,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE58916\",\"StopID\":\"58916\",\"StopName\":{\"Zh_tw\":\"分子尾\",\"En\":\"Fenziwei\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":1,\"EstimateTime\":1609,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE58915\",\"StopID\":\"58915\",\"StopName\":{\"Zh_tw\":\"分子尾\",\"En\":\"Fenziwei\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":75,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"},{\"StopUID\":\"TPE194323\",\"StopID\":\"194323\",\"StopName\":{\"Zh_tw\":\"士林區行政中心(中正)\",\"En\":\"Shilin Admin. Center\"},\"RouteUID\":\"TPE10421\",\"RouteID\":\"10421\",\"RouteName\":{\"Zh_tw\":\"紅9\",\"En\":\"R9\"},\"Direction\":0,\"EstimateTime\":612,\"StopStatus\":0,\"SrcUpdateTime\":\"2021-08-23T14:50:20+08:00\",\"UpdateTime\":\"2021-08-23T14:50:23+08:00\"}]";


	@SerializedName("RealTimeData")
	private List<RealTimeDataItem> realTimeDataList;

	//把資料轉成RealTimeDataItem格式
	public RealTimeData() {
		Gson gson = new Gson();
		Type realTimeDataTypeToken = TypeToken.getParameterized(List.class,RealTimeDataItem.class).getType();
		realTimeDataList = gson.fromJson(JSON, realTimeDataTypeToken);
	}

	public List<RealTimeDataItem> getRealTimeData(){
		return realTimeDataList;
	}

}