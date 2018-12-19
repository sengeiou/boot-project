package com.xzm.modules.sys.dao;


import com.xzm.common.entity.Query;
import com.xzm.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户dao
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午3:26:05
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);

	List<Long> listAllMenuId(Long userId);

	List<Long> listAllOrgId(Long userId);

	int updatePswdByUser(Query query);

	int updateUserStatus(Query query);

	int updatePswd(SysUserEntity user);



//	SysUserEntity getByUserName(String username);
//
//	List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search);
//
//	int saveUser(SysUserEntity user);
//
//	SysUserEntity getById(Long userId);
//
//	int updateUser(SysUserEntity user);
//
//	int batchRemove(Long[] id);
//
//	Set<String> listUserPerms(Long userId);
//
//	Set<String> listUserRoles(Long userId);
//
//	int updatePswdByUser(Query query);
//
//	int updateUserEnable(Long[] id);
//
//	int updateUserDisable(Long[] id);
//
//	int updatePswd(SysUserEntity user);
//
//	SysUserEntity getUserById(Long userId);
//
//	SysUserTokenEntity getByToken(String token);
//
//	SysUserTokenEntity saveUserToken(Long userId);
//
//	int updateUserToken(Long userId);
	
}
