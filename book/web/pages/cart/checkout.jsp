<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
	<%--静态包含 base css JQuery等--%>
	<%@ include file="/pages/comment/header.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">结算</span>
			<div>
				<span>欢迎<span class="um_span">黄帅</span>光临书城</span>
				<a href="order/order.jsp">我的订单</a>
				<a href="pages/client/index1.jsp">注销</a>&nbsp;&nbsp;
				<a href="pages/client/index1.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
		
		<h1>下单成功！您的订单号为：${sessionScope.orderId}
		<br><a href="pay/pay.jsp"><input type="submit" value="去支付"></a>
		</h1>
	
	</div>

	<%--静态包含列表--%>
	<%@ include file="/pages/comment/footer.jsp"%>
</body>
</html>