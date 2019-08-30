package cn.swallow.platform.modular.system.dao;

import cn.swallow.platform.common.base.dao.CrudMapper;
import cn.swallow.platform.modular.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends CrudMapper<Role> {
}
