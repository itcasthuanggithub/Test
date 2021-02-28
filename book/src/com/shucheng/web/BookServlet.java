package com.shucheng.web;

import com.shucheng.pojo.Book;
import com.shucheng.pojo.Page;
import com.shucheng.service.BookService;
import com.shucheng.service.impl.BookServiceImpl;
import com.shucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class BookServlet extends BaseServlet{
         private BookService bookService =new BookServiceImpl();
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");

        //1、查询所有图书信息
        List<Book> books = bookService.queryBooks();
        //2、将查询到的所有图书存到request域中
        request.setAttribute("books",books);
        //3、跳转到图书列表页面 /pages/manager/book_manager.jsp  "/pages前的/相当于http://localhost:8080/book"
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取所有请求参数，封装JavaBean
        Book book = new WebUtils().copyParamToBean(request,new Book());
        int pageTotal = WebUtils.parseInt(request.getParameter("pageTotal"),0);
        pageTotal+=1;
        //2、调用Service 保存图书
        bookService.addBook(book);
        //3、跳转到图书列表页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageTotal);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数  id
        String strId = request.getParameter("id");
        //2、调用service 删除图书
        bookService.deleteBookById(WebUtils.parseInt(strId,0));
        //3、跳转到图书列表页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数，封装JavaBean
        Book book = WebUtils.copyParamToBean(request,new Book());
        //2、调用service 更新图书
        bookService.updateBook(book);
        //3、跳转到图书信息列表页面
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取请求参数  id
        String strId = request.getParameter("id");
        //2、根据id  调用service 查询图书信息
        Book book = bookService.queryBookById(WebUtils.parseInt(strId,0));
        System.out.println();
        //3、将查询到的图书保存到request域中
        request.setAttribute("book",book);
        //4、跳转到图书修改页面  /pages/manager/book_edit.jsp
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取请求参数  pageNo、pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、  调用service 获取page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3、将page对象保存到request域中
        request.setAttribute("page",page);
        //4、跳转到图书修改页面  /pages/manager/book_manager.jsp
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
