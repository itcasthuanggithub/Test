package com.shucheng.web;

import com.google.gson.Gson;
import com.shucheng.pojo.User;
import com.shucheng.service.UserService;
import com.shucheng.service.impl.UserServiceImpl;
import com.shucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Author 黄仔杰
 * @Date 2020/9/9 22:36
 * @Version 1.8
 */

@WebServlet(name = "UserServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();


    protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        //先获取请求
        String username = request.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        //把返回结果封装成map对象
        Map<String,Object> map = new HashMap<>();
        map.put("existUsername",existUsername);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/pages/client/index1.jsp");
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         String username = request.getParameter("username");
         String password = request.getParameter("password");

         User login = userService.login(username,password);

         if (login != null){
             //登陆成功
             //登陆成功 将用户名保存到session域中
             HttpSession session = request.getSession();
             session.setAttribute("user",login);

             request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
         }else {
             //将错误信息保存到request 域中
             request.setAttribute("errorMsg","用户名或密码错误！");
             //登陆失败
             System.out.println("用户名或密码错误！");
             request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
         }
     }

     protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取服务器端的验证码
         String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
         //立即销毁服务器端的验证码
         request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //1、先获取请求的参数
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         String code = request.getParameter("code");
            //简化上面的request.getParameter 方法，当有多个变量时
             //不用无休止地getParameter，此时因为代码一样，整合到WebBean中了
             try {
             //代码最少的写法
             User user = WebUtils.copyParamToBean(request,new User());
             System.out.println("注入之后："+user);
             //其他的比较容易理解的写法
            /* User user = new User();
             // System.out.println("注入之前"+user);
             WebUtils.copyParamToBean(request,user);
             //BeanUtils.populate(user, request.getParameterMap());
             // System.out.println("注入之后："+user);*/
         } catch (Exception e) {
             e.printStackTrace();
         }
         //2、调用Service 层处理业务
         //判读验证码是否正确
         if (token.equalsIgnoreCase(code)){
             //正确 判断用户名是否可用
             UserService userService = new UserServiceImpl();
             boolean existUsername = userService.existUsername(username);
             if (existUsername){
                 request.setAttribute("errorMsg","用户名已存在！");
                 request.setAttribute("username",username);
                 request.setAttribute("email",email);
                 System.out.println("用户名已存在！");
                 //不可用 跳回注册页面
                 request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
             }else {
                 //可用  调用service 保存用户
                 userService.regist(new User(null,username,password,email));

                 request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
             }
         }else {
             //保存错误信息到request域中
             request.setAttribute("errorMsg","验证码错误！");
             request.setAttribute("username",username);
             request.setAttribute("email",email);
             //不正确 跳转到注册页面
             System.out.println("验证码错误！");
             request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

         }
     }
}
