package com.example.bus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


//用資料
public class RouteDataSource {
    //預載資料
    private String JSON = "[\n" +
            "  {\n" +
            "    \"RouteUID\": \"TPE10232\",\n" +
            "    \"RouteID\": \"10232\",\n" +
            "    \"HasSubRoutes\": true,\n" +
            "    \"Operators\": [\n" +
            "      {\n" +
            "        \"OperatorID\": \"200\",\n" +
            "        \"OperatorName\": {\n" +
            "          \"Zh_tw\": \"首都客運\",\n" +
            "          \"En\": \"Capital Bus Co., Ltd.\"\n" +
            "        },\n" +
            "        \"OperatorCode\": \"CapitalBus\",\n" +
            "        \"OperatorNo\": \"0913\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"AuthorityID\": \"004\",\n" +
            "    \"ProviderID\": \"045\",\n" +
            "    \"SubRoutes\": [\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE102320\",\n" +
            "        \"SubRouteID\": \"102320\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"200\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅25\",\n" +
            "          \"En\": \"R25\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0550\",\n" +
            "        \"LastBusTime\": \"2200\",\n" +
            "        \"HolidayFirstBusTime\": \"0700\",\n" +
            "        \"HolidayLastBusTime\": \"2130\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE102320\",\n" +
            "        \"SubRouteID\": \"102320\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"200\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅25\",\n" +
            "          \"En\": \"R25\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0550\",\n" +
            "        \"LastBusTime\": \"2200\",\n" +
            "        \"HolidayFirstBusTime\": \"0700\",\n" +
            "        \"HolidayLastBusTime\": \"2130\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"BusRouteType\": 11,\n" +
            "    \"RouteName\": {\n" +
            "      \"Zh_tw\": \"紅25\",\n" +
            "      \"En\": \"R25\"\n" +
            "    },\n" +
            "    \"DepartureStopNameZh\": \"南港\",\n" +
            "    \"DepartureStopNameEn\": \"Nangang\",\n" +
            "    \"DestinationStopNameZh\": \"捷運北門站\",\n" +
            "    \"DestinationStopNameEn\": \"MRT Beimen Sta.\",\n" +
            "    \"TicketPriceDescriptionZh\": \"一段票\",\n" +
            "    \"TicketPriceDescriptionEn\": \"1 segment\",\n" +
            "    \"FareBufferZoneDescriptionZh\": \"\",\n" +
            "    \"FareBufferZoneDescriptionEn\": \"\",\n" +
            "    \"RouteMapImageUrl\": \"https://ebus.gov.taipei/MapOverview?nid=0111002500\",\n" +
            "    \"City\": \"Taipei\",\n" +
            "    \"CityCode\": \"TPE\",\n" +
            "    \"UpdateTime\": \"2021-08-18T04:24:28+08:00\",\n" +
            "    \"VersionID\": 1203\n" +
            "  },\n" +
            "  {\n" +
            "    \"RouteUID\": \"TPE10261\",\n" +
            "    \"RouteID\": \"10261\",\n" +
            "    \"HasSubRoutes\": true,\n" +
            "    \"Operators\": [\n" +
            "      {\n" +
            "        \"OperatorID\": \"200\",\n" +
            "        \"OperatorName\": {\n" +
            "          \"Zh_tw\": \"首都客運\",\n" +
            "          \"En\": \"Capital Bus Co., Ltd.\"\n" +
            "        },\n" +
            "        \"OperatorCode\": \"CapitalBus\",\n" +
            "        \"OperatorNo\": \"0913\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"AuthorityID\": \"004\",\n" +
            "    \"ProviderID\": \"045\",\n" +
            "    \"SubRoutes\": [\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10261\",\n" +
            "        \"SubRouteID\": \"10261\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"200\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅33\",\n" +
            "          \"En\": \"R33\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0900\",\n" +
            "        \"LastBusTime\": \"1900\",\n" +
            "        \"HolidayFirstBusTime\": \"0900\",\n" +
            "        \"HolidayLastBusTime\": \"1900\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10261\",\n" +
            "        \"SubRouteID\": \"10261\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"200\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅33\",\n" +
            "          \"En\": \"R33\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0900\",\n" +
            "        \"LastBusTime\": \"1900\",\n" +
            "        \"HolidayFirstBusTime\": \"0900\",\n" +
            "        \"HolidayLastBusTime\": \"1900\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"BusRouteType\": 11,\n" +
            "    \"RouteName\": {\n" +
            "      \"Zh_tw\": \"紅33\",\n" +
            "      \"En\": \"R33\"\n" +
            "    },\n" +
            "    \"DepartureStopNameZh\": \"葫蘆里\",\n" +
            "    \"DepartureStopNameEn\": \"Hulu Li\",\n" +
            "    \"DestinationStopNameZh\": \"聯合醫院中興院區(西寧)\",\n" +
            "    \"DestinationStopNameEn\": \"Tpe Hospital Zhongxin Branch(Xining)\",\n" +
            "    \"TicketPriceDescriptionZh\": \"一段票\",\n" +
            "    \"TicketPriceDescriptionEn\": \"1 segment\",\n" +
            "    \"FareBufferZoneDescriptionZh\": \"\",\n" +
            "    \"FareBufferZoneDescriptionEn\": \"\",\n" +
            "    \"RouteMapImageUrl\": \"https://ebus.gov.taipei/MapOverview?nid=0111003300\",\n" +
            "    \"City\": \"Taipei\",\n" +
            "    \"CityCode\": \"TPE\",\n" +
            "    \"UpdateTime\": \"2021-08-18T04:24:28+08:00\",\n" +
            "    \"VersionID\": 1203\n" +
            "  },\n" +
            "  {\n" +
            "    \"RouteUID\": \"TPE10421\",\n" +
            "    \"RouteID\": \"10421\",\n" +
            "    \"HasSubRoutes\": true,\n" +
            "    \"Operators\": [\n" +
            "      {\n" +
            "        \"OperatorID\": \"400\",\n" +
            "        \"OperatorName\": {\n" +
            "          \"Zh_tw\": \"三重客運\",\n" +
            "          \"En\": \"San Chung Bus Co., Ltd.\"\n" +
            "        },\n" +
            "        \"OperatorCode\": \"SanChungBus\",\n" +
            "        \"OperatorNo\": \"0301\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"AuthorityID\": \"004\",\n" +
            "    \"ProviderID\": \"045\",\n" +
            "    \"SubRoutes\": [\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10421\",\n" +
            "        \"SubRouteID\": \"10421\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"400\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅9\",\n" +
            "          \"En\": \"R9\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0540\",\n" +
            "        \"LastBusTime\": \"0000\",\n" +
            "        \"HolidayFirstBusTime\": \"0600\",\n" +
            "        \"HolidayLastBusTime\": \"0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10421\",\n" +
            "        \"SubRouteID\": \"10421\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"400\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅9\",\n" +
            "          \"En\": \"R9\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0540\",\n" +
            "        \"LastBusTime\": \"0000\",\n" +
            "        \"HolidayFirstBusTime\": \"0600\",\n" +
            "        \"HolidayLastBusTime\": \"0000\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"BusRouteType\": 11,\n" +
            "    \"RouteName\": {\n" +
            "      \"Zh_tw\": \"紅9\",\n" +
            "      \"En\": \"R9\"\n" +
            "    },\n" +
            "    \"DepartureStopNameZh\": \"蘆洲\",\n" +
            "    \"DepartureStopNameEn\": \"Luzhou\",\n" +
            "    \"DestinationStopNameZh\": \"捷運劍潭站\",\n" +
            "    \"DestinationStopNameEn\": \"MRT Jiantan Sta.\",\n" +
            "    \"TicketPriceDescriptionZh\": \"一段票\",\n" +
            "    \"TicketPriceDescriptionEn\": \"1 segment\",\n" +
            "    \"FareBufferZoneDescriptionZh\": \"\",\n" +
            "    \"FareBufferZoneDescriptionEn\": \"\",\n" +
            "    \"RouteMapImageUrl\": \"https://ebus.gov.taipei/MapOverview?nid=0111000900\",\n" +
            "    \"City\": \"Taipei\",\n" +
            "    \"CityCode\": \"TPE\",\n" +
            "    \"UpdateTime\": \"2021-08-18T04:24:28+08:00\",\n" +
            "    \"VersionID\": 1203\n" +
            "  },\n" +
            "  {\n" +
            "    \"RouteUID\": \"TPE10431\",\n" +
            "    \"RouteID\": \"10431\",\n" +
            "    \"HasSubRoutes\": true,\n" +
            "    \"Operators\": [\n" +
            "      {\n" +
            "        \"OperatorID\": \"400\",\n" +
            "        \"OperatorName\": {\n" +
            "          \"Zh_tw\": \"三重客運\",\n" +
            "          \"En\": \"San Chung Bus Co., Ltd.\"\n" +
            "        },\n" +
            "        \"OperatorCode\": \"SanChungBus\",\n" +
            "        \"OperatorNo\": \"0301\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"AuthorityID\": \"004\",\n" +
            "    \"ProviderID\": \"045\",\n" +
            "    \"SubRoutes\": [\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10431\",\n" +
            "        \"SubRouteID\": \"10431\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"400\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅31\",\n" +
            "          \"En\": \"R31\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0600\",\n" +
            "        \"LastBusTime\": \"0000\",\n" +
            "        \"HolidayFirstBusTime\": \"0600\",\n" +
            "        \"HolidayLastBusTime\": \"0000\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10431\",\n" +
            "        \"SubRouteID\": \"10431\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"400\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅31\",\n" +
            "          \"En\": \"R31\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0600\",\n" +
            "        \"LastBusTime\": \"0000\",\n" +
            "        \"HolidayFirstBusTime\": \"0600\",\n" +
            "        \"HolidayLastBusTime\": \"0000\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"BusRouteType\": 11,\n" +
            "    \"RouteName\": {\n" +
            "      \"Zh_tw\": \"紅31\",\n" +
            "      \"En\": \"R31\"\n" +
            "    },\n" +
            "    \"DepartureStopNameZh\": \"捷運大湖公園站\",\n" +
            "    \"DepartureStopNameEn\": \"MRT Dahu Park\",\n" +
            "    \"DestinationStopNameZh\": \"捷運民權西路站\",\n" +
            "    \"DestinationStopNameEn\": \"MRT Minquan W. Rd. Sta.\",\n" +
            "    \"TicketPriceDescriptionZh\": \"一段票\",\n" +
            "    \"TicketPriceDescriptionEn\": \"1 segment\",\n" +
            "    \"FareBufferZoneDescriptionZh\": \"\",\n" +
            "    \"FareBufferZoneDescriptionEn\": \"\",\n" +
            "    \"RouteMapImageUrl\": \"https://ebus.gov.taipei/MapOverview?nid=0111003100\",\n" +
            "    \"City\": \"Taipei\",\n" +
            "    \"CityCode\": \"TPE\",\n" +
            "    \"UpdateTime\": \"2021-08-18T04:24:28+08:00\",\n" +
            "    \"VersionID\": 1203\n" +
            "  },\n" +
            "  {\n" +
            "    \"RouteUID\": \"TPE10821\",\n" +
            "    \"RouteID\": \"10821\",\n" +
            "    \"HasSubRoutes\": true,\n" +
            "    \"Operators\": [\n" +
            "      {\n" +
            "        \"OperatorID\": \"800\",\n" +
            "        \"OperatorName\": {\n" +
            "          \"Zh_tw\": \"大都會客運\",\n" +
            "          \"En\": \"Metropolitan Bus Co., Ltd.\"\n" +
            "        },\n" +
            "        \"OperatorCode\": \"MetropolitanBus\",\n" +
            "        \"OperatorNo\": \"0303\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"AuthorityID\": \"004\",\n" +
            "    \"ProviderID\": \"045\",\n" +
            "    \"SubRoutes\": [\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10821\",\n" +
            "        \"SubRouteID\": \"10821\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"800\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅5\",\n" +
            "          \"En\": \"R5\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0530\",\n" +
            "        \"LastBusTime\": \"0040\",\n" +
            "        \"HolidayFirstBusTime\": \"0530\",\n" +
            "        \"HolidayLastBusTime\": \"0040\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE10821\",\n" +
            "        \"SubRouteID\": \"10821\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"800\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅5\",\n" +
            "          \"En\": \"R5\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0530\",\n" +
            "        \"LastBusTime\": \"0040\",\n" +
            "        \"HolidayFirstBusTime\": \"0530\",\n" +
            "        \"HolidayLastBusTime\": \"0040\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE157609\",\n" +
            "        \"SubRouteID\": \"157609\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"800\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅5往劍潭經文大\",\n" +
            "          \"En\": \"R5\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0530\",\n" +
            "        \"LastBusTime\": \"0040\",\n" +
            "        \"HolidayFirstBusTime\": \"0530\",\n" +
            "        \"HolidayLastBusTime\": \"0040\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE157610\",\n" +
            "        \"SubRouteID\": \"157610\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"800\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅5往陽明山經文大\",\n" +
            "          \"En\": \"R5\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0530\",\n" +
            "        \"LastBusTime\": \"0040\",\n" +
            "        \"HolidayFirstBusTime\": \"0530\",\n" +
            "        \"HolidayLastBusTime\": \"0040\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE158419\",\n" +
            "        \"SubRouteID\": \"158419\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"800\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅5往陽明山\",\n" +
            "          \"En\": \"R5\"\n" +
            "        },\n" +
            "        \"Direction\": 0,\n" +
            "        \"FirstBusTime\": \"0530\",\n" +
            "        \"LastBusTime\": \"0040\",\n" +
            "        \"HolidayFirstBusTime\": \"0530\",\n" +
            "        \"HolidayLastBusTime\": \"0040\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"SubRouteUID\": \"TPE158420\",\n" +
            "        \"SubRouteID\": \"158420\",\n" +
            "        \"OperatorIDs\": [\n" +
            "          \"800\"\n" +
            "        ],\n" +
            "        \"SubRouteName\": {\n" +
            "          \"Zh_tw\": \"紅5往劍潭\",\n" +
            "          \"En\": \"R5\"\n" +
            "        },\n" +
            "        \"Direction\": 1,\n" +
            "        \"FirstBusTime\": \"0530\",\n" +
            "        \"LastBusTime\": \"0040\",\n" +
            "        \"HolidayFirstBusTime\": \"0530\",\n" +
            "        \"HolidayLastBusTime\": \"0040\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"BusRouteType\": 11,\n" +
            "    \"RouteName\": {\n" +
            "      \"Zh_tw\": \"紅5\",\n" +
            "      \"En\": \"R5\"\n" +
            "    },\n" +
            "    \"DepartureStopNameZh\": \"捷運劍潭站\",\n" +
            "    \"DepartureStopNameEn\": \"MRT Jiantan Sta.\",\n" +
            "    \"DestinationStopNameZh\": \"陽明山\",\n" +
            "    \"DestinationStopNameEn\": \"Yangmingshan\",\n" +
            "    \"TicketPriceDescriptionZh\": \"一段票\",\n" +
            "    \"TicketPriceDescriptionEn\": \"1 segment\",\n" +
            "    \"FareBufferZoneDescriptionZh\": \"\",\n" +
            "    \"FareBufferZoneDescriptionEn\": \"\",\n" +
            "    \"RouteMapImageUrl\": \"https://ebus.gov.taipei/MapOverview?nid=0111000500\",\n" +
            "    \"City\": \"Taipei\",\n" +
            "    \"CityCode\": \"TPE\",\n" +
            "    \"UpdateTime\": \"2021-08-18T04:24:28+08:00\",\n" +
            "    \"VersionID\": 1203\n" +
            "  }]";

    private List<RouteEntity> routeEntityList;

    public RouteDataSource() {
        Gson gson = new Gson();
        Type routeEntityTypeToken = TypeToken.getParameterized(List.class, RouteEntity.class).getType();
        routeEntityList = gson.fromJson(JSON, routeEntityTypeToken);
    }

    public List<RouteEntity> getRouteEntityList() {
        return routeEntityList;
    }
}
