package cn.swallow.platform.core.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author shenyu
 * @create 2019/3/15
 */
public class SwallowErrorView implements View {
    @Override
    public String getContentType(){return "text/html";}

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        int status = httpServletResponse.getStatus();
        if (status == HttpStatus.NOT_FOUND.value()){
            httpServletRequest.getRequestDispatcher("/error/404").forward(httpServletRequest,httpServletResponse);
        }else{
            httpServletRequest.getRequestDispatcher("/error/500").forward(httpServletRequest, httpServletResponse);
        }

    }
}
