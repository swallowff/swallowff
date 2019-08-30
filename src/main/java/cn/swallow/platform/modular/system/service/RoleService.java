package cn.swallow.platform.modular.system.service;

import cn.swallow.platform.common.base.service.CrudService;
import cn.swallow.platform.modular.system.dao.RoleMapper;
import cn.swallow.platform.modular.system.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends CrudService<RoleMapper, Role> {

}
