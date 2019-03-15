package cn.swallow.platform.core.common.log.factory;

import cn.swallow.platform.core.common.log.LogManager;
import cn.swallow.platform.core.constant.state.LogSucceed;
import cn.swallow.platform.core.constant.state.LogType;
import cn.swallow.platform.core.util.CommonUtil;
import cn.swallow.platform.core.util.SpringContextHolder;
import cn.swallow.platform.modular.system.dao.LoginLogMapper;
import cn.swallow.platform.modular.system.dao.OperationLogMapper;
import cn.swallow.platform.modular.system.entity.LoginLog;
import cn.swallow.platform.modular.system.entity.OperationLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;


/**
 * @author shenyu
 * @create 2019/3/15
 */
public class LogTaskFactory {

    private static Logger logger = LoggerFactory.getLogger(LogManager.class);
    private static LoginLogMapper loginLogMapper = SpringContextHolder.getBean(LoginLogMapper.class);
    private static OperationLogMapper operationLogMapper = SpringContextHolder.getBean(OperationLogMapper.class);

    public static TimerTask loginLog(final Integer userId, final String ip){
        return new TimerTask() {
            @Override
            public void run() {
                try{
                    LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN,userId,null,ip);
                    loginLogMapper.insert(loginLog);
                }catch (Exception e){
                    logger.error("创建登录日志异常");
                }
            }
        };
    }

    public static TimerTask loginLog(final String username, final String msg, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(
                        LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建登录失败异常!", e);
                }
            }
        };
    }

    public static TimerTask exitLog(final Integer userId, final String ip) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, ip);
                try {
                    loginLogMapper.insert(loginLog);
                } catch (Exception e) {
                    logger.error("创建退出日志异常!", e);
                }
            }
        };
    }

    public static TimerTask bussinessLog(final Integer userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
        return new TimerTask() {
            @Override
            public void run() {
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建业务日志异常!", e);
                }
            }
        };
    }

    public static TimerTask exceptionLog(final Integer userId, final Exception exception) {
        return new TimerTask() {
            @Override
            public void run() {
                String msg = CommonUtil.getExceptionMsg(exception);
                OperationLog operationLog = LogFactory.createOperationLog(
                        LogType.EXCEPTION, userId, "", null, null, msg, LogSucceed.FAIL);
                try {
                    operationLogMapper.insert(operationLog);
                } catch (Exception e) {
                    logger.error("创建异常日志异常!", e);
                }
            }
        };
    }
}