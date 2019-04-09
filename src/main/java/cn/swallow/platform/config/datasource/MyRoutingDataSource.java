package cn.swallow.platform.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author shenyu
 * @create 2019/4/8
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceHolder.getDataSourceType();
        // 写
        if (typeKey.equals(DataSourceType.WRITE.getType())) {
            return DataSourceType.WRITE.getType();
        }else {
            return DataSourceType.READ.getType();
        }
//        // 读简单负载均衡
//        int number = count.getAndAdd(1);
//        int lookupKey = number % dataSourceNumber;
//        return new Integer(lookupKey);
    }


}
