package com.xzm.tyb.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

//@Table(name = "sys_role")
public class TybImportantMessage implements Serializable {

    public TybImportantMessage(Integer id, Date time, String autoid, String prevalue, String day, String name, String importence, String question, String annvalue, String imageurl, Integer goodpers, Integer badpers, Date createTime, Date updataTime) {
        this.id = id;
        this.time = time;
        this.autoid = autoid;
        this.prevalue = prevalue;
        this.day = day;
        this.name = name;
        this.importence = importence;
        this.question = question;
        this.annvalue = annvalue;
        this.imageurl = imageurl;
        this.goodpers = goodpers;
        this.badpers = badpers;
        this.createTime = createTime;
        this.updataTime = updataTime;
    }

    public TybImportantMessage() {
    }

    public TybImportantMessage(Integer id) {
        this.id = id;
    }

    @Id
    private Integer id;

    private Date time;

    private String autoid;

    private String prevalue;

    private String day;

    private String name;

    private String importence;

    private String question;

    private String annvalue;

    private String imageurl;

    private Integer goodpers;

    private Integer badpers;

    private Date createTime;

    private Date updataTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAutoid() {
        return autoid;
    }

    public void setAutoid(String autoid) {
        this.autoid = autoid == null ? null : autoid.trim();
    }

    public String getPrevalue() {
        return prevalue;
    }

    public void setPrevalue(String prevalue) {
        this.prevalue = prevalue == null ? null : prevalue.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImportence() {
        return importence;
    }

    public void setImportence(String importence) {
        this.importence = importence == null ? null : importence.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnnvalue() {
        return annvalue;
    }

    public void setAnnvalue(String annvalue) {
        this.annvalue = annvalue == null ? null : annvalue.trim();
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Integer getGoodpers() {
        return goodpers;
    }

    public void setGoodpers(Integer goodpers) {
        this.goodpers = goodpers;
    }

    public Integer getBadpers() {
        return badpers;
    }

    public void setBadpers(Integer badpers) {
        this.badpers = badpers;
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