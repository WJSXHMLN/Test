package com.xxxx.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
*       过滤器
*           1.@WebFilter("/s01")  配置拦截的路径
*           2.doFilter()  需要设置放行  filterChain.doFilter(servletRequest,servletResponse)  否则请求无法到达资源
*           3.如果是过滤器链，先配置的先执行
* */

@WebFilter("/s01")  /*拦截路径是s01的资源*/
public class Filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter01 init....");
    }

    @Override
    public void destroy() {
        System.out.println("Filter01 destroy....");
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
        System.out.println("Filter01 正在拦截......");
            //  放行资源
            filterChain.doFilter(servletRequest,servletResponse);

    }
}
