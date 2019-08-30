package cn.swallow.platform.common.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shenyu
 * @create 2019/3/15
 */
@Controller
@RequestMapping(value = "error")
public class ErrorController {

    @RequestMapping("404")
    public String page404(){
        return "common/error/404";
    }

    @RequestMapping("500")
    public String page500(){
        return "common/error/500";
    }
}
