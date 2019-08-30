package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.common.base.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper extends CrudMapper<Dept> {
}
