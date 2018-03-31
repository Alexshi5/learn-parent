package f1.chapter3.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//请求url为http://localhost:8080/getting?name=alex&name=zhangsan&age=25
        String name = req.getParameter("name");//当参数有多个值时只返回第一个值
        System.out.println(name);//alex

        String[] names = req.getParameterValues("name");//返回参数值的数组
        System.out.println(names[0] + "==" + names[1]);//alex==zhangsan

        Map map = req.getParameterMap();//返回参数和值的key-value
        String[] s = (String[]) map.get("name");//alex==zhangsan
        System.out.println(s[0] + "==" + s[1]);

        Enumeration names1 = req.getParameterNames();//返回参数名字的枚举
        Object o1 = names1.nextElement();
        Object o2 = names1.nextElement();
        System.out.println(o1 + "==" + o2);//name==age

        resp.getWriter().print("Hello World");*/

        String name = req.getParameter("name");
        resp.setContentType("application/json;charset=utf-8");
        //resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("你好" + name);//你好alex
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//请求内容为age=8，请求类型为post，Request Body为Empty
        String contentType = req.getContentType();//返回请求的MIME内容类型（多用途互联网邮件扩展）
        System.out.println(contentType);//application/x-www-form-urlencoded; charset=GBK

        int length = req.getContentLength();//返回请求正文的长度，以字节为单位
        System.out.println(length);//5

        String encoding = req.getCharacterEncoding();//返回请求内容的字符编码
        System.out.println(encoding);//GBK*/

        //请求内容为zhangsan，请求类型为post，Request Body为Text
        String contentType = req.getContentType();//返回请求的MIME内容类型（多用途互联网邮件扩展）
        System.out.println(contentType);//*/*; charset=UTF-8

        int length = req.getContentLength();//返回请求正文的长度，以字节为单位
        System.out.println(length);//8

        String encoding = req.getCharacterEncoding();//返回请求内容的字符编码
        System.out.println(encoding);//UTF-8

        BufferedReader reader = req.getReader();
        StringBuffer buffer = new StringBuffer();
        char[] c = new char[100];
        int len = 0;
        while ((len = reader.read(c)) != -1) {
            buffer.append(c, 0, len);
        }
        System.out.println(buffer.toString());//zhangsan

        //post请求
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);//http://localhost:8080/getting

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);///getting

        String servletPath = req.getServletPath();
        System.out.println(servletPath);///getting

        String contenttype = req.getHeader("contenttype");
        System.out.println(contentType);//*/*; charset=UTF-8


        /*ServletInputStream inputStream = req.getInputStream();*/

        resp.getWriter().print("Hello World");
    }

    @Override
    public void init() throws ServletException {
        System.out.println(this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println(this.getServletName() + " has stopped");
    }
}
