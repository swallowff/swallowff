package cn.swallow.platform.practice.lang;

/**
 * @author shenyu
 * @create 2019/3/29
 */
public class SelfApplicationContext implements SwallowContext{

    @Override
    public <T> T getBean(Class<T> type) {
        return null;
    }

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public boolean containsBean(String var1) {
        return false;
    }
}
