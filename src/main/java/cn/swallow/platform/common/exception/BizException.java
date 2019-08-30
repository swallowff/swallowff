package cn.swallow.platform.common.exception;

import cn.swallow.platform.common.exception.constant.BizExceptionEnum;

public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    public BizException(BizExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
