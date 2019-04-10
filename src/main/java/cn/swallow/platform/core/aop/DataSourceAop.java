package cn.swallow.platform.core.aop;

import cn.swallow.platform.config.datasource.DataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切换Aop
 * @author shenyu
 * @create 2019/4/8
 */
@Aspect
@Order(-1)
@Component
@ConditionalOnProperty(prefix = "swallow.muti-datasource",name = "open",havingValue = "true")
public class DataSourceAop {
    private static Logger logger = LoggerFactory.getLogger(DataSourceAop.class);

    @Pointcut("execution(* cn.swallow.platform..dao..*.select*(..)) || " +
            "execution(* cn.swallow.platform..dao..*.get*(..)) || " +
            "execution(* cn.swallow.platform..dao..*.query*(..)) || " +
            "execution(* cn.swallow.platform..dao..*.find*(..))")
    public void readDataSourcePointCut(){}

    @Pointcut("execution(* cn.swallow.platform.modular..dao..*.insert*(..)) || " +
            "execution(* cn.swallow.platform.modular..dao..*.update*(..)) || " +
            "execution(* cn.swallow.platform.modular..dao..*.delete*(..))")
    public void writeDataSourcePointCut(){}

    @Before("readDataSourcePointCut()")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        logger.info("切换到：ReadDataSource");
    }

    @Before("writeDataSourcePointCut()")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        logger.info("切换到：WriteDataSource");
    }


}
