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

import static java.lang.Integer.MAX_VALUE;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println("------------------------------");
        //1、获取请求参数  pageNo、pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、  调用service 获取page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3、将page对象保存到request域中
        request.getSession().setAttribute("url","client/bookServlet?action=page");
        request.setAttribute("page",page);
        //4、跳转到图书修改页面  /pages/manager/book_manager.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // System.out.println("------------------------------");
        //1、获取请求参数  pageNo、pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max = WebUtils.parseInt(request.getParameter("max"), MAX_VALUE);
        //2、  调用service 获取page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);

        //3、将page对象保存到request域中
        request.getSession().setAttribute("url","client/bookServlet?action=pageByPrice");
        request.getSession().setAttribute("min",min);
        request.getSession().setAttribute("max",max);
        request.setAttribute("page",page);
        //4、跳转到图书修改页面  /pages/manager/book_manager.jsp
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
