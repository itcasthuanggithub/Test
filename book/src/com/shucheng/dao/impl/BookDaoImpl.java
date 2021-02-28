package com.shucheng.dao.impl;

import com.shucheng.dao.BaseDao;
import com.shucheng.dao.BookDao;
import com.shucheng.pojo.Book;

import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,
                book.getName(),
                book.getPrice(),
                book.getAuthor(),
                book.getSales(),
                book.getStock(),
                book.getImg_path());

    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book where id=?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number = (Number) queryForSingleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryItems(int begin, int pageSize) {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSingleValue(sql,min,max);
        return number.intValue();
    }

    @Override
    public List<Book> queryItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,price,author,sales,stock,img_path from t_book where price between ? and ? order by price limit ?,?";

        return queryForList(Book.class,sql,min,max,begin,pageSize);//参数必须要跟上面的问号（？）一 一对应
    }

}