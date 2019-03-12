package cn.swallow.platform.core.code.config;

import cn.swallow.platform.SwallowffApplication;
import cn.swallow.platform.config.properties.SwallowProperties;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;
import java.io.IOException;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class CodeGenConfig {
    public static final String java_suffix = ".java";
    public static final String html_suffix = ".html";
    public static String PROJECT_PATH = SwallowProperties.PROJECT_PATH;
    public static String basePackage = SwallowffApplication.class.getPackage().getName();
    public static String author = "shenyu";


    public static String getTargetPath2(String targetPackage,CodeGenType genType){
        StringBuilder sb = new StringBuilder();
        sb.append(PROJECT_PATH).append(File.separator).append("src").append(File.separator).append("main")
                .append(File.separator).append("java").append(File.separator).append(convertPackageToPath(targetPackage)).append(File.separator).append(genType.packageName);
        return sb.toString();
//        PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator
    }

    public static String getTargetPath(String targetPackage,CodeGenType genType){
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        String resourcePath = "";
        try {
            resourcePath = resourceLoader.getResource("/").getFile().getAbsolutePath();
            if (genType == CodeGenType.MAPPER){
                return resourcePath + File.separator + "mapper" + File.separator + "system" + File.separator;
            }else {
                return resourcePath + convertPackageToPath(targetPackage) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String getTplFilePath(CodeGenType type){
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        String path = "";
        try {
            File file =  resourceLoader.getResource("").getFile();
            path = file.getAbsolutePath() + File.separator + "WEB-INF" + File.separator + "view" + File.separator + "templates" + File.separator + "gencode" + File.separator + type.tplFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String convertPackageToPath(String packagePath){
        String[] strs = packagePath.split("\\u002E");
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

    public enum CodeGenType{
        MAPPER("Mapper.ftl",""),
        DAO("Dao.ftl","dao"),
        Service("Service.ftl","service"),
        Controller("Controller.ftl","controller"),
        Entity("Entity.ftl","entity"),
        Dto("Dto.ftl","dto");

        private String tplFileName;
        private String packageName;

        CodeGenType(String tplFileName, String packageName) {
            this.tplFileName = tplFileName;
            this.packageName = packageName;
        }

        public String getTplFileName() {
            return tplFileName;
        }

        public String getPackageName() {
            return packageName;
        }

    }

}
