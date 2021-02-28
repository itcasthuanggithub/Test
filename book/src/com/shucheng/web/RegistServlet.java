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

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1、先获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        //2、调用Service 层处理业务
        //判读验证码是否正确
        if ("abcdef".equalsIgnoreCase(code)){
            //正确 判断用户名是否可用
            UserService userService = new UserServiceImpl();
            boolean existUseername = userService.existUsername(username);
            if (existUseername){
                System.out.println("用户名已存在！");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                //可用  调用service 保存用户
                userService.regist(new User(null,username,password,email));

                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
            //不可用 跳回注册页面
        }else {
            //不正确 跳转到注册页面
            System.out.println("验证码错误！");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

        }

        //不可用  跳转到注册页面

        //3、根据Service 层的结果对应处理
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
