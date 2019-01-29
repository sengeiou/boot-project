package com.xzm;
import com.xzm.tyb.utils.IdUtils;
import com.xzm.tyb.utils.Identity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class Test {
    private static int msgCount = 0; //消息发送次数
    private static Timer mTimer;

    public static void main(String[] args) {
//        String flower = "朵玫瑰";
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + flower);
//        }
        String uuid = IdUtils.uuid();
//        identit
        String s = UUID.randomUUID().toString();
        System.out.println(s);
    }


    private static void printFlower() {
        String flower = "朵玫瑰";
        for (int i = 0; i < 100; i++) {
            System.out.println(i + flower);
        }
    }

    public static int getRandomNum(int smallistNum, int BiggestNum) {
        Random random = new Random();
        return (Math.abs(random.nextInt()) % (BiggestNum - smallistNum + 1)) + smallistNum;
    }

    //每秒发送一条消息
    private static void startTask() {
        mTimer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int num = getRandomNum(-1, 2);
                System.out.println("====" + num);
            }
        };
        mTimer.schedule(timerTask, 0, 1000);
    }
}
