//package com.xzm.config;
//
////import net.chenlin.dp.modules.sys.oauth2.OAuth2Filter;
////import net.chenlin.dp.modules.sys.oauth2.OAuth2Realm;
//
//import com.xzm.modules.sys.oauth2.OAuth2Filter;
//import com.xzm.modules.sys.oauth2.OAuth2Realm;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.session.mgt.SessionManager;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Shiro配置
// *
// *  @RequiresPermissions("select") 来验证用户是否具有select权限，delete方法使用
// *  @RequiresRoles("admin") 来验证用户是否是admin，代码如下：
// */
//@Configuration
//public class ShiroConfig {
//
//    @Bean("sessionManager")
//    public SessionManager sessionManager(){
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setSessionIdCookieEnabled(false);
//        return sessionManager;
//    }
//
//    @Bean("securityManager") // OAuth2Realm oAuth2Realm,
//    public SecurityManager securityManager(OAuth2Realm oAuth2Realm, SessionManager sessionManager) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(oAuth2Realm);
//        securityManager.setSessionManager(sessionManager);
//
//        return securityManager;
//    }
//
//    @Bean("shiroFilter")
//    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager);
//
//        //oauth过滤
//        Map<String, Filter> filters = new HashMap<>();
//        filters.put("oauth2", new OAuth2Filter());
//        shiroFilter.setFilters(filters);
//
//        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/webjars/**", "anon");
//        filterMap.put("/druid/**", "anon");
//        filterMap.put("/api/**", "anon");
//        filterMap.put("/sys/login", "anon");
//        filterMap.put("/sys/captcha.jpg", "anon");
//        filterMap.put("/**/*.css", "anon");
//        filterMap.put("/**/*.js", "anon");
//        filterMap.put("/**/*.html", "anon");
//        filterMap.put("/images/**", "anon");
//        filterMap.put("/fonts/**", "anon");
//        filterMap.put("/plugins/**", "anon");
//        filterMap.put("/swagger/**", "anon");
//        filterMap.put("/favicon.ico", "anon");
//        filterMap.put("/", "anon");
//        filterMap.put("/**", "oauth2");
//        shiroFilter.setFilterChainDefinitionMap(filterMap);
//
//        return shiroFilter;
//    }
//
//    @Bean("lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
//        proxyCreator.setProxyTargetClass(true);
//        return proxyCreator;
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }
//
//}
