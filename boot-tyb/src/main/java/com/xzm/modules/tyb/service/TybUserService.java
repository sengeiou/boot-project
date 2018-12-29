package com.xzm.modules.tyb.service;

import com.baomidou.mybatisplus.service.IService;
import com.xzm.common.entity.ServerResponse;
import com.xzm.modules.tyb.form.TybUserForm;
import com.xzm.modules.tyb.pojo.TybUser;
import com.xzm.modules.tyb.vo.TybTeacherHanDanVo;
import com.xzm.modules.tyb.vo.TybUserInfoVo;
import com.xzm.modules.tyb.vo.TybUserKaiHuInfoVo;

/**
 * extends Service<TybUser>
 */
public interface TybUserService  extends IService<TybUser> {
//    ServerResponse<String> checkUserValid(String phone);
    ServerResponse<String> login(String phone, String password);
    ServerResponse<String> register(TybUserForm user);
    ServerResponse<String> resetNickName(String access_token,String phone,String nick_name);
    ServerResponse<TybUserInfoVo> getUserInfo(String access_token, String phone);
    ServerResponse<TybTeacherHanDanVo> selectGenDanTeacherList(String access_token, String phone);
    ServerResponse<TybUserKaiHuInfoVo> selectUserKaiHuInfo(String access_token, String phone);
    ServerResponse<String> userKaiHu(String access_token, String phone,String userName,String idCard,String platformCode);
}
