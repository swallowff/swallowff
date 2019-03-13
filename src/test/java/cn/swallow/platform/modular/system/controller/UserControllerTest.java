package cn.swallow.platform.modular.system.controller;

import cn.swallow.platform.core.constant.dict.CommonEnum;
import cn.swallow.platform.core.shiro.ShiroKit;
import cn.swallow.platform.modular.system.entity.User;
import cn.swallow.platform.modular.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserService userService;

    @Test
    public void createMgrUserTest(){
        User user = new User();
        user.setAccount("admin");
        user.setBirthday(new Date());
        user.setName("shenyu");
        user.setPhone("17320393360");
        String salt = ShiroKit.getRandomSalt(5);
        user.setPassword(ShiroKit.md5("123456",salt));
        user.setStatus(CommonEnum.Enable.ENABLE.getCode());
        user.setSalt(salt);
        userService.insert(user);
    }

}