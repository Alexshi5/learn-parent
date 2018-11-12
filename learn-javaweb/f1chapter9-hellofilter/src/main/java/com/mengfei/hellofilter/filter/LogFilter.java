package com.mengfei.hellofilter.filter;

import org.apache.commons.lang3.time.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * author Alex
 * date 2018/11/11
 * description 一个简单的日志过滤器
 */
public class LogFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //Instant是JDK8中的一个代表时间刻的类，参考：https://www.cnblogs.com/sbj-dawn/p/7439953.html
        //Instant now = Instant.now();
        LocalDateTime now = LocalDateTime.now();
        //StopWatch是lang3中一个任务执行时间监视器，参考：https://blog.csdn.net/u012191627/article/details/59484658
        StopWatch timer = new StopWatch();
        try {
            timer.start();
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            //将打印日志放到finally块中，这样即便出现异常也可以照样打印日志
            timer.stop();
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            String length = response.getHeader("Content-Length");
            if(null == length || length.length() == 0){
                length = "-";
            }
            System.out.println(
                    request.getRemoteAddr() + " - - [" + now + "]" + " \""
                    + request.getMethod() + " " + request.getRequestURI() + " "
                    + request.getProtocol() + "\" " + response.getStatus() + " "
                    + length + " " + timer

            );
        }
    }

    @Override
    public void destroy() {

    }
}
