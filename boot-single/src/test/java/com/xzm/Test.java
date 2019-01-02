//package com.xzm;
//
//import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class Test {
//    private static int msgCount = 0; //消息发送次数
//    private static Timer mTimer;
//    public static void main(String[] args) {
//        // 获得一个给定范围的随机整数
////        int num = getRandomNum(-1, 2);
////        System.out.println("====" + num);、
//        startTask();
//    }
//    public static int getRandomNum(int smallistNum, int BiggestNum) {
//        Random random = new Random();
//        return (Math.abs(random.nextInt()) % (BiggestNum - smallistNum + 1))+ smallistNum;
//    }
//
//    //每秒发送一条消息
//    private static void startTask() {
//        mTimer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                int num = getRandomNum(-1, 2);
//                System.out.println("====" + num);
//            }
//        };
//        mTimer.schedule(timerTask, 0, 1000);
//    }
//}
