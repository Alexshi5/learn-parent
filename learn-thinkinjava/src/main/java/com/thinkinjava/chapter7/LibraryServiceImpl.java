package com.thinkinjava.chapter7;

/**
 * author Alex
 * date 2018/11/7
 * description 实现图书馆服务的接口，被代理类
 */
public class LibraryServiceImpl implements LibraryService{
    private int bookNum;

    LibraryServiceImpl(int bookNum){
        this.bookNum = bookNum;
        System.out.println("初始化被代理类，赋予其基本功能，图书馆现存图书：" + bookNum);
    }

    @Override
    public void addBook(String bookName) {
        System.out.println("增加图书：" + bookName + "，增加之后图书存量：" + ++bookNum);
    }

    @Override
    public void deleteBook(String bookName) {
        System.out.println("删除图书：" + bookName + "，删除之后图书存量：" + --bookNum);
    }
}
