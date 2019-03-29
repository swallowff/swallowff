package cn.swallow.platform.practice.common.service.impl;

import cn.swallow.platform.practice.common.constant.RespStatuesEnum;
import cn.swallow.platform.practice.common.service.MessageService;
import cn.swallow.platform.practice.concurrent.callable.entity.Message;
import cn.swallow.platform.practice.concurrent.callable.entity.MsgResult;

/**
 * @author shenyu
 * @create 2019/3/29
 */
public class AliMessageService implements MessageService {

    @Override
    public MsgResult sendMsg(Message message) {
        String msgId = message.getMsgId();
        String fromUser = message.getFromUser();
        String toUser = message.getToUser();
        MsgResult msgResult = new MsgResult(message,RespStatuesEnum.SUCCESS);
        System.out.println("发送消息成功");
        return msgResult;
    }

    @Override
    public MsgResult sendBatchMsg(Message[] messages) {
        System.out.println("批量发送消息成功");
        return null;
    }
}
