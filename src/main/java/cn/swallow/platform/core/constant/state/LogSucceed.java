package cn.swallow.platform.core.constant.state;

/**
 * @author shenyu
 * @create 2019/3/15
 */
public enum LogSucceed {

    SUCCESS(true),
    FAIL(false);

    Boolean code;

    LogSucceed(Boolean code) {
        this.code = code;
    }

    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }
}