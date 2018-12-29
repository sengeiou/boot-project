package com.xzm.modules.sys.service;

import com.xzm.common.entity.Page;
import com.xzm.common.entity.R;
import com.xzm.modules.sys.entity.SysUserEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月11日 上午11:45:42
 */
public interface SysUserService {

	Page<SysUserEntity> listUser(Map<String, Object> params);

	R saveUser(SysUserEntity user);

	R getUserById(Long userId);

	R updateUser(SysUserEntity user);

	R batchRemove(Long[] id);

	R listUserPerms(Long userId);

	R updatePswdByUser(SysUserEntity user);

	R updateUserEnable(Long[] id);

	R updateUserDisable(Long[] id);

	R updatePswd(SysUserEntity user);

	R saveUserToken(Long userId);

	R updateUserToken(Long userId);

	SysUserEntity getByUserName(String username);


//    SysUserEntity getByUserName(String username);
//
//    List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search);
//
//    R saveUser(SysUserEntity user);
//
//    R getById(Long userId);
//
//    R updateUser(SysUserEntity user);
//
//    R batchRemove(Long[] id);
//
//    R listUserPerms(Long userId);
//
//    R listUserRoles(Long userId);
//
//    R updatePswdByUser(Query query);
//
//    R updateUserEnable(Long[] id);
//
//    R updateUserDisable(Long[] id);
//
//    R updatePswd(SysUserEntity user);
//
//    SysUserEntity getUserById(Long userId);
//
//    SysUserTokenEntity getByToken(String token);
//
//    SysUserTokenEntity saveUserToken(Long userId);
//
//    int updateUserToken(Long userId);

}
