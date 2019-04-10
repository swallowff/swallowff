package cn.swallow.platform.core.code;

import cn.swallow.platform.Application;
import cn.swallow.platform.core.util.GsonHelper;
import cn.swallow.platform.core.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TableSchemaServiceTest {

    @Test
    public void getAllTables() {
        TableSchemaService tableService = SpringContextHolder.getBean(TableSchemaService.class);
        List<Map<String,Object>> result = tableService.getAllTables();
        System.out.println(GsonHelper.toJson(result));
    }



}