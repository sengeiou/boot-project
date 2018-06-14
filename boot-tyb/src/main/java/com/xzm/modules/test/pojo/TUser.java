package com.xzm.modules.test.pojo;

import java.io.Serializable;

/**
 * @author 
 */
public class TUser implements Serializable {
    /**
     * 编号
     */
    private Integer t_id;

    /**
     * 名称
     */
    private String t_name;

    /**
     * 年龄
     */
    private Integer t_age;

    /**
     * 家庭住址
     */
    private String t_address;

    /**
     * 密码
     */
    private String t_pwd;

    private static final long serialVersionUID = 1L;

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Integer getT_age() {
        return t_age;
    }

    public void setT_age(Integer t_age) {
        this.t_age = t_age;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_pwd() {
        return t_pwd;
    }

    public void setT_pwd(String t_pwd) {
        this.t_pwd = t_pwd;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TUser other = (TUser) that;
        return (this.getT_id() == null ? other.getT_id() == null : this.getT_id().equals(other.getT_id()))
            && (this.getT_name() == null ? other.getT_name() == null : this.getT_name().equals(other.getT_name()))
            && (this.getT_age() == null ? other.getT_age() == null : this.getT_age().equals(other.getT_age()))
            && (this.getT_address() == null ? other.getT_address() == null : this.getT_address().equals(other.getT_address()))
            && (this.getT_pwd() == null ? other.getT_pwd() == null : this.getT_pwd().equals(other.getT_pwd()));
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getT_id() == null) ? 0 : getT_id().hashCode());
//        result = prime * result + ((getT_name() == null) ? 0 : getT_name().hashCode());
//        result = prime * result + ((getT_age() == null) ? 0 : getT_age().hashCode());
//        result = prime * result + ((getT_address() == null) ? 0 : getT_address().hashCode());
//        result = prime * result + ((getT_pwd() == null) ? 0 : getT_pwd().hashCode());
//        return result;
//    }


    @Override
    public int hashCode() {
        int result = t_id != null ? t_id.hashCode() : 0;
        result = 31 * result + (t_name != null ? t_name.hashCode() : 0);
        result = 31 * result + (t_age != null ? t_age.hashCode() : 0);
        result = 31 * result + (t_address != null ? t_address.hashCode() : 0);
        result = 31 * result + (t_pwd != null ? t_pwd.hashCode() : 0);
        return result;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", t_id=").append(t_id);
//        sb.append(", t_name=").append(t_name);
//        sb.append(", t_age=").append(t_age);
//        sb.append(", t_address=").append(t_address);
//        sb.append(", t_pwd=").append(t_pwd);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}