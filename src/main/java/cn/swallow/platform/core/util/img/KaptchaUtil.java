package cn.swallow.platform.core.util.img;

import cn.swallow.platform.config.properties.SwallowProperties;
import cn.swallow.platform.core.util.context.SpringContextHolder;

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
