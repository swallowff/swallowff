package cn.swallow.platform.core.common.controller;

import cn.swallow.platform.core.common.resp.BaseResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public abstract class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Boolean validateBindingResult(BindingResult bindingResult, BaseResp baseResp){
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : errors){
                sb.append(error.getDefaultMessage());
                sb.append(";");
            }
            baseResp.error();
            baseResp.setMessage(sb.toString());
            return false;
        }else return true;
    }
}
