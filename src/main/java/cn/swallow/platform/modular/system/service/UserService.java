package cn.swallow.platform.modular.system.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.swallow.platform.common.base.service.CrudService;
import cn.swallow.platform.modular.system.dao.UserMapper;
import cn.swallow.platform.modular.system.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends CrudService<UserMapper,User> {

    public User selectByAccount(String account){
        User user = new User();
        user.setAccount(account);
        List<User> results = super.findList(user);
        return CollectionUtil.isEmpty(results) ? null : results.get(0);
    }


}
