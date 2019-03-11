package cn.swallow.platform.modular.system.controller;

import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.constant.state.UserAuthState;
import cn.swallow.platform.core.shiro.ShiroKit;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends BaseController {

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping(value = "${swallow.path.admin}/login",method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request){
        //已登录,跳转至主页
        if (ShiroKit.isAuthenticated()){
            return REDIRECT + "/";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "${swallow.path.admin}/login",method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "account") String account,
                          @RequestParam(value = "password") String password, Boolean rememberme, RedirectAttributes redirectAttributes, Model model){
        Subject subject = ShiroKit.getSubject();
        try {
            subject.login(new UsernamePasswordToken(account.trim(),password.trim(),rememberme == null ? false : rememberme));
        } catch (IncorrectCredentialsException e1){
            redirectAttributes.addFlashAttribute("tips", UserAuthState.INCORRECT_CREDENTIALS.getMsg());
            return REDIRECT + "login";
        } catch (UnknownAccountException e2){
            redirectAttributes.addFlashAttribute("tips",UserAuthState.UNKNOWN_ACCOUNT.getMsg());
            return REDIRECT + "login";
        } catch (AuthenticationException e3) {
            redirectAttributes.addFlashAttribute("tips",UserAuthState.LOGIN_FAIL.getMsg());
            return REDIRECT + "login";
        }
        return REDIRECT + "/";
    }

    /**
     * 跳转到主页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }


}
