package cn.swallow.platform.practice.common.factory;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonFactory {
    @SuppressWarnings("rawtypes")
    private static Map<Class,Object> instaces = new ConcurrentHashMap<Class, Object>();
    @SuppressWarnings("rawtypes")
    private static Map<Class, WeakReference<Object>> weakReferenceInstaces = new ConcurrentHashMap<Class, WeakReference<Object>>();

    /**
     * 创建可不被回收的单例模式,当没有对象引用，单例对象将被gc掉
     * @param className
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public static <E> E getInstace(Class<E> className){
        Object instace =instaces.get(className);
        if(instace==null){
            synchronized (SingletonFactory.class) {
                instace =instaces.get(className);
                if(instace==null){
                    try {
                        instace = className.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    instaces.put(className,instace);
                }
            }
        }
        return (E)instace;
    }

    /**
     * 创建可回收的单例模式,当没有对象引用，单例对象将被gc掉
     *
     * @param className
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public static <E> E getWeakInstace(Class<E> className) {
        WeakReference<Object> reference = weakReferenceInstaces.get(className);
        Object instace =reference==null?null:reference.get();
        if(instace==null){
            synchronized (SingletonFactory.class) {
                reference = weakReferenceInstaces.get(className);
                instace =reference==null?null:reference.get();
                if(instace==null){
                    try {
                        instace = className.newInstance();
                    } catch (InstantiationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    weakReferenceInstaces.put(className,new WeakReference<Object>(instace));
                }
            }
        }
        return (E)instace;
    }

}