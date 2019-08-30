package cn.swallow.platform.modular.system.controller;

import cn.hutool.core.util.StrUtil;
import cn.swallow.platform.common.base.controller.BaseController;
import cn.swallow.platform.common.exception.InvalidKaptchaException;
import cn.swallow.platform.core.shiro.ShiroKit;
import cn.swallow.platform.core.shiro.ShiroUser;
import cn.swallow.platform.core.util.img.KaptchaUtil;
import cn.swallow.platform.modular.system.entity.Notice;
import cn.swallow.platform.modular.system.service.NoticeService;
import com.google.code.kaptcha.Constants;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("${adminPath}")
public class AdminLoginController extends BaseController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request){
        //已登录,跳转至主页
        if (ShiroKit.isAuthenticated()){
            return REDIRECT + "/admin";
        } else {
            return "admin/login";
        }
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
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
        return REDIRECT + "/";
    }

    @RequestMapping(value = "logout")
    public String doLogout(){
        Subject subject = ShiroKit.getSubject();
        subject.logout();
        return REDIRECT + "login";
    }

    @RequestMapping(value = "blackboard")
    public String blackboard(Model model){
        ShiroUser shiroUser = ShiroKit.getUser();
        if (null != shiroUser){
            Notice notice = new Notice();
            notice.setToUser(shiroUser.id);
            List<Notice> notices = noticeService.findList(notice);
            model.addAttribute("noticeList",notices);
        }
        return "admin/blackboard";
    }

    /**
     * 跳转到后台管理主页
     * @param model
     * @return
     */
    @RequestMapping("")
    public String index(Model model){
        return "admin/index";
    }


}
