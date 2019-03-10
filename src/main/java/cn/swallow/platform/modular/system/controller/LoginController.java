package cn.swallow.platform.modular.system.controller;

import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.resp.BaseResp;
import cn.swallow.platform.core.shiro.ShiroKit;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("${swallow.admin-path}")
public class LoginController extends BaseController {

    @RequestMapping(value = "login")
    @ResponseBody
    public BaseResp login(@RequestParam(value = "account") String account,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "rememberme") Boolean rememberme){
        BaseResp baseResp = BaseResp.newSuccess();
        Subject subject = ShiroKit.getSubject();
        try {
            subject.login(new UsernamePasswordToken(account,password,rememberme));
            baseResp.success();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            baseResp.error();
            baseResp.setMessage("登录失败");
        } finally {
            return baseResp;
        }
    }
}
