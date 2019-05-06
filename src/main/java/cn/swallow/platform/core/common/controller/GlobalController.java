package cn.swallow.platform.core.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Controller
public class GlobalController {
    @RequestMapping("/")
    public String blankPath(){
        return "redirect:"+"admin";
    }

    /**
     * 跳转到404页面
     *
     * @author fengshuonan
     */
    @RequestMapping(path = "/global/error")
    public View errorPage() {
        return new SwallowErrorView();
    }

    /**
     * 跳转到session超时页面
     *
     * @author fengshuonan
     */
    @RequestMapping(path = "/global/sessionError")
    public String errorPageInfo(Model model) {
        model.addAttribute("tips", "session超时");
        return "/admin/login";
    }
}
