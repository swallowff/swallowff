package cn.swallow.platform.practice.lang;

/**
 * @author shenyu
 * @create 2019/3/29
 */
public interface SwallowContext {

    <T> T getBean(Class<T> type);

    Object getBean(String name);

    boolean containsBean(String var1);
}
