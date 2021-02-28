<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含 base css JQuery等--%>
	<%@ include file="/pages/comment/header.jsp" %>
		<%--删除商品点击事件--%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteItem").click(function () {
				return confirm(("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗？"));
			})
			// 给清空购物车绑定单击事件
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗?");
			})

			// 给输入框绑定 onchange 内容发生改变事件
			$(".updateCount").change(function () {
				// 获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookId');
				// 获取商品数量
				var count = this.value;
				if (confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?")) {
					//发起请求。给服务器保存修改
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count=" + count + "&id=" + id;
				} else {
					// defaultValue 属性是表单项 Dom 对象的属性。它表示默认的 value 属性值。
					this.value = this.defaultValue;
				}
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--静态包含欢迎信息--%>
		<%@ include file="/pages/comment/success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">亲~购物车空空如也~</br></br></br><a style="color: red" href="pages/client/index1.jsp">点这里挑选图书吧~</a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
						<input style="width: 45px" type="text" value="${entry.value.count}"
							bookId="${entry.value.id}" class="updateCount"><input type="submit"value="确定">
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
			<c:if test="${not empty sessionScope.cart.items}">
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
					<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
					<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
				</div>
			</c:if>
	</div>

	<%--静态包含列表--%>
	<%@ include file="/pages/comment/footer.jsp"%>
</body>
</html>