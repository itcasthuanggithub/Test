<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/4
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<img class="logo_img" alt="" src="static/img/logo.gif" >
<span class="wel_word"></span>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="pages/client/index1.jsp">返回</a>
</div>
