package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.core.code.AutoGenerator;
import cn.swallow.platform.core.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlCodeGeneratorTest {

    @Test
    public void doGenerate() {
        AutoGenerator autoGenerator = SpringContextHolder.getBean(AutoGenerator.class);
//        autoGenerator.excute();

    }
}