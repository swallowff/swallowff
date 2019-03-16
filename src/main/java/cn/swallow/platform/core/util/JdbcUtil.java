package cn.swallow.platform.core.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author shenyu
 * @create 2019/3/12
 */
public class JdbcUtil {

    public static Connection getConnection() throws SQLException {
        DruidDataSource dataSource = SpringContextHolder.getBean(DruidDataSource.class);
        return dataSource.getConnection();
    }

    public static JdbcTemplate getJdbcTemplate(Boolean lazyInit){
        DruidDataSource dataSource = SpringContextHolder.getBean(DruidDataSource.class);
        return new JdbcTemplate(dataSource,lazyInit);
    }
}
