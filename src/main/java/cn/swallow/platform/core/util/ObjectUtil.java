package cn.swallow.platform.core.util;

/**
 * @author shenyu
 * @create 2019/5/9
 */
public class ObjectUtil {

    public static boolean isAllNull(Object... objs){
        for (Object o : objs){
            if (isNotNull(o)){return false;}
        }return true;
    }

    public static boolean isNull(Object obj){
        if (null == obj){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isNotNull(Object obj){
        return !isNull(obj);
    }
}
