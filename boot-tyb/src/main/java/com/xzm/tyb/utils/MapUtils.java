package com.xzm.tyb.utils;

/**
 * author : xuzongmeng
 * date   : 2018/9/13
 * desc   :
 */
public class MapUtils {

    //private static double EARTH_RADIUS = 6378.137;
    private static double EARTH_RADIUS = 6371.393;
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    /**
     * 计算两个经纬度之间的距离

     */
    public static double GetDistance(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 1000);
        return s;
    }



    public static void main(String[] args) {
//        System.out.println(MapUtils.GetDistance(29.490295,106.486654,29.615467,106.581515));

        System.out.println(MapUtils.GetDistance(31.227681,121.523372,39.915156,116.407431));
    }

}
