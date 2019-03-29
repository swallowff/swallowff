package cn.swallow.platform.practice.concurrent.callable.entity;

import cn.swallow.platform.practice.common.constant.RespStatuesEnum;

/**
 * @author shenyu
 * @create 2019/3/29
 */

public class MsgResult {
    private String msgId;
    private Integer code;
    private boolean success;
    private String fromUser;
    private String toUser;

    public MsgResult(Message message, RespStatuesEnum statuesEnum) {
        this.msgId = message.getMsgId();
        this.code = statuesEnum.getCode();
        this.success = statuesEnum.isSuccess();
        this.fromUser = message.getFromUser();
        this.toUser = message.getToUser();
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
