package com.xzm.modules.tyb.bean;

/**
 * 行情推送数据
 * Created by xzm on 2018/5/9.
 */

public class HangQing {

    /**
     * code : CJAG4
     * name : 长江银
     * last : 4213.00
     * high : 4342.00
     * low : 4191.00
     * open : 4311.00
     * lastClose : 4307.00
     * volume : 1.00
     * quoteTime : 2016-7-5 9:42:14
     * swing : -94.00
     * swingRate : -2.18%
     */

    private String code;
    private String name;
    private String last;
    private String high;
    private String low;
    private String open;
    private String lastClose;
    private String volume;
    private String quoteTime;
    private String swing;
    private String swingRate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getLastClose() {
        return lastClose;
    }

    public void setLastClose(String lastClose) {
        this.lastClose = lastClose;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(String quoteTime) {
        this.quoteTime = quoteTime;
    }

    public String getSwing() {
        return swing;
    }

    public void setSwing(String swing) {
        this.swing = swing;
    }

    public String getSwingRate() {
        return swingRate;
    }

    public void setSwingRate(String swingRate) {
        this.swingRate = swingRate;
    }

    @Override
    public String toString() {
        return "HangQing{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", last='" + last + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", open='" + open + '\'' +
                ", lastClose='" + lastClose + '\'' +
                ", volume='" + volume + '\'' +
                ", quoteTime='" + quoteTime + '\'' +
                ", swing='" + swing + '\'' +
                ", swingRate='" + swingRate + '\'' +
                '}';
    }
}
