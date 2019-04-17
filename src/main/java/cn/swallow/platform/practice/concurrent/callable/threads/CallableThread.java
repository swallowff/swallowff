package cn.swallow.platform.practice.concurrent.callable.threads;

import cn.swallow.platform.practice.common.factory.SingletonFactory;
import cn.swallow.platform.practice.common.service.MessageService;
import cn.swallow.platform.practice.common.service.impl.AliMessageService;
import cn.swallow.platform.practice.concurrent.callable.entity.MsgResult;
import cn.swallow.platform.practice.concurrent.callable.entity.TextMessage;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author shenyu
 * @create 2019/3/29
 */
public class CallableThread implements Callable<MsgResult> {
    @Override
    public MsgResult call() throws Exception {
        MessageService messageService = SingletonFactory.getInstace(AliMessageService.class);
        return messageService.sendMsg(new TextMessage("你好",0,"FromUser","ToUser"));

    }
}
