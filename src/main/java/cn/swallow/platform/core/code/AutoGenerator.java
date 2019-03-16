package cn.swallow.platform.core.code;

import cn.swallow.platform.core.code.builder.ConfigBuilder;
import cn.swallow.platform.core.code.entity.GenerateInfo;
import cn.swallow.platform.core.code.generator.BeetlCodeGenerator;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author shenyu
 * @create 2019/3/16
 */
@Component
public class AutoGenerator {

    public void excute(GenerateInfo generateInfo){
        ConfigBuilder configBuilder = new ConfigBuilder(generateInfo);
        try {
            BeetlCodeGenerator generator = new BeetlCodeGenerator(configBuilder.buildGlobalConfig(),configBuilder.buildPackageConfig(),configBuilder.buildTemplateConfig(),configBuilder.buildFilePathConfig());
            generator.doGenerate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
