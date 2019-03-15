package cn.swallow.platform.modular.system.controller;

import cn.hutool.core.util.StrUtil;
import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.exception.InvalidKaptchaException;
import cn.swallow.platform.core.constant.state.UserAuthState;
import cn.swallow.platform.core.shiro.ShiroKit;
import cn.swallow.platform.core.util.KaptchaUtil;
import com.google.code.kaptcha.Constants;
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
public class AdminLoginController extends BaseController {

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping(value = "${swallow.path.admin}/login",method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request){
        //已登录,跳转至主页
        if (ShiroKit.isAuthenticated()){
            return REDIRECT + "/admin";
        } else {
            model.addAttribute("beetl","beetl success");
            return "admin/login";
        }
    }

    @RequestMapping(value = "${swallow.path.admin}/login",method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "account") String account,
                          @RequestParam(value = "password") String password, Boolean rememberme, String kaptcha, RedirectAttributes redirectAttributes, Model model){
        if (KaptchaUtil.getKaptchaOnOff()) {
            kaptcha = kaptcha.trim();
            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (StrUtil.isBlank(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
                throw new InvalidKaptchaException();
            }
        }
        Subject subject = ShiroKit.getSubject();
        subject.login(new UsernamePasswordToken(account.trim(),password.trim(),rememberme == null ? false : rememberme));
        return REDIRECT + "/admin";
    }

    @RequestMapping(value = "${swallow.path.admin}/logout")
    public String doLogout(){
        Subject subject = ShiroKit.getSubject();
        subject.logout();
        return REDIRECT + "/admin/login";
    }

    @RequestMapping("/")
    public String defaultPage(){
        return "blog/login";
    }

    @RequestMapping("front")
    public String front(){
//        return "admin/blog/frontIndex";
        return "admin/index";
    }

    /**
     * 跳转到后台管理主页
     * @param model
     * @return
     */
    @RequestMapping("admin")
    public String index(Model model){
        return "admin/index";
    }


}
