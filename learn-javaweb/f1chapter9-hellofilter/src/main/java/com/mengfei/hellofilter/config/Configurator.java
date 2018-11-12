package com.mengfei.hellofilter.config;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * author Alex
 * date 2018/11/6
 * description 演示过滤器的编程式配置
 */
@WebListener
public class Configurator implements ServletContextListener{
    /*@Override
    public void contextInitialized(ServletContextEvent event) {
        //获取正在启动的Servlet容器
        ServletContext context = event.getServletContext();

        //在容器中添加过滤器，动态返回该过滤器的登记表
        FilterRegistration.Dynamic registration = context.addFilter("myFilter", new MyFilter());

        //在登记表中添加URL映射信息
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.ASYNC),
                false,"/do/*","/bur");

        //在登记表中添加过滤的Servlet
        registration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST,DispatcherType.ASYNC),
                false,"myServlet");
    }*/
}
