package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.SwallowffApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SwallowffApplication.class)
public class CodeGeneratorTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGenerate(){
        String tableName = "test_table";
        String targetPackage = "cn.swallow.platform.modular.manage";
        String className = "Article";
        CodeGenerator codeGenerator = new CodeGenerator(tableName,targetPackage,className);
        try {
            codeGenerator.generate();
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
//        String classPath = new CodeGenerator("","").getClass().getResource("").getPath();
        String basePackage = SwallowffApplication.class.getPackage().getName();
        logger.info("path: [{}]",path);
        logger.info("realPath: [{}]",realPath);
        logger.info("pathSeparator: [{}]",pathSeparator);
        logger.info("separator: [{}]",separator);
//        logger.info("diskPath: [{}]",classPath);
        logger.info("basePackage: [{}]",basePackage);
    }

    @Test
    public void filePathTest() throws Exception{
        String fileName = "test.txt";
        File file2 = new DefaultResourceLoader().getResource("").getFile();
        logger.info(file2.getAbsolutePath());
        File file = new File("classpath:"+fileName);
        logger.info(file.getAbsolutePath());
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}