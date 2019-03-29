package cn.swallow.platform.practice.common.constant;

public enum  RespStatuesEnum {
    SUCCESS(200,"成功"),
    FAIL(400,"错误");

    private Integer code;

    private String msg;

    RespStatuesEnum(Integer code, String msg) {
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

    public boolean isSuccess(){
        return this == SUCCESS;
    }
}
