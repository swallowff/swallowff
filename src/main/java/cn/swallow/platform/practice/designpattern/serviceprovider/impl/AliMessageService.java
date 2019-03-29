package cn.swallow.platform.practice.designpattern.serviceprovider.impl;

import cn.swallow.platform.practice.designpattern.serviceprovider.inf.MessageService;

public class AliMessageService implements MessageService {
    private String company;

    public AliMessageService(String company) {
        this.company = company;
    }

    @Override
    public void sendMessage() {
        System.out.println("使用"+company+"发送了一条消息");
    }
}
