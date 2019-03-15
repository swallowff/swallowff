package cn.swallow.platform.modular.system.controller;

import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.modular.system.entity.Role;
import cn.swallow.platform.modular.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shenyu
 * @create 2019/3/14
 */
@Controller
@RequestMapping(value = "${swallow.path.admin}/role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("insert")
    public String insert(Role role){
        roleService.insert(role);
        return REDIRECT + "roleList";
    }

    @RequestMapping("detail")
    public String getRole(@RequestParam("id") Integer id, Model model){
        model.addAttribute("role",roleService.selectById(id));
        return "admin/system/roleDetail";
    }

    @RequestMapping("list")
    public String listRole(Role role,Model model){
        model.addAttribute("list",roleService.findList(role));
        return "admin/system/roleList";
    }

    @RequestMapping("update")
    public String update(Role role){
        roleService.update(role);
        return REDIRECT + "roleList";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer id){
        roleService.delete(id);
        return REDIRECT + "list";
    }
}
