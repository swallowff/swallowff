package cn.swallow.platform.util;

import cn.hutool.core.date.DateUtil;
import cn.swallow.platform.Application;
import cn.swallow.platform.core.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringContextHolderTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testHolder(){
        ApplicationContext context = SpringContextHolder.getApplicationContext();
        logger.info(context.getApplicationName());
        logger.info(DateUtil.format(new Date(context.getStartupDate()),"yyyy-MM-dd HH:mm:ss"));
    }
}
