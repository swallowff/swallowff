package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.common.base.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Mapper
public interface LoginLogMapper extends CrudMapper<LoginLog> {
}
