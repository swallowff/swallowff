package cn.swallow.platform.modular.api.ctrl;

import cn.swallow.platform.core.common.reqresp.BaseResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value = "${swallow.path.api}")
@Api(value = "TESTController")
public class OpenApiController {

    @RequestMapping(value = "testapi")
    @ResponseBody
    @ApiOperation(value = "测试方法",notes = "备注")
    public BaseResp test(HttpServletRequest request, HttpServletResponse response){
        return BaseResp.newSuccess().success();
    }





}
