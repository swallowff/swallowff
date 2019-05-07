package cn.swallow.platform.core.util;

import cn.swallow.platform.config.web.RedisConfig;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author shenyu
 * @create 2019/4/4
 */
public class JedisUtil {
    private static JedisPool jedisPool = SpringContextHolder.getBean(RedisConfig.class).getJedisPool();

    public static Jedis getClient(){
        //TODO 高并发情况下可能出现获取不到Jedis的情况
        return jedisPool.getResource();
    }

    public static String get(String key){
        return getClient().get(key);
    }

    public static String set(String key,String value){
        return getClient().set(key,value);
    }

    public static String set(String key, String value, int expireSeconds) {
        assertJedisPool();
        Jedis jedis = getClient();
        try {
            String result = jedis.set(key, value);
            if (expireSeconds != 0) {
                jedis.expire(key, expireSeconds);
            }
            return result;
        } finally {
            close(jedis);
        }
    }

    public static boolean rpush(String key, String... values){
        assertJedisPool();
        Jedis jedis = getClient();
        try {
            Long result = jedis.rpush(key,values);
            if (result != null && result != 0){
                return true;
            }else {
                return false;
            }
        } finally {
            close(jedis);
        }
    }

    public static void close(Jedis jedis){
        if (null != jedis){
            jedis.close();
        }
    }

    public static void assertJedisPool(){
        Assert.notNull(jedisPool,"JedisPool dosen't define in springApplicationContext");
    }
}
