package com.xzm.modules.test.pojo;


/**
 * Created by xuzongmeng on 2017/8/15.
 *
 */

public class TestUser {
    private  String name;
    private String  sex;

    public TestUser(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public TestUser() {
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
