package com.xzm.tyb.pojo;

import java.util.Date;

public class TybTeacher {
    private Integer id;

    private String thumb;

    private String teacherName;

    private Integer dianZanCount;

    private Float hdcgl;

    private Float profit;

    private String genDanCount;

    private String pinZhong;

    private Float cangWei;

    private Float dianWei;

    private Float shouYi;

    private String content;

    private Date createTime;

    private Date updataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Integer getDianZanCount() {
        return dianZanCount;
    }

    public void setDianZanCount(Integer dianZanCount) {
        this.dianZanCount = dianZanCount;
    }

    public Float getHdcgl() {
        return hdcgl;
    }

    public void setHdcgl(Float hdcgl) {
        this.hdcgl = hdcgl;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public String getGenDanCount() {
        return genDanCount;
    }

    public void setGenDanCount(String genDanCount) {
        this.genDanCount = genDanCount == null ? null : genDanCount.trim();
    }

    public String getPinZhong() {
        return pinZhong;
    }

    public void setPinZhong(String pinZhong) {
        this.pinZhong = pinZhong == null ? null : pinZhong.trim();
    }

    public Float getCangWei() {
        return cangWei;
    }

    public void setCangWei(Float cangWei) {
        this.cangWei = cangWei;
    }

    public Float getDianWei() {
        return dianWei;
    }

    public void setDianWei(Float dianWei) {
        this.dianWei = dianWei;
    }

    public Float getShouYi() {
        return shouYi;
    }

    public void setShouYi(Float shouYi) {
        this.shouYi = shouYi;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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