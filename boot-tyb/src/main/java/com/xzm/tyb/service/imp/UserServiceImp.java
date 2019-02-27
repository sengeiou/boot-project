package com.xzm.tyb.service.imp;
//import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xzm.tyb.common.base.BaseServiceImpl;
import com.xzm.tyb.common.exception.RRException;
import com.xzm.tyb.common.utils.RegexUtils;
import com.xzm.tyb.constants.Constants;
import com.xzm.tyb.dao.TeacherHanDanMapper;
import com.xzm.tyb.dao.UserGenDanMapper;
import com.xzm.tyb.dao.UserKaiHuMapper;
import com.xzm.tyb.dao.UserMapper;
import com.xzm.tyb.pojo.entity.TybTeacherHanDan;
import com.xzm.tyb.pojo.entity.TybUser;
import com.xzm.tyb.pojo.entity.TybUserGenDan;
import com.xzm.tyb.pojo.entity.TybUserKaiHu;
import com.xzm.tyb.pojo.vo.TybUserVo;
import com.xzm.tyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
//import org.apache.commons.collections.CollectionUtils;

//import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImp extends BaseServiceImpl<UserMapper, TybUser> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserGenDanMapper userGenDanMapper;
    @Autowired
    private TeacherHanDanMapper teacherHanDanMapper;
    @Autowired
    private UserKaiHuMapper userKaiHuMapper;

    /**
     * 检查用户是否有效 （是否存在）
     */

    private boolean checkUserValid(String phone) {
        int count = userMapper.checkUserValid(phone);
        logger.debug("===查询用户===" + count);
        return count > 0;
    }

    /**
     * 用户登陆
     */
    @Override
    public String login(String phone, String password) {
        boolean isValid = checkUserValid(phone);
        if (!isValid) {
            throw new RRException("用户名不存在");
        }
        TybUser user = userMapper.selectByUserNameAndPassWord(phone, password);
        if (user == null) {
            throw new RRException("您输入的密码有误");
        }
        return "登陆成功";
    }

    /**
     * 用户注册
     */
    @Override
    public String register(TybUserVo user) {
//        baseMapper.selectByUniqueKey()
        if (!RegexUtils.isMobileExact(user.getPhone())) {
            throw new RRException("手机号号错误");
        }
        boolean isValid = checkUserValid(user.getPhone());
        if (isValid) {
            throw new RRException("当前用户已存在");
        }
        TybUser tybUser = new TybUser();
        tybUser.setPhone(user.getPhone());
        tybUser.setNickName(user.getPhone().substring(7, 11) + "投资");
        tybUser.setPassword(user.getPassword());
//        tybUser.setId(Long.parseLong(user.getPhone()));

        int count = userMapper.insert(tybUser);
        logger.debug("===插入用户===" + count);
        if (count == 1) {
            return "注册成功";
        }
        throw new RRException("注册失败");
    }

    /**
     * 修改用户昵称
     */
    @Override
    public String resetNickName(String phone, String nick_name) {
        int count = userMapper.updateUserNameByUniqueKey(phone, nick_name);
        logger.debug("==修改用户昵称=" + count);
        if (count == 1) {
            return "修改成功";
        }
        throw new RRException("修改失败");
    }

    /**
     * 获取用户信息
     */
    @Override
    public TybUser getUserInfo(String phone) {
//        TybUser tybUser = userMapper.selectByUniqueKey(phone);
//        TybUser tybUser = userMapper.selectOne(new QueryWrapper<TybUser>()
//                .eq("phone",phone));
        LambdaQueryWrapper<TybUser> queryWrapper = new QueryWrapper<TybUser>()
                .lambda().eq(TybUser::getPhone, phone);
        TybUser tybUser = userMapper.selectOne(queryWrapper);
        if (!ObjectUtils.isEmpty(tybUser)) {
            return tybUser;
        }
        throw new RRException("获取用户信息失败");
    }

    /**
     * //先查询用户跟单老师
     * 再根据老师ids去查询老师喊单列表
     */
    @Override
    public List<TybTeacherHanDan> selectGenDanTeacherList(String phone) {
        List<TybTeacherHanDan> teacherHanDanList = null;
        List<TybUserGenDan> genDanList = userGenDanMapper.selectUserGenDanByUserPhone(phone);
        List<Integer> ids = new ArrayList<>();
        genDanList.forEach(item -> ids.add(item.getTeacherId()));
        if (!CollectionUtils.isEmpty((ids))) {
            teacherHanDanList = teacherHanDanMapper.selectGenDanTeacherListByTeacherIds(ids);
        }
        return teacherHanDanList;
    }

    /**
     * 查询开户信息
     */
    @Override
    public TybUserKaiHu selectUserKaiHuInfo(String phone) {
        List<TybUserKaiHu> tybUserKaiHuList = userKaiHuMapper.selectUserKaiHuInfoByPhone(phone);
        if (!CollectionUtils.isEmpty(tybUserKaiHuList)) {
            return tybUserKaiHuList.get(0);
        } else {
            throw new RRException("您还没有开过户哦");

        }
    }

    /**
     * 开户
     */
    @Override
    public String userKaiHu(String phone, String userName, String idCard, String platformCode) {

        TybUserKaiHu userKaiHu = userKaiHuMapper.
                selectUserKaiHuInfoByPhoneAndIdCardAndPlatformCode(phone, idCard, platformCode);
        TybUserKaiHu tybUserKaihu = new TybUserKaiHu();
        if (!ObjectUtils.isEmpty(userKaiHu)) {
            throw new RRException("当前交易所已经开户");

        }
        if (!RegexUtils.isMobileExact(phone)) {
            throw new RRException("手机号不正确");
        }
        if (!RegexUtils.isIDCard18(idCard)) {
            throw new RRException("身份证号不正确");
        }
        tybUserKaihu.setPhone(phone);
        tybUserKaihu.setIdCard(idCard);
        tybUserKaihu.setUserName(userName);
        tybUserKaihu.setPlatformCode(platformCode);
        if (org.apache.commons.lang.ObjectUtils.equals(Constants.platformCode[0], platformCode)) {
            tybUserKaihu.setPlatformName("新华上海贵金属交易中心");
        } else if (org.apache.commons.lang.ObjectUtils.equals(Constants.platformCode[1], platformCode)) {
            tybUserKaihu.setPlatformName("上海石油化工交易中心");
        }
//        int count = userKaiHuMapper.insertSelective(userKaiHuDo);
        int count = userKaiHuMapper.insert(tybUserKaihu);
        logger.debug("提交开会llllllllll===" + count);
        if (count > 0) {
            return "开户成功";
        }
        throw new RRException("开户失败");

    }
}

