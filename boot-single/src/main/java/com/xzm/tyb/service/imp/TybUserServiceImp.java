package com.xzm.tyb.service.imp;
import com.xzm.common.entity.ServerResponse;
import com.xzm.common.utils.RegexUtils;
import com.xzm.modules.tyb.constants.Constants;
import com.xzm.modules.tyb.dao.TybTeacherHanDanMapper;
import com.xzm.modules.tyb.dao.TybUserGenDanMapper;
import com.xzm.modules.tyb.dao.TybUserKaiHuMapper;
import com.xzm.modules.tyb.dao.TybUserMapper;
import com.xzm.modules.tyb.form.TybUserForm;
import com.xzm.modules.tyb.pojo.TybTeacherHanDan;
import com.xzm.modules.tyb.pojo.TybUser;
import com.xzm.modules.tyb.pojo.TybUserGenDan;
import com.xzm.modules.tyb.pojo.TybUserKaiHu;
import com.xzm.modules.tyb.service.TybUserService;
import com.xzm.modules.tyb.vo.TybTeacherHanDanVo;
import com.xzm.modules.tyb.vo.TybUserInfoVo;
import com.xzm.modules.tyb.vo.TybUserKaiHuInfoVo;
import com.xzm.tyb.service.TybUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.util.ObjectUtils;

@Service
public class TybUserServiceImp implements TybUserService {
    private static final Log logger = LogFactory.getLog(TybUserServiceImp.class);
    @Autowired
    private TybUserMapper userMapper;
    @Autowired
    private TybUserGenDanMapper userGenDanMapper;
    @Autowired
    private TybTeacherHanDanMapper teacherHanDanMapper;
    @Autowired
    private TybUserKaiHuMapper userKaiHuMapper;

    /**
     * 检查用户是否有效 （是否存在）
     */

