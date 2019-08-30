package cn.swallow.platform.core.shiro.service.impl;

import cn.swallow.platform.core.shiro.service.UserRoleService;
import cn.swallow.platform.core.util.context.SpringContextHolder;
import cn.swallow.platform.modular.system.entity.Role;
import cn.swallow.platform.modular.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@DependsOn("springContextHolder")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private RoleService roleService;

    @Override
    public String getRoleName(String roleId) {
        Role role = roleService.selectById(roleId);
        return role.getName();
    }

    public static UserRoleService me(){
        return SpringContextHolder.getBean(UserRoleService.class);
    }


}
