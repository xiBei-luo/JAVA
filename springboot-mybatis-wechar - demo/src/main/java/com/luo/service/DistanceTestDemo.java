package com.luo.service;


import javafx.geometry.Point2D;

public class DistanceTestDemo {
    public static void main(String[] args) {
        // 北京 东单地铁站
        Point2D pointDD = new Point2D(116.425249, 39.914504);
        // 北京 西单地铁站
        Point2D pointXD = new Point2D(116.382001, 39.913329);
        System.out.println(getDistance(pointDD, pointXD)+"米");
        System.out.println();

        // 北京 天安门
        Point2D pointTAM = new Point2D(116.403882, 39.915139);
        // 广州 越秀公园
        Point2D pointGZ = new Point2D(113.272422, 23.147387);
        System.out.println(getDistance(pointTAM, pointGZ)+"米");
        System.out.println();

        // 四川大学
        Point2D pointSCDX = new Point2D(104.090539, 30.636951);
        // 成都南站
        Point2D pointCDNZ = new Point2D(104.074238, 30.612572);


        System.out.println(getDistance(pointSCDX, pointCDNZ)+"米");
        System.out.println();
    }


    private static final double EARTH_RADIUS = 6371393; // 平均半径,单位：m

    /**
     * 通过AB点经纬度获取距离
     * @param pointA A点(经，纬)
     * @param pointB B点(经，纬)
     * @return 距离(单位：米)
     */
    public static double getDistance(Point2D pointA, Point2D pointB) {
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        double radiansAX = Math.toRadians(pointA.getX()); // A经弧度
        double radiansAY = Math.toRadians(pointA.getY()); // A纬弧度
        double radiansBX = Math.toRadians(pointB.getX()); // B经弧度
        double radiansBY = Math.toRadians(pointB.getY()); // B纬弧度

        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
//        System.out.println("cos = " + cos); // 值域[-1,1]
        double acos = Math.acos(cos); // 反余弦值
//        System.out.println("acos = " + acos); // 值域[0,π]
//        System.out.println("∠AOB = " + Math.toDegrees(acos)); // 球心角 值域[0,180]
        return EARTH_RADIUS * acos; // 最终结果
    }
}
