package cn.swallow.platform.modular.api.ctrl;

import cn.swallow.platform.common.base.controller.BaseController;
import cn.swallow.platform.common.base.res.BaseResp;
import cn.swallow.platform.modular.system.dto.UserDto;
import cn.swallow.platform.modular.system.entity.User;
import cn.swallow.platform.modular.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shenyu
 * @create 2019/4/2
 */
@Controller
@RequestMapping(value = "${apiPath}/user")
@Api(value = "用户api接口",tags = {"用户"},description = "接口描述")
public class UserApiController extends BaseController {
    @Autowired
    private UserService userService;

    @ApiResponse(code = 400,message = "Invalid user")
    @ApiOperation(value = "createUser",notes = "创建用户",consumes = "application/json")
    @RequestMapping(value = "createUser",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public BaseResp createUser(@RequestBody @ApiParam(name = "user",value = "Created user object",required = true) UserDto userDto){
        BaseResp baseResp = BaseResp.newSuccess();
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.insert(user);
        return baseResp;
    }
}
