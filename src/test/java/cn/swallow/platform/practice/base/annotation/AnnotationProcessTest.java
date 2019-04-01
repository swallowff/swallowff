package cn.swallow.platform.practice.base.annotation;

import cn.swallow.platform.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AnnotationProcessTest {

    @Test
    public void test1(){
        AnnotationProcess.test();
    }
}