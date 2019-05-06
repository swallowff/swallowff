package cn.swallow.platform.modular.api.ctrl;

import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.exception.ServiceException;
import cn.swallow.platform.core.common.reqresp.BaseResp;
import cn.swallow.platform.core.shiro.ShiroKit;
import cn.swallow.platform.core.shiro.ShiroUser;
import cn.swallow.platform.modular.api.reqresp.TestReqModel;
import cn.swallow.platform.modular.api.reqresp.TestRespModel;
import io.swagger.annotations.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author shenyu
 * @create 2019/3/11
 */
@Controller
@RequestMapping(value = "${swallow.path.api}")
@Api(tags = {"测试接口","测试接口2"},description = "这是一个测试的接口")
public class OpenApiController extends BaseController {

    @RequestMapping(value = "doTest",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "测试方法",notes = "备注")
    @ApiResponse(code = 400,message = "请求参数不正确")
    @ApiImplicitParams({@ApiImplicitParam( paramType="query", name = "userId", value = "用户编号", required = true, dataType = "Integer"),
                        @ApiImplicitParam(paramType = "query",name = "username",value = "用户名称",dataType = "String")})
    @ApiParam(name = "test",value = "test")
    public BaseResp test(@Validated TestReqModel testReqModel,BindingResult bindingResult){
        BaseResp baseResp = BaseResp.newError();
        if (!validateBindingResult(bindingResult,baseResp)){
            return baseResp;
        }
        TestRespModel testRespModel = new TestRespModel(1,"tom");
        return BaseResp.newSuccess().setData(testRespModel);
    }

    @RequestMapping("test")
    @ResponseBody
    public BaseResp test2(String id){
        Subject subject = ShiroKit.getSubject();
        ShiroUser shiroUser = ShiroKit.getUser();
        return BaseResp.newSuccess().setData(shiroUser.getName());
    }





}
