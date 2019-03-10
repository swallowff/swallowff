package cn.swallow.platform.core.shiro.service;

public interface UserRoleService {

    /**
     * 根据角色ID获取角色名称
     * @param roleId
     * @return
     */
    public String getRoleName(Integer roleId);


}
