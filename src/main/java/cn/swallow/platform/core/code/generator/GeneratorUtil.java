package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.config.properties.SwallowProperties;
import cn.swallow.platform.core.code.CodeGenConfig;

import java.io.File;
import java.util.zip.DataFormatException;

public class GeneratorUtil {

    public static String getTargetPath(String targetPackage, CodeGenConfig.CodeGenType genType){
        StringBuilder sb = new StringBuilder();
        sb.append(SwallowProperties.PROJECT_PATH).append(File.separator).append("src").append(File.separator).append("main")
                .append(File.separator).append("java").append(File.separator).append(convertPackageToPath(targetPackage)).append(File.separator).append(genType.getPackageName());
        return sb.toString();
    }

    public static String convertPackageToPath(String packagePath) throws RuntimeException {
        String[] strs = packagePath.split("\\u002E");
        if (strs.length <= 0){
            throw new RuntimeException("传入的包名有误");
        }else {
            if (strs.length == 1){
                return File.separator + packagePath + File.separator;
            }
            StringBuilder sb = new StringBuilder();
            for (String s : strs){
                sb.append(File.separator).append(s);
            }
            sb.append(File.separator);
            return sb.toString();
        }


    }
}
