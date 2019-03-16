package cn.swallow.platform.core.code;

import cn.swallow.platform.core.util.JdbcUtil;
import cn.swallow.platform.core.util.SpringContextHolder;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 查询数据库所有表的信息
 * @author shenyu
 * @create 2019/3/16
 */
@Service
public class TableSchemaService {
    @Value("${spring.datasource.db-name}")
    private String dbName;

    public TableSchemaService(){}

    public List<Map<String,Object>> getAllTables(){
        String sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + this.dbName + "'";

        JdbcTemplate jdbcTemplate = JdbcUtil.getJdbcTemplate(true);
        List<Map<String,Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }
}
