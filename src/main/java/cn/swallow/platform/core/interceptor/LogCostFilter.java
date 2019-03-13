package cn.swallow.platform.core.interceptor;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author shenyu
 * @create 2019/3/13
 */
//@WebFilter(urlPatterns = "/*", filterName = "logFilter2")
public class LogCostFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
