package com.shucheng.service.impl;

import com.shucheng.dao.BookDao;
import com.shucheng.dao.impl.BookDaoImpl;
import com.shucheng.pojo.Book;
import com.shucheng.pojo.Page;
import com.shucheng.service.BookService;

import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int updateBook(Book book) {

        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {

        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();


        page.setPageSize(pageSize);//设置每页的数量
        Integer pageTotalCount = bookDao.queryForPageTotalCount();//调用dao 求总记录数
        page.setPageTotalCount(pageTotalCount);//设置总记录数
        //求总页数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal ++;
        }
        if (pageNo<1){
            pageNo=1;
        }
        if (pageNo>pageTotal){
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);//设置当前页
        //设置总⻚数
        page.setPageTotal(pageTotal);

        //调用dao 求每页显示的数据
        int begin = (pageNo - 1) * pageSize;
        List<Book> books = bookDao.queryItems(begin, pageSize);
        page.setItems(books);//设置每页显示的数据
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();


        page.setPageSize(pageSize);//设置每页的数量
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);//调用dao 求总记录数
        page.setPageTotalCount(pageTotalCount);//设置总记录数
        //求总页数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal ++;
        }
        if (pageNo<1){
            pageNo=1;
        }
        if (pageNo>pageTotal){
            pageNo = pageTotal;
        }
        page.setPageNo(pageNo);//设置当前页
        //设置总⻚数
        page.setPageTotal(pageTotal);

        //调用dao 求每页显示的数据
        int begin = (pageNo - 1) * pageSize;
        List<Book> books = bookDao.queryItemsByPrice(begin, pageSize,min,max);
        page.setItems(books);//设置每页显示的数据
        return page;
    }
}
