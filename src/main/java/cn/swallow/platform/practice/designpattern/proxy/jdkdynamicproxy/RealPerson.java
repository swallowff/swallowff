package cn.swallow.platform.practice.designpattern.proxy.jdkdynamicproxy;

/**
 * 被代理对象
 * @author shenyu
 * @create 2019/3/30
 */
public class RealPerson implements Person {

    public void say(){
        System.out.println("A说:感觉最近好累啊");
    }
}
