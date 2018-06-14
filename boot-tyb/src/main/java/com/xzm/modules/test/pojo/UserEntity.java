package com.xzm.modules.test.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/4
 * Time：15:38
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_user")
public class UserEntity extends BaseEntity implements Serializable
{

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_age")
    private int age;

    @Column(name = "t_address")
    private String address;

    @Column(name = "t_pwd")
    private String pwd;
}
