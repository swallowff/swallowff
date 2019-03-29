package cn.swallow.platform.practice.concurrent.callable.entity;

import java.util.UUID;

/**
 * @author shenyu
 * @create 2019/3/29
 */

public class MsgResult {
    private String msgId;
    private String fromUser;
    private String toUser;
    private String msgType;
    private String content;

    public MsgResult(String fromUser, String toUser, String content) {
        this.msgId = UUID.fromString("msg").toString();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
