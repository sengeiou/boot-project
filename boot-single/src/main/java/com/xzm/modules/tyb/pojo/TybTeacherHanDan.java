package com.xzm.tyb.pojo;

import java.util.Date;

public class TybTeacherHanDan {
    private Integer id;

    private Date kcTime;

    private String leiXing;

    private Integer cangWei;

    private String cangWeiType;

    private String pingZhong;

    private Float kaiCangJia;

    private Float zhiSunJia;

    private Float zhiYinJia;

    private String remark;

    private Integer kaiCangCeLv;

    private String type;

    private Float roomId;

    private Integer status;

    private Integer teacherId;

    private Date pingCangTime;

    private String pingCangJia;

    private Float hlDian;

    private Float profit;

    private Date createTime;

    private Date updataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getKcTime() {
        return kcTime;
    }

    public void setKcTime(Date kcTime) {
        this.kcTime = kcTime;
    }

    public String getLeiXing() {
        return leiXing;
    }

    public void setLeiXing(String leiXing) {
        this.leiXing = leiXing == null ? null : leiXing.trim();
    }

    public Integer getCangWei() {
        return cangWei;
    }

    public void setCangWei(Integer cangWei) {
        this.cangWei = cangWei;
    }

    public String getCangWeiType() {
        return cangWeiType;
    }

    public void setCangWeiType(String cangWeiType) {
        this.cangWeiType = cangWeiType == null ? null : cangWeiType.trim();
    }

    public String getPingZhong() {
        return pingZhong;
    }

    public void setPingZhong(String pingZhong) {
        this.pingZhong = pingZhong == null ? null : pingZhong.trim();
    }

    public Float getKaiCangJia() {
        return kaiCangJia;
    }

    public void setKaiCangJia(Float kaiCangJia) {
        this.kaiCangJia = kaiCangJia;
    }

    public Float getZhiSunJia() {
        return zhiSunJia;
    }

    public void setZhiSunJia(Float zhiSunJia) {
        this.zhiSunJia = zhiSunJia;
    }

    public Float getZhiYinJia() {
        return zhiYinJia;
    }

    public void setZhiYinJia(Float zhiYinJia) {
        this.zhiYinJia = zhiYinJia;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getKaiCangCeLv() {
        return kaiCangCeLv;
    }

    public void setKaiCangCeLv(Integer kaiCangCeLv) {
        this.kaiCangCeLv = kaiCangCeLv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Float getRoomId() {
        return roomId;
    }

    public void setRoomId(Float roomId) {
        this.roomId = roomId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getPingCangTime() {
        return pingCangTime;
    }

    public void setPingCangTime(Date pingCangTime) {
        this.pingCangTime = pingCangTime;
    }

    public String getPingCangJia() {
        return pingCangJia;
    }

    public void setPingCangJia(String pingCangJia) {
        this.pingCangJia = pingCangJia == null ? null : pingCangJia.trim();
    }

    public Float getHlDian() {
        return hlDian;
    }

    public void setHlDian(Float hlDian) {
        this.hlDian = hlDian;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
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