package com.shucheng.service;

import com.shucheng.pojo.Book;
import com.shucheng.pojo.Page;

import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public interface BookService {
    public int addBook(Book book);

    public int updateBook(Book book);

    public int deleteBookById(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo,int pageSize);

    public Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max);
}
