package cn.swallow.platform.practice.designpattern.serviceprovider;

import cn.swallow.platform.practice.designpattern.serviceprovider.impl.AliMessageServiceProvider;
import cn.swallow.platform.practice.designpattern.serviceprovider.inf.MessageService;

/**
 * 服务提供者模型，使用了静态工厂方法
 */
public class StartMain {

    public static void main(String[] args){
        MessageManager.registerDefaultProvider(new AliMessageServiceProvider());
        MessageService messageService = MessageManager.defaltMessageServiceInstance();
        messageService.sendMessage();
    }
}
