package cn.swallow.platform.core.aop;

import cn.swallow.platform.config.datasource.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author shenyu
 * @create 2019/4/8
 */
@Aspect
@Order(-1)
@Component
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
        DataSourceHolder.read();
        logger.info("dataSource 切换到：Read");
    }

    @Before("writeDataSourcePointCut()")
    public void setWriteDataSourceType() {
        DataSourceHolder.write();
        logger.info("dataSource 切换到：Write");
    }


}
