package com.thinkinjava.chapter7;

/**
 * author Alex
 * date 2018/11/7
 * description 实现图书馆服务接口，代理类
 */
public class LibraryServiceProxy implements LibraryService{
    private LibraryServiceImpl libraryService;

    LibraryServiceProxy(LibraryServiceImpl libraryService){
        this.libraryService = libraryService;
        System.out.println("初始化代理类，代理图书馆实现类，增强其功能或隐藏其细节");
    }

    @Override
    public void addBook(String bookName) {
        System.out.println("新增之前...");
        libraryService.addBook(bookName);
        System.out.println("新增之后...");
    }

    @Override
    public void deleteBook(String bookName) {
        System.out.println("删除之前...");
        libraryService.deleteBook(bookName);
        System.out.println("删除之后...");
    }
}
