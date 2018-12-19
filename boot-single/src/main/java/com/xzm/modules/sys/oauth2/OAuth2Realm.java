//package com.xzm.modules.sys.oauth2;
//
//
//import com.xzm.common.utils.ShiroUtils;
//import com.xzm.modules.sys.entity.SysUserEntity;
//import com.xzm.modules.sys.entity.SysUserTokenEntity;
//import com.xzm.modules.sys.service.SysUserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Set;
//
//
///**
// * 认证
// *
// * @author ZhouChenglin
// * @email yczclcn@163.com
// * @url www.chenlintech.com
// * @date 2017年9月3日 上午3:24:29
// */
//@Component
//public class OAuth2Realm extends AuthorizingRealm {
//
//	@Autowired
//	private SysUserService sysUserService;
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof OAuth2Token;
//    }
//
//    /**
//     * 授权(验证权限时调用)
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//    	Long userId = ShiroUtils.getUserId();
//		//用户角色
//		Set<String> rolesSet = sysUserService.listUserRoles(userId);
//		//用户权限
//		Set<String> permsSet = sysUserService.listUserPerms(userId);
//        Collection<String> list;
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setRoles(rolesSet);
//		info.setStringPermissions(permsSet);
//		return info;
//    }
//
//    /**
//     * 认证(登录时调用)
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        String accessToken = (String) token.getPrincipal();
//
//        //根据accessToken，查询用户信息
//        SysUserTokenEntity tokenEntity = sysUserService.getByToken(accessToken);
//        //token失效
//        if(tokenEntity == null || tokenEntity.getGmtExpire().getTime() < System.currentTimeMillis()){
//            throw new IncorrectCredentialsException("token失效，请重新登录");
//        }
//
//        //查询用户信息
//        SysUserEntity user = sysUserService.getByUserName(tokenEntity.get());
//        //账号锁定
//        if(user.getStatus() == 0){
//            throw new LockedAccountException("账号已被锁定,请联系管理员");
//        }
//
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
//        return info;
//    }
//}
