package cn.swallow.platform.core.code.generator;

import java.io.File;

public class GenerateUtil {


    public static String convertPackageToPath(String packageName){
        String[] strs = packageName.split("\\u002E");
        if (strs.length == 1){
            return File.separator + packageName + File.separator;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(File.separator).append(s);
        }
        sb.append(File.separator);
        return sb.toString();

    }
}
