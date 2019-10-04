package cn.swallow.platform.practice.designpattern.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shenyu
 * @create 2019/3/30
 */
public class StartMain {

    public static void main(String[] args){
        Person person = new RealPerson();
        /**
         * 第一种:自己封装代理工厂
         */
        Person proxyPerson0 = ProxyFactory.getProxy(person,new ProxyPerson(person));
        /**
         * 第二种:直接使用Proxy获取代理
         */
        Person proxyPerson1 = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),person.getClass().getInterfaces(),new ProxyPerson(person));
        /**
         * 第三种:通过匿名内部类获取代理
         */
        Person proxyPerson2 = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("3333");
                Object result = method.invoke(person,args);
                System.out.println("3333");
                return result;
            }
        }) ;
        proxyPerson0.say();
        proxyPerson1.say();
        proxyPerson2.say();
    }


}
