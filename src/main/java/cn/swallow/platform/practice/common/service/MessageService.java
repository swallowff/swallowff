package cn.swallow.platform.practice.common.service;

import cn.swallow.platform.practice.concurrent.callable.entity.Message;
import cn.swallow.platform.practice.concurrent.callable.entity.MsgResult;

/**
 * @author shenyu
 * @create 2019/3/29
 */
public interface MessageService {

    public MsgResult sendMsg(Message message);

    public MsgResult sendBatchMsg(Message[] messages);
}
