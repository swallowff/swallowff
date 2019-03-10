package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.core.common.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends CrudMapper<User> {
}
