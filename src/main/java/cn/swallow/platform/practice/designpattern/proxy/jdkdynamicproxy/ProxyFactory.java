package cn.swallow.platform.practice.designpattern.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理工厂,可以创建任何的代理对象
 * @author shenyu
 * @create 2019/3/30
 */
public class ProxyFactory {

    public static  <T> T getProxy(Object target, InvocationHandler invocationHandler){
         return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),invocationHandler);
    }


}
