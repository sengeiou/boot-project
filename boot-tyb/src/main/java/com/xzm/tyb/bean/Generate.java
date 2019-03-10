package com.xzm.tyb.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User:frankwoo(吴峻申) <br>
 * Date:2017/8/24 <br>
 * Time:上午1:13 <br>
 * Mail:frank_wjs@hotmail.com <br>
 */
@ConfigurationProperties(prefix = "generate")
public class Generate {

  public String getWorker() {
    return worker;
  }

  public void setWorker(String worker) {
    this.worker = worker;
  }

  private String worker;
}
