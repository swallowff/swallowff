package cn.swallow.platform.modular.system.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.swallow.platform.core.common.annotation.BusinessLog;
import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.reqresp.BaseResp;
import cn.swallow.platform.core.constant.dict.CommonEnum;
import cn.swallow.platform.core.constant.state.ResponseState;
import cn.swallow.platform.core.constant.state.UserAuthState;
import cn.swallow.platform.core.shiro.ShiroKit;
import cn.swallow.platform.core.shiro.service.impl.UserAuthServiceImpl;
import cn.swallow.platform.modular.system.dto.UserDto;
import cn.swallow.platform.modular.system.entity.User;
import cn.swallow.platform.modular.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("${adminPath}/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @BusinessLog
    @RequestMapping(value = "get",method = RequestMethod.POST)
    @ResponseBody
    public BaseResp getUser(@RequestParam(name = "id") Integer id){
        BaseResp baseResp = BaseResp.newSuccess();
        User user = userService.selectById(id);
        if (null == user){
            return baseResp.emptyData();
        }else {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user,userDto);
            baseResp.setData(userDto);
        }
        return baseResp;
    }

    @BusinessLog
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public BaseResp userList(@Validated User user, BindingResult bindingResult){
        BaseResp baseResp = BaseResp.newSuccess();
        if (!validateBindingResult(bindingResult,baseResp)){
            return baseResp;
        }
        List<User> userList = userService.findList(user);
        if (CollectionUtil.isEmpty(userList)){
            return baseResp.emptyData();
        }
        return baseResp.setData(userList.stream().collect(Collectors.toCollection(ArrayList::new)));
    }

    @RequestMapping(value = "createMgrUser",method = RequestMethod.POST)
    @ResponseBody
    public BaseResp createMgrUser(UserDto userDto){
        BaseResp baseResp = BaseResp.newSuccess();
        User user = UserAuthServiceImpl.me().user(userDto.getAccount());
        if (user != null){
            return baseResp.putState(UserAuthState.REPEAT_ACCOUNT);
        }
        String emailRegex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
        String email = userDto.getEmail();
        if (StrUtil.isNotBlank(email) && !email.matches(emailRegex)){
            return baseResp.putState(ResponseState.ILLEGAL_FORMAT_EMAIL);
        }
        user = new User();
        BeanUtils.copyProperties(userDto,user);
        String salt = ShiroKit.getRandomSalt(5);
        user.setPassword(ShiroKit.md5(userDto.getPassword(),salt));
        user.setStatus(CommonEnum.Enable.ENABLE.getCode());
        user.setSalt(salt);
        userService.insert(user);
        return baseResp.success();
    }


}
