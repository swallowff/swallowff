package cn.swallow.platform.modular.system.controller;

import cn.swallow.platform.config.properties.SwallowProperties;
import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.controller.SwallowErrorView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "${adminPath}/test")
public class TestController extends BaseController {

    @RequestMapping(value = "index")
    public String toIndexPage(HttpServletRequest request, Model model){
        Map<String,Object> map = new HashMap();
        map.put("tittle","你好");
        map.put("tittle2","测试");
        model.addAllAttributes(map);
        return "index";
    }

    @RequestMapping(value = "muban")
    public View muban(){
        return new SwallowErrorView();
    }


    @RequestMapping(value = "redirectTo")
    public ModelAndView redirectTo( HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("msg","hello");
        return modelAndView;
    }

    @RequestMapping(value = "swagger")
    public String swagger(){
        return "swagger-ui";
    }
}
