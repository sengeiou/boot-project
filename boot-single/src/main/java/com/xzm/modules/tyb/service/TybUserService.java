package com.xzm.modules.tyb.service;

import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.tyb.vo.TybTeacherHanDanVo;
import com.xzm.modules.tyb.vo.TybUserInfoVo;
import com.xzm.modules.tyb.vo.TybUserKaiHuInfoVo;
import com.xzm.tyb.form.TybUserForm;


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
