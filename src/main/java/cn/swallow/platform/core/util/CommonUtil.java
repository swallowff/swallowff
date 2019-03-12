package cn.swallow.platform.core.util;

import java.io.File;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class CommonUtil {

    public static String packageToPath(String var1){
        if (null != var1){
            var1 = File.separator+var1.replace("\u002E",File.separator);
        }
        return var1;
    }
}
