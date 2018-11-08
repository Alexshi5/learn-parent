package com.thinkinjava.chapter7;

/**
 * author Alex
 * date 2018/11/7
 * description 图书馆服务的接口
 */
public interface LibraryService {

    /**
     * 增加图书
     * @param bookName
     */
    void addBook(String bookName);

    /**
     * 删除图书
     * @param bookName
     */
    void deleteBook(String bookName);
}
