package com.xzm.modules.sys.service.imp;

import com.xzm.common.constant.SystemConstant;
import com.xzm.common.entity.Page;
import com.xzm.common.entity.Query;
import com.xzm.common.entity.R;
import com.xzm.common.utils.CommonUtils;
import com.xzm.common.utils.MD5Utils;
import com.xzm.modules.sys.dao.*;
import com.xzm.modules.sys.entity.SysUserEntity;
import com.xzm.modules.sys.entity.SysUserTokenEntity;
import com.xzm.modules.sys.oauth2.TokenGenerator;
import com.xzm.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 系统用户
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月11日 上午11:47:17
 */
@Service
public class SysUserServiceImpl implements SysUserService {
	/**
	 * token过期时间，12小时
	 */
	private final static int TOKEN_EXPIRE = 1000 * 60 * 60 * 12;
//	@Autowired
//	private SysUserMapper sysUserManager;


	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Autowired
	private SysUserTokenMapper sysUserTokenMapper;
	@Override
	public Page<SysUserEntity> listUser(Map<String, Object> params) {
		Query form = new Query(params);
		Page<SysUserEntity> page = new Page<>(form);
		return page;
	}

	@Override
	public R saveUser(SysUserEntity user) {
		user.setPassword(MD5Utils.encrypt(user.getUsername(), user.getPassword()));
		int count = sysUserMapper.save(user);
		return CommonUtils.msg(count);
	}

	@Override
	public R getUserById(Long userId) {
		SysUserEntity user = sysUserMapper.getObjectById(userId);
		return CommonUtils.msg(user);
	}

	@Override
	public R updateUser(SysUserEntity user) {
		int count = sysUserMapper.update(user);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysUserMapper.batchRemove(id);
		return CommonUtils.msg(count);
	}

	@Override
	public R listUserPerms(Long userId) {

		List<String> perms = sysMenuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for (String perm : perms) {
			if (StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
//		Set<String> perms = sysMenuMapper.listUserPerms(userId);
		return CommonUtils.msgNotCheckNull(permsSet);
	}

	@Override
	public R updatePswdByUser(SysUserEntity user) {
		String username = user.getUsername();
		String pswd = user.getPassword();
		String newPswd = user.getEmail();
		pswd = MD5Utils.encrypt(username, pswd);
		newPswd = MD5Utils.encrypt(username, newPswd);
		Query query = new Query();
		query.put("userId", user.getUserId());
		query.put("pswd", pswd);
		query.put("newPswd", newPswd);
		int count = sysUserMapper.updatePswdByUser(query);
		if(!CommonUtils.isIntThanZero(count)) {
			return R.error("原密码错误");
		}
		return CommonUtils.msg(count);
	}

	@Override
	public R updateUserEnable(Long[] id) {

		Query query = new Query();
		query.put("status", SystemConstant.StatusType.ENABLE.getValue());
		query.put("id", id);
		int count = sysUserMapper.updateUserStatus(query);
//		int count = sysUserManager.updateUserEnable(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R updateUserDisable(Long[] id) {
//		int count = sysUserManager.updateUserDisable(id);

		Query query = new Query();
		query.put("status", SystemConstant.StatusType.DISABLE.getValue());
		query.put("id", id);
		int count = sysUserMapper.updateUserStatus(query);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R updatePswd(SysUserEntity user) {

		SysUserEntity currUser = sysUserMapper.getObjectById(user.getUserId());
		user.setPassword(MD5Utils.encrypt(currUser.getUsername(), user.getPassword()));
		int count = sysUserMapper.updatePswd(user);
		return CommonUtils.msg(count);
	}

    /**
     * 用户登录验证成功成功后
     *  重新生成Token 更新或者保存
     */
	@Override
	public R saveUserToken(Long userId) {
		//生成token
		String token = TokenGenerator.generateValue();
		//当前时间
		Date now = new Date();
		Date gmtExpire = new Date(now.getTime() + TOKEN_EXPIRE);
		SysUserTokenEntity userToken = sysUserTokenMapper.getByUserId(userId);
		if (userToken == null) {
			userToken = new SysUserTokenEntity();
			userToken.setUserId(userId);
			userToken.setToken(token);
			userToken.setGmtExpire(gmtExpire);
			userToken.setGmtModified(now);
			sysUserTokenMapper.save(userToken);
		} else {
			userToken.setToken(token);
			userToken.setGmtExpire(gmtExpire);
			userToken.setGmtModified(now);
			sysUserTokenMapper.update(userToken);
		}
//		return userToken;
		R r = R.ok().put("token", userToken.getToken()).put("expire", userToken.getGmtExpire());
		return r;
	}

	@Override
	public R updateUserToken(Long userId) {
		int count = sysUserTokenMapper.updateUserToken(userId);
		return CommonUtils.msg(count);
	}

	@Override
	public SysUserEntity getByUserName(String username) {
		return sysUserMapper.getByUserName(username);
	}

}
