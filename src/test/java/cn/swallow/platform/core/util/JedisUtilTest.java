package cn.swallow.platform.core.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JedisUtilTest {

    @Test
    public void getValueTest(){
        System.out.println(JedisUtil.get("platform"));
    }

    @Test
    public void jedisLockTest(){
        boolean flag = JedisDistributedLockTools.tryGetDistributeLock("ORDER_LOCK","10000",60000);
        if (flag){
            System.out.println("获取锁成功!");
        }else {
            System.out.println("获取锁失败");
        }
    }
}