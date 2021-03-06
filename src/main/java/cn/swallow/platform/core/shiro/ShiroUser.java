package cn.swallow.platform.core.shiro;

import cn.hutool.core.convert.Convert;
import cn.swallow.platform.core.shiro.service.impl.UserRoleServiceImpl;
import cn.swallow.platform.modular.system.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @author yushen
 * @date 2019年3月9日 上午10:26:43
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;          // 主键ID
    public String account;      // 账号
    public String name;         // 姓名
    public Integer deptId;      // 部门id
    public List<Integer> roleList; // 角色集
    public String deptName;        // 部门名称
    public List<String> roleNames; // 角色名称集


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public static ShiroUser fromSysUser(User user){
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.id = user.getId();
        shiroUser.account = user.getAccount();
        shiroUser.name = user.getName();
        shiroUser.deptId = user.getDeptId();
//        Integer[] roleArray = Convert.toIntArray(user.getRoleId());
//        List<Integer> roleList = new ArrayList<>();
//        List<String> roleNames = new ArrayList<>();
//        for (Integer roleId : roleArray){
//            roleList.add(roleId);
//            roleNames.add(UserRoleServiceImpl.me().getRoleName(roleId));
//        }
//        shiroUser.setRoleList(roleList);
//        shiroUser.setRoleNames(roleNames);
        return shiroUser;
    }
}
