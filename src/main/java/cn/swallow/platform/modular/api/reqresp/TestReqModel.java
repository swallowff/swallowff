package cn.swallow.platform.modular.api.reqresp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @author shenyu
 * @create 2019/4/2
 */
@ApiModel(value = "user",description = "用户")
public class TestReqModel {
    @ApiModelProperty(value = "用户ID",required = true)
    @NotEmpty(message = "{userId.empty}")
    private Integer userId;
    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty(message = "{userName.empty}")
    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
