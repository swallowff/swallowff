package cn.swallow.platform.core.code.generator;

import cn.swallow.platform.core.code.AutoGenerator;
import cn.swallow.platform.core.code.entity.GenerateInfo;
import cn.swallow.platform.core.util.context.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoGeneratorTest {

    @Test
    public void excute() {
        GenerateInfo generateInfo = new GenerateInfo();
        generateInfo.setAuthor("shenyu");
        generateInfo.setModule("manage.blog");
        generateInfo.setClassName("GoodsOrder");
        generateInfo.setTable("test_table");
        generateInfo.setGenEntity(true);
        generateInfo.setFileOverride(true);

        AutoGenerator autoGenerator = SpringContextHolder.getBean(AutoGenerator.class);
        autoGenerator.excute(generateInfo);
    }
}