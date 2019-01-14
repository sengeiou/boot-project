package com.xzm.tyb.service;

//import com.baomidou.mybatisplus.service.IService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzm.tyb.form.TybUserForm;
import com.xzm.tyb.pojo.TybTeacherHanDan;
import com.xzm.tyb.pojo.TybUser;
import com.xzm.tyb.pojo.TybUserKaiHu;

import java.util.List;


/**
 * extends Service<TybUser>
 */
public interface TybUserService  extends IService<TybUser> {
    String login(String phone, String password);
    String register(TybUserForm user);
    String resetNickName(String access_token,String phone,String nick_name);
    TybUser getUserInfo(String access_token, String phone);
    List<TybTeacherHanDan> selectGenDanTeacherList(String access_token, String phone);
    TybUserKaiHu selectUserKaiHuInfo(String access_token, String phone);
    String userKaiHu(String access_token, String phone,String userName,String idCard,String platformCode);
}
