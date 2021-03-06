package cn.swallow.platform.core.constant.state;

public enum ResponseState implements AbstractState {
    SUCCESS(200,"操作成功"),
    SYSTEM_ERROR(502,"系统错误"),
    UNKNOWN_ERROR(500,"未知的错误"),
    EMPTY_DATA(400,"数据为空");

    private Integer code;

    private String msg;

    ResponseState(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
