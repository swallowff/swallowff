package cn.swallow.platform.modular.api.order.ctrl;

import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.reqresp.BaseResp;
import cn.swallow.platform.modular.api.order.req.OrderApiReq;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shenyu
 * @create 2019/4/1
 */
@Controller
@RequestMapping(value = "order")
public class OrderApiController extends BaseController {

    @RequestMapping(value = "createOrder",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public BaseResp createOrder(@Validated OrderApiReq orderApiReq, BindingResult bindingResult){
        BaseResp baseResp= BaseResp.newError();
        if (!validateBindingResult(bindingResult,baseResp)){
            return baseResp;
        }



        return baseResp;
    }

}
