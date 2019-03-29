package cn.swallow.platform.practice.designpattern.serviceprovider;

import cn.swallow.platform.practice.designpattern.serviceprovider.inf.MessageService;
import cn.swallow.platform.practice.designpattern.serviceprovider.inf.MessageServiceProvider;

import java.util.concurrent.ConcurrentHashMap;

public class MessageManager {

    private static final ConcurrentHashMap<String, MessageServiceProvider> providerConcurrentHashMap = new ConcurrentHashMap<>();

    private static final String defaultProviderName = "defaultName";

    public static void registerDefaultProvider(MessageServiceProvider provider){
        registerProvider(defaultProviderName,provider);
    }

    public static void registerProvider(String name,MessageServiceProvider provider){
        providerConcurrentHashMap.put(name,provider);
    }

    public static MessageService defaltMessageServiceInstance(){
        return messageServiceInstance(defaultProviderName);
    }

    public static MessageService messageServiceInstance(String providerName){
        MessageServiceProvider provider = providerConcurrentHashMap.get(providerName);
        if (null != provider){
            return provider.getMessageServie();
        }else {
            throw new IllegalArgumentException("No provider registerd with name"+providerName);
        }
    }
}
