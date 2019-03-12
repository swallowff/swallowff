package cn.swallow.platform.core.code.config;

import cn.swallow.platform.config.properties.SwallowProperties;

import java.io.File;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class CodeGenConfig {
    public static final String file_separater = File.separator;
    public static final String java_suffix = ".java";
    public static final String html_suffix = ".html";
    public static String ROOT_PATH = SwallowProperties.ROOT_PATH;


    public String getTargetPath(String targetPackage){


        return "";
    }

    public enum TplFile{
        MAPPER("Mapper.ftl"),DAO("Dao.ftl"),Service("Service.ftl"),Controller("Controller.ftl"),Entity("Entity.ftl"),Dto("Dto.ftl");

        private String name;

        TplFile(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum PackageName{
        dao("dao"),service("service"),controller("controller"),entity("entity"),mapper("mapper");

        private String name;

        PackageName(String name) {
            this.name = name;
        }
    }

}
