package cn.swallow.platform.core.constant.state;

import cn.swallow.platform.common.state.AbstractState;

public enum  UserAuthState implements AbstractState {
    REPEAT_ACCOUNT(900,"用户名重复"),
    INCORRECT_CREDENTIALS(901,"密码错误"),
    UNKNOWN_ACCOUNT(902,"用户名不存在"),
    LOGIN_FAIL(903,"登录失败"),
    ;

    private Integer code;
    private String msg;

    UserAuthState(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
