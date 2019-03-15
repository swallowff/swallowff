package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.core.common.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.LoginLog;
import org.springframework.stereotype.Repository;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Repository
public interface LoginLogMapper extends CrudMapper<LoginLog> {
}
