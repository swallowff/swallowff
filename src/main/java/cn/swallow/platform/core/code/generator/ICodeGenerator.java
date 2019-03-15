package cn.swallow.platform.core.code.generator;

import org.beetl.core.GroupTemplate;

import java.io.File;
import java.util.Map;

public interface ICodeGenerator {
    File outPutFile = null;

    //初始化
    void init(File outPutFile);

    boolean doGenerate(Map<String,Object> dataMap, GroupTemplate template);

    void destroy(File outPutFile);

}
