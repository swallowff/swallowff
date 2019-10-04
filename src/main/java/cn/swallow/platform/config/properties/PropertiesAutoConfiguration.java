package cn.swallow.platform.config.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 加载自定义的properties文件
 * @author shenyu
 * @create 2019/3/15
 */
@Configuration
@PropertySource({"classpath:/default-config.properties"})
public class PropertiesAutoConfiguration {
    @Autowired
    private Environment environment;

    public PropertiesAutoConfiguration() {
    }


}
