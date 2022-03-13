package com.xxxx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
/*     拦截路径   所有的请求资源*/

public class Filter02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02 init....");
    }

    @Override
    public void destroy() {
        System.out.println("Filter02 destroy....");
    }

/**
     * 过滤方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter02 正在拦截......");
            //  放行资源
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
