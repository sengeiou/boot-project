package com.xzm.tyb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * TestUser：恒宇少年
 * Date：2017/4/17
 * Time：22:51
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 * 我们首先使用cmd命令进入到Redis解压目录并且执行start /b  redis-server.exe redis.windows.txt.conf
 * 让服务后台运行
 * 在执行的命令前加上start /b，比如start /b run.bat。就相当于Linux下的run.sh &。
 * <p>
 * <p>
 * 1. 进入 DOS窗口
 * <p>
 * 2. 在进入redis的安装目录
 * <p>
 * 3. 输入：redis-server --service-install redis.windows.txt.conf --loglevel verbose ( 安装redis服务 )
 * <p>
 * 4.  输入：redis-server --service-start ( 启动服务 )
 * <p>
 * 5. 输入：redis-server --service-stop
 * （停止服务）
 */

/**
 * @author 张瑶
 * @Description: redis配置
 * @date 2018/4/30 10:28
 */
@Configuration
@EnableCaching  //开启缓存

public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory getConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        return factory;
    }


    @Bean
    public RedisTemplate<?, ?> getRedisTemplate(){
        RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());
        return template;
    }
}
