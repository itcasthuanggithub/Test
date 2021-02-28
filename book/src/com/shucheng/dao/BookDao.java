package com.shucheng.dao;


import com.shucheng.pojo.Book;

import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public interface BookDao {
    public int addBook(Book book);

    public int updateBook(Book book);

    public int deleteBookById(Integer id);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryItems(int min,int max);

    public Integer queryForPageTotalCountByPrice(int min,int max);

    public List<Book> queryItemsByPrice(int begin,int pageSize,int min,int max);


}
