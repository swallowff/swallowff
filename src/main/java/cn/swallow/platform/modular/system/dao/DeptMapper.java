package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.core.common.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface DeptMapper extends CrudMapper<Dept> {
}
