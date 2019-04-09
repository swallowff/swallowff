package cn.swallow.platform.core.util;

import cn.swallow.platform.config.web.RedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author shenyu
 * @create 2019/4/4
 */
public class JedisUtil {
    private static JedisPool jedisPool = SpringContextHolder.getBean(RedisConfig.class).getJedisPool();

    public static Jedis getClient(){
        return jedisPool.getResource();
    }

    public static String get(String key){
        return getClient().get(key);
    }

    public static String set(String key,String value){
        return getClient().set(key,value);
    }

    public static String set(String key, String value, int expireSeconds) {
        Jedis jedis = getClient();
        String result = jedis.set(key, value);
        if (expireSeconds != 0) {
            jedis.expire(key, expireSeconds);
        }
        return result;
    }
}