    private boolean checkUserValid(String phone) {
        int count = userMapper.checkUserValid(phone);
        logger.debug("===查询用户===" + count);
//        if(resultCount == 0 ){
//            return ServerResponse.createByErrorMessage("用户不存在");
//        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    /**
     * 用户登陆
     */
    @Override
    public ServerResponse<String> login(String phone, String password) {
        boolean isValid = checkUserValid(phone);
        if (!isValid) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        TybUser user = userMapper.selectByUserNameAndPassWord(phone, password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您输入的密码有误");
        }
        return ServerResponse.createBySuccess("登陆成功");
    }

    /**
     * 用户注册
     */
    @Override
    public ServerResponse<String> register(TybUserForm user) {
        if (!RegexUtils.isMobileExact(user.getPhone())) {
            return ServerResponse.createByErrorMessage("手机号号错误");
        }
        boolean isValid = checkUserValid(user.getPhone());
        if (isValid) {
            return ServerResponse.createByErrorMessage("当前用户已存在");
        }
        TybUser tybUser = new TybUser();
        tybUser.setPhone(user.getPhone());
        tybUser.setNickName(user.getPhone().substring(7, 11) + "投资");
        tybUser.setPassword(user.getPassword());
        int count = userMapper.insertSelective(tybUser);
        logger.debug("===插入用户===" + count);
        if (count == 1) {
            return ServerResponse.createBySuccess("注册成功");
        }

//        if (count > 0) {
//            return ServerResponse.createBySuccess("注册成功");
//        }
        return ServerResponse.createBySuccess("注册失败");
    }

    /**
     * 修改用户昵称
     */
    @Override
    public ServerResponse<String> resetNickName(String access_token, String phone, String nick_name) {
        int count = userMapper.updateUserNameByUniqueKey(phone, nick_name);
        logger.debug("==修改用户昵称=" + count);
        if (count == 1) {
            return ServerResponse.createBySuccess("修改成功");
        }
        return ServerResponse.createBySuccess("修改失败");
    }

    /**
     * 获取用户信息
     */
    @Override
    public ServerResponse<TybUserInfoVo> getUserInfo(String access_token, String phone) {
        TybUser tybUser = userMapper.selectByUniqueKey(phone);
        if (!ObjectUtils.isEmpty(tybUser)) {
            TybUserInfoVo tybUserInfoVo = new TybUserInfoVo();
            TybUserInfoVo.UserInfo userInfo = new TybUserInfoVo.UserInfo();
            userInfo.setNickName(tybUser.getNickName());
            userInfo.setPhone(tybUser.getPhone());
            userInfo.setPhoneUrl(tybUser.getPhoneUrl());
            userInfo.setPushStatus(tybUser.getPushStatus());
            tybUserInfoVo.setUserInfo(userInfo);
            return ServerResponse.createBySuccess(tybUserInfoVo);
        }
        return ServerResponse.createByErrorMessage("获取用户信息失败");
    }

    /**
     * //先查询用户跟单老师
     * 再根据老师ids去查询老师喊单列表
     */
    @Override
    public ServerResponse<TybTeacherHanDanVo> selectGenDanTeacherList(String access_token, String phone) {
        List<TybTeacherHanDan> teacherHanDanList = null;
        List<TybUserGenDan> genDanList = userGenDanMapper.selectUserGenDanByUserPhone(phone);
        List<Integer> ids = new ArrayList<>();
        genDanList.forEach(item -> ids.add(item.getTeacherId()));
        if (!CollectionUtils.isEmpty((ids))) {
            teacherHanDanList = teacherHanDanMapper.selectGenDanTeacherListByTeacherIds(ids);
        }
        TybTeacherHanDanVo teacherHanDanVo = new TybTeacherHanDanVo();
        teacherHanDanVo.setObject(teacherHanDanList);
        return ServerResponse.createBySuccess(teacherHanDanVo);
    }

    /**
     * 查询开户信息
     */
    @Override
    public ServerResponse<TybUserKaiHuInfoVo> selectUserKaiHuInfo(String access_token, String phone) {
        List<TybUserKaiHu> tybUserKaiHuList = userKaiHuMapper.selectUserKaiHuInfoByPhone(phone);
        if (!CollectionUtils.isEmpty(tybUserKaiHuList)) {
            TybUserKaiHu tybUserKaiHu = tybUserKaiHuList.get(0);
            TybUserKaiHuInfoVo userKaiHuInfoVo = new TybUserKaiHuInfoVo();
            userKaiHuInfoVo.setIdCard(tybUserKaiHu.getIdCard());
            userKaiHuInfoVo.setUserName(tybUserKaiHu.getUserName());
            return ServerResponse.createBySuccess(userKaiHuInfoVo);
        } else {
            return ServerResponse.createBySuccess("您还没有开过户哦", null);
        }
    }

    /**
     * 开户
     */
    @Override
    public ServerResponse<String> userKaiHu(String access_token,
                                            String phone,
                                            String userName,
                                            String idCard,
                                            String platformCode) {
        TybUserKaiHu userKaiHu = userKaiHuMapper.
                selectUserKaiHuInfoByPhoneAndIdCardAndPlatformCode(phone, idCard, platformCode);

        TybUserKaiHu userKaiHuDo = new TybUserKaiHu();
        if (!ObjectUtils.isEmpty(userKaiHu)) {
            return ServerResponse.createByErrorMessage("当前交易所已经开户");

        }
        if (!RegexUtils.isMobileExact(phone)) {
            return ServerResponse.createByErrorMessage("手机号不正确");
        }
        if (!RegexUtils.isIDCard18(idCard)) {
            return ServerResponse.createByErrorMessage("身份证号不正确");
        }
        userKaiHuDo.setPhone(phone);
        userKaiHuDo.setIdCard(idCard);
        userKaiHuDo.setUserName(userName);
        userKaiHuDo.setPlatformCode(platformCode);

        if (org.apache.commons.lang.ObjectUtils.equals(Constants.platformCode[0], platformCode)) {
            userKaiHuDo.setPlatformName("新华上海贵金属交易中心");
        } else if (org.apache.commons.lang.ObjectUtils.equals(Constants.platformCode[1], platformCode)) {
            userKaiHuDo.setPlatformName("上海石油化工交易中心");
        }
        logger.debug("提交开会信息=phone==" + phone);
        logger.debug("提交开会信息=userName==" + userName);
        logger.debug("提交开会信息=idCard==" + idCard);
        logger.debug("提交开会信息=platformCode==" + platformCode);
        logger.debug("提交开会信息=platformName==" + userKaiHuDo.getPlatformName());
        logger.debug("提交开会信息===" + userKaiHuDo.toString());
        int count = userKaiHuMapper.insertSelective(userKaiHuDo);
        logger.debug("提交开会llllllllll===" + count);
        if (count > 0) {
            return ServerResponse.createBySuccessMessage("开户成功");
        }
        return ServerResponse.createByErrorMessage("开户失败");
    }
}

