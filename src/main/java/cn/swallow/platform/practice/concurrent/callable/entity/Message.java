package cn.swallow.platform.practice.concurrent.callable.entity;

import java.util.UUID;

public abstract class Message {
    private String msgId;
    private String content;
    private int msgType;
    private String fromUser;
    private String toUser;

    public Message(String content, int msgType,String fromUser,String toUser) {
        this.msgId = UUID.randomUUID().toString();
        this.content = content;
        this.msgType = msgType;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public String getMsgId() {
        return msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
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
}
