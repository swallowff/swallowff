package cn.swallow.platform.util;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.File;

@SpringBootTest
public class FilePathTest {

    @Test
    public void fileTest() throws Exception{
        String path = "src/main/demo";
        File file = new File(path);

        if (!file.exists()){
            file.mkdir();
        }else {
            new File(path+"/test.txt").createNewFile();
        }

        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void pathTest() throws Exception{
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        String path = resourceLoader.getResource("/cn").getFile().getAbsolutePath();
        System.out.println(path);
    }
}
