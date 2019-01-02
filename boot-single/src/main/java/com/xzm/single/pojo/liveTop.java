package com.xzm.single.pojo;

import java.util.Date;

public class liveTop {
    private Integer id;

    private String title;

    private String liveUrl;

    private Integer dianZanCount;

    private String adText;

    private String adUrl;

    private Integer onlineCount;

    private Float handanRate;

    private Float yingLi;

    private String mainImg;

    private String subImg;

    private Date createTime;

    private Date updataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl == null ? null : liveUrl.trim();
    }

    public Integer getDianZanCount() {
        return dianZanCount;
    }

    public void setDianZanCount(Integer dianZanCount) {
        this.dianZanCount = dianZanCount;
    }

    public String getAdText() {
        return adText;
    }

    public void setAdText(String adText) {
        this.adText = adText == null ? null : adText.trim();
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl == null ? null : adUrl.trim();
    }

    public Integer getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }

    public Float getHandanRate() {
        return handanRate;
    }

    public void setHandanRate(Float handanRate) {
        this.handanRate = handanRate;
    }

    public Float getYingLi() {
        return yingLi;
    }

    public void setYingLi(Float yingLi) {
        this.yingLi = yingLi;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg == null ? null : mainImg.trim();
    }

    public String getSubImg() {
        return subImg;
    }

    public void setSubImg(String subImg) {
        this.subImg = subImg == null ? null : subImg.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(Date updataTime) {
        this.updataTime = updataTime;
    }
}