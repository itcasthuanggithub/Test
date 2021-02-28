package com.shucheng.web;

import com.shucheng.pojo.User;
import com.shucheng.service.UserService;
import com.shucheng.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User login = userService.login(username,password);

        if (login != null){
            //登陆成功
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }else {
            //登陆失败
            System.out.println("用户名或密码错误！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
