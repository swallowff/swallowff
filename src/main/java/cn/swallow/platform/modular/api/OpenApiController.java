package cn.swallow.platform.modular.api;

import cn.swallow.platform.core.common.resp.BaseResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shenyu
 * @create 2019/3/11
 */
@Controller
@RequestMapping(value = "openApi")
public class OpenApiController {

    @RequestMapping(value = "testapi")
    @ResponseBody
    public BaseResp test(HttpServletRequest request, HttpServletResponse response){
        return BaseResp.newSuccess().success();
    }

}
