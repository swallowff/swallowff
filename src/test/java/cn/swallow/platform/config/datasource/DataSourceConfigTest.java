package cn.swallow.platform.config.datasource;

import cn.swallow.platform.core.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTest {

    @Test
    public void dynamicDatasourceTest() throws Exception{
        DataSource readDatasource = SpringContextHolder.getBean(DataSource.class);
        System.out.println(readDatasource.getConnection());
    }

}