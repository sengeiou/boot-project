package com.xzm.modules.tyb.task;
import com.xzm.common.utils.JSONUtils;
import com.xzm.tyb.bean.HangQing;
import com.xzm.tyb.websocket.SocketServer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * 模拟webSocket 定时推送
 */
@Component
public class WebSocketTask {


    /**
     * 每小时的10分执行该方法
     */
    //@Scheduled(cron = "0 10 * * * *")
    public void cron() throws Exception {
        System.out.println("执行测试cron时间：" + new Date(System.currentTimeMillis()));
    }


    /**
     * 是上一个调用开始后再次调用的延时（不用等待上一次调用完成）
     */
    //@Scheduled(fixedRate = 1000 * 1)
    public void fixedRate() throws Exception {
        Thread.sleep(2000);
        System.out.println("执行测试fixedRate时间：" + new Date(System.currentTimeMillis()));
    }

    /**
     * 上一个调用完成后再次调用的延时调用
     */
    //@Scheduled(fixedDelay = 1000 * 1)
    public void fixedDelay() throws Exception {
        Thread.sleep(3000);
        System.out.println("执行测试fixedDelay时间：" + new Date(System.currentTimeMillis()));
    }

    /**
     * 第一次被调用前的延时，单位毫秒
     */
    @Scheduled(initialDelay = 1000 * 10, fixedDelay = 1000 * 5)
    public void initialDelay() throws Exception {
        int randomNum = getRandomNum(-2, 2);
        int randomLast = getRandomNum(120, 135);
        int randomSwingRate = getRandomNum(30, 40);
        HangQing hangQing = new HangQing();
        hangQing.setLast(String.valueOf(randomLast));
        hangQing.setSwing(String.valueOf(randomNum));
        hangQing.setSwingRate(String.valueOf(randomSwingRate));
        hangQing.setHigh("12");
        hangQing.setLow("118.5");
        hangQing.setOpen("125.4");
        hangQing.setLastClose("120.5");
        hangQing.setVolume("12");
        hangQing.setQuoteTime("212");
        int numCode = getRandomNum(1, 3);
        if (numCode == 1) {
            hangQing.setCode("XHY");
            hangQing.setName("现货油");
        } else if (numCode == 2) {
            hangQing.setCode("XHT");
            hangQing.setName("现货铜");
        } else if (numCode == 3) {
            hangQing.setCode("CJY");
            hangQing.setName("长江油");
        }
        String json = JSONUtils.beanToJson(hangQing);
        SocketServer.sendAll(json);
//        System.out.println("执行测试initialDelay时间："+ new Date(System.currentTimeMillis()));
    }

    public static int getRandomNum(int smallistNum, int BiggestNum) {
        Random random = new Random();
        return (Math.abs(random.nextInt()) % (BiggestNum - smallistNum + 1)) + smallistNum;
    }
}
