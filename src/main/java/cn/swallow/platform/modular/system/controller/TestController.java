package cn.swallow.platform.modular.system.controller;

import cn.swallow.platform.config.properties.SwallowProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "${swallow.admin-path}/test")
public class TestController {

    @RequestMapping(value = "index")
    public String toIndexPage(HttpServletRequest request, Model model){
        Map<String,Object> map = new HashMap();
        map.put("tittle","你好");
        map.put("tittle2","测试");
        model.addAllAttributes(map);
        return "pages/index";
    }

    @RequestMapping(value = "muban")
    public String muban(){
        return "index";
    }
}
