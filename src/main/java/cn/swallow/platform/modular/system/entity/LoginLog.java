package cn.swallow.platform.modular.system.entity;

import cn.swallow.platform.core.common.entity.BaseEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Date;

/**
 * @author shenyu
 * @create 2019/3/15
 */
public class LoginLog extends BaseEntity<LoginLog> {
    /**
     * 日志名称
     */
    private String logName;
    /**
     * 管理员id
     */
    private String userId;
    /**
     * 是否执行成功
     */
    private Boolean succeed;
    /**
     * 具体消息
     */
    private String message;
    /**
     * 登录ip
     */
    private String ip;


    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
