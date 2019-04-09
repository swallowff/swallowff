package cn.swallow.platform.config.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author shenyu
 * @create 2019/4/4
 */
@Configuration
@ConfigurationProperties(prefix = RedisConfig.REDISCONF_PREFIX)
public class RedisConfig {
    public static final String REDISCONF_PREFIX = "redis";

    private String host = "127.0.0.1";
    private int port = 6379;
    private String username;
    private String password;
    private int timeout = 200;
    private int poolMaxIdle = 200;
    private int poolMaxTotal = 200;

    private JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(poolMaxIdle);
        config.setMaxTotal(poolMaxTotal);
        return config;
    }

    public JedisPool getJedisPool(){
        return new JedisPool(jedisPoolConfig(),host,port,timeout);
    }

    public JedisPool getJedisPool(int database){
        return new JedisPool(jedisPoolConfig(),host,port,timeout,password,database);
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }
}
