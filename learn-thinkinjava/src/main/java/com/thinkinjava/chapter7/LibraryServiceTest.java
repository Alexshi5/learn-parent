package com.thinkinjava.chapter7;

/**
 * author Alex
 * date 2018/11/7
 * description 测试图书馆服务的类
 */
public class LibraryServiceTest {
    public static void main(String[] args) {
        LibraryServiceImpl libraryService = new LibraryServiceImpl(1000);
        LibraryServiceProxy proxy = new LibraryServiceProxy(libraryService);

        proxy.addBook("《围城》");
        proxy.deleteBook("《红楼梦》");
        //打印结果如下：
        //初始化被代理类，赋予其基本功能，图书馆现存图书：1000
        //初始化代理类，代理图书馆实现类，增强其功能或隐藏其细节
        //新增之前...
        //增加图书：《围城》，增加之后图书存量：1001
        //新增之后...
        //删除之前...
        //删除图书：《红楼梦》，删除之后图书存量：1000
        //删除之后...
    }
}
