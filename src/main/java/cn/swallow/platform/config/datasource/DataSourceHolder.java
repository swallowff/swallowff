package cn.swallow.platform.config.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shenyu
 * @create 2019/4/8
 */
public class DataSourceHolder {
    private static Logger logger = LoggerFactory.getLogger(DataSourceHolder.class);

    // 数据源名称线程池
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {
        logger.debug("读操作-----");
        local.set(DataSourceType.READ.getType());
    }

    /**
     * 写只有一个库
     */
    public static void write() {
        logger.debug("写操作-----");
        local.set(DataSourceType.WRITE.getType());
    }

    public static String getDataSourceType() {
        return local.get();
    }
}
