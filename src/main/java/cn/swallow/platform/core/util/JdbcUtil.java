package cn.swallow.platform.core.util;

import cn.swallow.platform.config.datasource.MyRoutingDataSource;
import cn.swallow.platform.core.util.context.SpringContextHolder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class JdbcUtil {

    public static Connection getConnection() throws SQLException {
        MyRoutingDataSource dataSource = SpringContextHolder.getBean(MyRoutingDataSource.class);
        return dataSource.getConnection();
    }

    public static JdbcTemplate getJdbcTemplate(Boolean lazyInit){
        MyRoutingDataSource dataSource = SpringContextHolder.getBean(MyRoutingDataSource.class);
        return new JdbcTemplate(dataSource,lazyInit);
    }
}
