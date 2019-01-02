package com.xzm.single.service;

import com.xzm.common.entity.ServerResponse;
import com.xzm.single.vo.TybTeacherHanDanVo;
import com.xzm.single.vo.TybUserInfoVo;
import com.xzm.single.vo.TybUserKaiHuInfoVo;
import com.xzm.single.form.TybUserForm;


public interface TybUserService {
//    ServerResponse<String> checkUserValid(String phone);
    ServerResponse<String> login(String phone, String password);
    ServerResponse<String> register(TybUserForm user);
    ServerResponse<String> resetNickName(String access_token,String phone,String nick_name);
    ServerResponse<TybUserInfoVo> getUserInfo(String access_token, String phone);
    ServerResponse<TybTeacherHanDanVo> selectGenDanTeacherList(String access_token, String phone);
    ServerResponse<TybUserKaiHuInfoVo> selectUserKaiHuInfo(String access_token, String phone);
    ServerResponse<String> userKaiHu(String access_token, String phone,String userName,String idCard,String platformCode);
}
