package net.chenlin.dp.modules.sys.manager.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.chenlin.dp.common.constant.SystemConstant.StatusType;
import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.sys.dao.SysMenuMapper;
import net.chenlin.dp.modules.sys.dao.SysRoleMapper;
import net.chenlin.dp.modules.sys.dao.SysUserMapper;
import net.chenlin.dp.modules.sys.dao.SysUserRoleMapper;
import net.chenlin.dp.modules.sys.dao.SysUserTokenMapper;
import net.chenlin.dp.modules.sys.entity.SysUserEntity;
import net.chenlin.dp.modules.sys.entity.SysUserTokenEntity;
import net.chenlin.dp.modules.sys.manager.SysUserManager;
import net.chenlin.dp.modules.sys.oauth2.TokenGenerator;

/**
 * 系统用户
 *
 * @author ZhouChenglinusername
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月11日 上午11:44:21
 */
@Component("sysUserManager")
public class SysUserManagerImpl implements SysUserManager {

	/**
	 * token过期时间，12小时
	 */
	private final static int TOKEN_EXPIRE = 1000 * 60 * 60 * 12;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysUserTokenMapper sysUserTokenMapper;
	
	@Override
	public List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search) {
		return sysUserMapper.listForPage(page, search);
	}

	@Override
	public SysUserEntity getByUserName(String username) {
		return sysUserMapper.getByUserName(username);
	}

	@Override
	public int saveUser(SysUserEntity user) {
		int count = sysUserMapper.save(user);
		Query query = new Query();
		query.put("userId", user.getUserId());
		query.put("roleIdList", user.getRoleIdList());
		sysUserRoleMapper.save(query);
		return count;
	}

	@Override
	public SysUserEntity getById(Long userId) {
		SysUserEntity user = sysUserMapper.getObjectById(userId);
		user.setRoleIdList(sysUserRoleMapper.listUserRoleId(userId));
		return user;
	}

	@Override
	public int updateUser(SysUserEntity user) {
		int count = sysUserMapper.update(user);
		Long userId = user.getUserId();
		sysUserRoleMapper.remove(userId);
		Query query = new Query();
		query.put("userId", userId);
		query.put("roleIdList", user.getRoleIdList());
		sysUserRoleMapper.save(query);
		return count;
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysUserMapper.batchRemove(id);
		sysUserRoleMapper.batchRemoveByUserId(id);
		return count;
	}

	@Override
	public Set<String> listUserPerms(Long userId) {
		List<String> perms = sysMenuMapper.listUserPerms(userId);
		Set<String> permsSet = new HashSet<>();
		for(String perm : perms) {
			if(StringUtils.isNotBlank(perm)) {
				permsSet.addAll(Arrays.asList(perm.trim().split(",")));
			}
		}
		return permsSet;
	}

	@Override
	public Set<String> listUserRoles(Long userId) {
		List<String> roles = sysRoleMapper.listUserRoles(userId);
		Set<String> rolesSet = new HashSet<>();
		for(String role : roles) {
			if(StringUtils.isNotBlank(role)) {
				rolesSet.addAll(Arrays.asList(role.trim().split(",")));
			}
		}
		return rolesSet;
	}

	@Override
	public int updatePswdByUser(Query query) {
		return sysUserMapper.updatePswdByUser(query);
	}

	@Override
	public int updateUserEnable(Long[] id) {
		Query query = new Query();
		query.put("status", StatusType.ENABLE.getValue());
		query.put("id", id);
		int count = sysUserMapper.updateUserStatus(query);
		return count;
	}

	@Override
	public int updateUserDisable(Long[] id) {
		Query query = new Query();
		query.put("status", StatusType.DISABLE.getValue());
		query.put("id", id);
		int count = sysUserMapper.updateUserStatus(query);
		return count;
	}

	@Override
	public int updatePswd(SysUserEntity user) {
		return sysUserMapper.updatePswd(user);
	}

	@Override
	public SysUserEntity getUserById(Long userId) {//不包含角色信息
		return sysUserMapper.getObjectById(userId);
	}

	@Override
	public SysUserTokenEntity getByToken(String token) {
		return sysUserTokenMapper.getByToken(token);
	}

	@Override
	public SysUserTokenEntity saveUserToken(Long userId) {
		//生成token
		String token = TokenGenerator.generateValue();
		//当前时间
		Date now = new Date();
		Date gmtExpire = new Date(now.getTime() + TOKEN_EXPIRE);
		SysUserTokenEntity userToken = sysUserTokenMapper.getByUserId(userId);
		if(userToken == null) {
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
		return userToken;
	}

	@Override
	public int updateUserToken(Long userId) {
		String token = TokenGenerator.generateValue();
		SysUserTokenEntity userToken = new SysUserTokenEntity();
		userToken.setUserId(userId);
		userToken.setToken(token);
		return sysUserTokenMapper.update(userToken);
	}

}
