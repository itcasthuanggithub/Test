<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员注册页面</title>
	<%--静态包含 base css JQuery等--%>
	<%@ include file="/pages/comment/header.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.gif" >
			<%--静态包含欢迎信息--%>
			<%@ include file="/pages/comment/success_menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>欢迎回来 <a href="pages/client/index1.jsp">转到主页</a></h1>
	
		</div>
		<%--静态包含列表--%>
		<%@ include file="/pages/comment/footer.jsp"%>
</body>
</html>