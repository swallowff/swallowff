package cn.swallow.platform.core.util;

import cn.swallow.platform.config.properties.SwallowProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(SwallowProperties.class).getKaptchaOpen();
    }
}
