package com.shucheng.web;

import com.shucheng.pojo.Book;
import com.shucheng.pojo.Cart;
import com.shucheng.pojo.CartItem;
import com.shucheng.service.BookService;
import com.shucheng.service.impl.BookServiceImpl;
import com.shucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 黄仔杰
 * @Date 2020/9/10 11:13
 * @Version 1.8
 */

public class CartServlet extends BaseServlet{

        BookService bookService = new BookServiceImpl();


    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        int count = WebUtils.parseInt(request.getParameter("count"),1);
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id,count);
            //重定向到原来的页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            request.getSession().setAttribute("cart",cart);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求 id
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        //获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            request.getSession().setAttribute("cart",cart);
            //重定到向原来的页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数 商品Id
       int id = WebUtils.parseInt(request.getParameter("id"),0);
        //调用service 查询所有图书信息
        Book book = bookService.queryBookById(id);
        //将book 转换为 CartItem
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //将CartItem 添加到购物车对象中
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
       cart.addItem(cartItem);
        //记录最后一次添加是书名
        request.getSession().setAttribute("lastName",cartItem.getName());
        //重定向
        response.sendRedirect("pages/client/index1.jsp");
    }
}
