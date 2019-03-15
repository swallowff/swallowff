package cn.swallow.platform.core.common.resp;

import cn.swallow.platform.core.constant.state.AbstractState;
import cn.swallow.platform.core.constant.state.ResponseState;
import cn.swallow.platform.core.util.GsonHelper;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class BaseResp implements Serializable {
    private static final Integer SUCCESS = 200;

    private Integer code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Serializable data;

    public BaseResp (Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public BaseResp (ResponseState respResponseState){
        this.code = respResponseState.getCode();
        this.message = respResponseState.getMsg();
    }

    public BaseResp putState(AbstractState respState){
        this.code = respState.getCode();
        this.message = respState.getMsg();
        return this;
    }

    public BaseResp emptyData(){
        return putState(ResponseState.EMPTY_DATA);
    }

    public BaseResp error(){
        return putState(ResponseState.SYSTEM_ERROR);
    }

    public BaseResp success(){
        return putState(ResponseState.SUCCESS);
    }

    public static BaseResp newSuccess(){
        return new BaseResp(ResponseState.SUCCESS);
    }

    public boolean isSuccess(){
        return SUCCESS == this.getCode();
    }

    public static BaseResp newError(){
        return new BaseResp(ResponseState.SYSTEM_ERROR);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Serializable getData() {
        return data;
    }

    public BaseResp setData(Serializable data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return GsonHelper.toJson(this);
    }
}
