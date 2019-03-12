package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.SwallowffApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SwallowffApplication.class)
public class CodeGeneratorTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGenerate(){
        String tableName = "test_table";
        String targetPackage = "modular.manage.entity";
        CodeGenerator codeGenerator = new CodeGenerator(tableName);
        try {
            codeGenerator.generate(targetPackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilePath(){
        String path = new File("").getPath();
        String realPath = new File("").getAbsolutePath();
        String pathSeparator = File.pathSeparator;
        String separator = File.separator;
        String classPath = this.getClass().getClassLoader().getResource("").getPath();
        String basePackage = SwallowffApplication.class.getPackage().getName();
        logger.info("path: [{}]",path);
        logger.info("realPath: [{}]",realPath);
        logger.info("pathSeparator: [{}]",pathSeparator);
        logger.info("separator: [{}]",separator);
        logger.info("diskPath: [{}]",classPath);
        logger.info("basePackage: [{}]",basePackage);
    }

}