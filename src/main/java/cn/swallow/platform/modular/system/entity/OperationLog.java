package cn.swallow.platform.modular.system.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;

import java.util.Date;

/**
 * @author shenyu
 * @create 2019/3/15
 */
public class OperationLog extends BaseEntity<OperationLog> {
    /**
     * 日志类型
     */
    private String logType;
    /**
     * 日志名称
     */
    private String logname;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 类名称
     */
    private String className;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 是否成功
     */
    private Boolean succeed;
    /**
     * 备注
     */
    private String message;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
