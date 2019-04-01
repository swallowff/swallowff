package cn.swallow.platform.practice.designpattern.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义了代理对象的行为
 * @author shenyu
 * @create 2019/3/30
 */
public class ProxyPerson implements InvocationHandler {
    private Object target;

    public ProxyPerson(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("B说");
        Object result = method.invoke(target,args);
        System.out.println("C说");
        return result;
    }
}
