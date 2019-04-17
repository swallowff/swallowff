package cn.swallow.platform.core.util;

import java.util.Collections;

/**
 * @author shenyu
 * @create 2019/4/4
 */
public class JedisDistributedLockTools {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";  //NX:当key不存在时才进行set XX:当key存在时进行set
    private static final String EXPIRE_TIME_UNIT = "PX";    //EX:秒  PX:毫秒

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 获取分布式锁
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    public static boolean tryGetDistributeLock(String lockKey,String requestId,int expireTime){
        String result = JedisUtil.getClient().set(lockKey, requestId, SET_IF_NOT_EXIST, EXPIRE_TIME_UNIT, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     * @param lockKey
     * @param requestId
     * @return
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = JedisUtil.getClient().eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
