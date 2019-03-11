package cn.swallow.platform.system.service;

import cn.hutool.core.date.DateUtil;
import cn.swallow.platform.core.shiro.ShiroKit;
import cn.swallow.platform.core.util.GsonHelper;
import cn.swallow.platform.modular.system.entity.User;
import cn.swallow.platform.modular.system.service.UserService;
import cn.swallow.platform.SwallowffApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SwallowffApplication.class)
public class UserServiceTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Test
    public void selectById(){
        User user = userService.selectById(50);
        logger.debug(GsonHelper.toJson(userService.selectById(50)));
    }

    @Test
    public void findList(){
        logger.info(ShiroKit.md5("123456","72d59625138d20bcddb9df4f4dfd152d"));

    }

    @Test
    public void selectByAccount(){
    }

    @Test
    public void update(){
        User user = userService.selectById(50);
        user.setAccount("admin modify");
        userService.update(user);
    }

    @Test
    public void updateSelective(){

    }

    @Test
    public void delete(){

    }

    @Test
    public void insert(){
        User user = new User();
        user.setAccount("admin");
        user.setBirthday(DateUtil.parse("1995-05-27"));
        user.setEmail("swallowff@163.com");
        user.setPhone("17320393360");
        user.setName("shenyu");
        user.setSex(1);
        userService.insert(user);
    }

}
