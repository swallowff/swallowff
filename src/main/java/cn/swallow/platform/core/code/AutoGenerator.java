package cn.swallow.platform.core.code;

import cn.swallow.platform.core.code.builder.GeneratorConfigManagerBuilder;
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
        BeetlCodeGenerator generator = new BeetlCodeGenerator(new GeneratorConfigManagerBuilder(generateInfo).create());
        generator.doGenerate();

    }
}
