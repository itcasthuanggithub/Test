package com.shucheng.web;

import com.shucheng.pojo.Cart;
import com.shucheng.pojo.User;
import com.shucheng.service.OrderService;
import com.shucheng.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 黄仔杰
 * @Date 2020/9/11 1:47
 * @Version 1.8
 */

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();
    //生成的订单
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //再获取userId
        User login = (User) request.getSession().getAttribute("user");
        if (login == null) {
            //跳转到登陆页面
            request.getRequestDispatcher("pages/user/login.jsp").forward(request,response);
            return;
        }
        //调用 service 成成订单
        String orderId = orderService.saveOrder(cart,login.getId());
        //保存订单
        //request.setAttribute("orderId",orderId);
        request.getSession().setAttribute("orderId",orderId);
        //跳转
        //request.getRequestDispatcher("pages/cart/checkout.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
    //查询所有订单（管理员）

    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有订单
       // List<Order> orders = orderService.queryOrders();
       // Order order = (Order) request.getSession().getAttribute("order");


    }
}
