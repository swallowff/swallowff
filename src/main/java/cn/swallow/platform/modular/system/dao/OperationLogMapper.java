package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.core.common.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Mapper
public interface OperationLogMapper extends CrudMapper<OperationLog> {
}
