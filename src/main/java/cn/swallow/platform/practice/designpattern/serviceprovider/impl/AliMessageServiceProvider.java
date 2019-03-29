package cn.swallow.platform.practice.designpattern.serviceprovider.impl;

import cn.swallow.platform.practice.designpattern.serviceprovider.inf.EmailService;
import cn.swallow.platform.practice.designpattern.serviceprovider.inf.MessageService;
import cn.swallow.platform.practice.designpattern.serviceprovider.inf.MessageServiceProvider;

public class AliMessageServiceProvider implements MessageServiceProvider {
    private static final String company = "阿里云";

    @Override
    public MessageService getMessageServie() {
        return new AliMessageService(company);
    }

    public EmailService getEmailService(){
        return new AliEmailService(company);
    }

}
