package com.mengfei.hellofilter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * author Alex
 * date 2018/11/5
 * description 创建的第一个用于演示的Filter
 */
@WebFilter(
        filterName = "myFilter",
        urlPatterns = {"/do/*","/bur"},
        servletNames = {"myServlet"},
        dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.ASYNC}
)
public class MyFilter implements Filter {
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
