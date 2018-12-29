package com.springmvc.quartz;

import com.springmvc.imp.MyTimerService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xuzongmeng on 2017/7/13.
 */
@Component  //import org.springframework.stereotype.Component;
@EnableScheduling
public class MyTimer implements MyTimerService {
    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    @Override
    public void runTime() {
        System.out.println("进入测试");
    }
}
