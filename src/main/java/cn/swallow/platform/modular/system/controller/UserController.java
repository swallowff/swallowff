package cn.swallow.platform.modular.system.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.swallow.platform.core.common.annotation.BusinessLog;
import cn.swallow.platform.core.common.controller.BaseController;
import cn.swallow.platform.core.common.resp.BaseResp;
import cn.swallow.platform.core.constant.dict.CommonEnum;
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
@RequestMapping("${swallow.admin-path}/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @BusinessLog
    @RequestMapping(value = "get",method = RequestMethod.POST)
    public BaseResp getUser(@RequestParam(name = "id") Integer id){
        BaseResp baseResp = BaseResp.newSuccess();
        User user = userService.selectById(id);
        if (null == user){
            return baseResp.emptyData();
        }else {
            baseResp.setData(user);
        }
        return baseResp;
    }

    @BusinessLog
    @RequestMapping(value = "list",method = RequestMethod.POST)
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

    @RequestMapping(value = "createMgrUser",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public BaseResp createMgrUser(@RequestBody UserDto userDto){
        BaseResp baseResp = BaseResp.newSuccess();
        User user = UserAuthServiceImpl.me().user(userDto.getAccount());
        if (user != null){
            return baseResp.putResp(UserAuthState.REPEAT_ACCOUNT);
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
