package cn.swallow.platform.modular.manage.blog.controller;

import cn.swallow.platform.core.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shenyu
 * @create 2019/3/14
 */
@Controller
@RequestMapping(value = "blog")
public class BlogLoginController extends BaseController {

    /**
     * 跳转博客登录页
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "admin/blog/login";
    }

}
