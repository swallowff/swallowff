package cn.swallow.platform.core.code.generator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

public interface MetaDataHandler {
    Connection connection = null;

    ResultSet queryMetaData(String tableName);

    Map<String,Object> wrapData(ResultSet resultSet,String className);
}
