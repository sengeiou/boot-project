package com.xzm.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/17
 * Time：22:51
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 * 我们首先使用cmd命令进入到Redis解压目录并且执行start /b  redis-server.exe redis.windows.conf
 * 让服务后台运行
 * 在执行的命令前加上start /b，比如start /b run.bat。就相当于Linux下的run.sh &。
 *
 *
 * 1. 进入 DOS窗口

 2. 在进入redis的安装目录

 3. 输入：redis-server --service-install redis.windows.conf --loglevel verbose ( 安装redis服务 )

 4.  输入：redis-server --service-start ( 启动服务 )

 5. 输入：redis-server --service-stop
 （停止服务）
 */
//@Configuration
//@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport
{

//    /**
//     * 自定义生成key的规则
//     * @return
//     */
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                //格式化缓存key字符串
//                StringBuilder sb = new StringBuilder();
//                //追加类名
//                sb.append(o.getClass().getName());
//                //追加方法名
//                sb.append(method.getName());
//                //遍历参数并且追加
//                for (Object obj : objects) {
//                    sb.append(obj.toString());
//                }
//                System.out.println("调用Redis缓存Key : " + sb.toString());
//                return sb.toString();
//            }
//        };
//    }
//    /**
//     * 采用RedisCacheManager作为缓存管理器
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        return new RedisCacheManager(redisTemplate);
//    }
}
