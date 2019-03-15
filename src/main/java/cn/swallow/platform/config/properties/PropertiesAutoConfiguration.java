package cn.swallow.platform.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 加载properties文件
 * @author shenyu
 * @create 2019/3/15
 */
@Configuration
@PropertySource({"classpath:/default-config.properties"})
public class PropertiesAutoConfiguration {
    public PropertiesAutoConfiguration() {
    }


}