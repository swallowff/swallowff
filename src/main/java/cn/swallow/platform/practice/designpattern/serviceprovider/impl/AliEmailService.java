package cn.swallow.platform.practice.designpattern.serviceprovider.impl;

import cn.swallow.platform.practice.designpattern.serviceprovider.inf.EmailService;

public class AliEmailService implements EmailService {
    private String company;

    public AliEmailService(String company) {
        this.company = company;
    }

    @Override
    public void sendEmail() {
        System.out.println("使用"+company+"发送了一封邮件");
    }
}
