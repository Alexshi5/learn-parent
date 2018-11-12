package com.mengfei.hellofilter.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * author Alex
 * date 2018/11/11
 * description 演示过滤器排序所需要的过滤器三
 */
public class FilterThree implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("请求到达过滤三");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
