<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
	<%--静态包含 base css JQuery等--%>
	<%@ include file="/pages/comment/header.jsp" %>
	<script type="text/javascript">
		$(function () {
			$("button.addToCart").click(function () {
				var bookId = $(this).attr("bookId");
				location.href = "http://localhost:8080/book/cartServlet?action=addItem&id=" + bookId;
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书城</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${not empty sessionScope.cart.items}">
					<span>您的购物车中有<span style="color: red">${sessionScope.cart.totalCount}</span>件商品</span>
					<div>
						您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
					</div>
						</c:if>
				<c:if test="${empty sessionScope.cart.items}">
					<div>
						<span style="color: red">亲~购物车空空也~快去添加图书叭~</span>

					</div>
				</c:if>
			</div>

			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
					<div class="img_div">
						<%--http://localhost:8080/book/web/${book.img_path}--%>
						<img class="book_img" alt="" src="${book.img_path}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_stock">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button bookId="${book.id}" class="addToCart">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<%--分页功能开始--%>
		<div id="page_nav" style="height: 50px;width: 370px">
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="${sessionScope.url}&min=${sessionScope.min}&max=${sessionScope.max}&pageNo=1">⾸⻚</a>
				<a href="${sessionScope.url}&max=${sessionScope.max}&min=${sessionScope.min}&pageNo=${requestScope.page.pageNo-1}">上⼀⻚</a>
			</c:if>

				<%--情况 1：如果总⻚码⼩于等于 5 的情况，⻚码的范围是：1-总⻚码--%>
				<%--此时若页码数大于3的话，浏览器没有效果显示，只有页码数小于或者等于3时才显示效果--%>
			<c:choose>
			<c:when test="${requestScope.page.pageTotal<=5}">
					<c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
						<c:if test="${requestScope.page.pageNo == i}">
							【${i}】
						</c:if>
						<c:if test="${requestScope.page.pageNo != i}">
							<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
						</c:if>
					</c:forEach>
			</c:when>
				        			<%--情况 2：总⻚码⼤于 5 的情况。假设⼀共 10 ⻚--%>
                                        <c:when test="${requestScope.page.pageTotal>5}">
                                            <c:choose>
                                                <%--⼩情况 1：当前⻚码为前⾯ 3 个：1，2，3 的情况，⻚码范围是：1-5.--%>
                                                <c:when test="${requestScope.page.pageNo<=3}">
                                                    <c:forEach begin="1" end="5" var="i">
                                                        <c:if test="${requestScope.page.pageNo == i}">
                                                            【${i}】
                                                        </c:if>
                                                        <c:if test="${requestScope.page.pageNo !=i}">
                                                            <a href="${sessionScope.url}&min=${sessionScope.min}&max=${sessionScope.max}&pageNo=${i}">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:when>
                                                <%--⼩情况 2：当前⻚码为最后 3 个，8，9，10，⻚码范围是：总⻚码减 4 - 总⻚码--%>
                                                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                                                    <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                                                        <c:if test="${requestScope.page.pageNo == i}">
                                                            【${i}】
                                                        </c:if>
                                                        <c:if test="${requestScope.page.pageNo != i}">
                                                            <a href="client/bookServlet?action=page&pageNo=${i}">${i}</a>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:when>
                                    <%--⼩情况 3：4，5，6，7，⻚码范围是：当前⻚码减 2 - 当前⻚码加 2- -%>--%>
                                    <c:otherwise>
                                        <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                                            <c:if test="${requestScope.page.pageNo == i}">
                                                【${i}】
                                            </c:if>
                                            <c:if test="${requestScope.page.pageNo != i}">
                                                <a href="client/bookServlet?action=page&pageNo=${i}">${i}</a>
                                            </c:if>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

				</c:when>

			</c:choose>
			<%--<a href="#">3</a>
            ${requestScope.page.pageNo}
            <a href="#">5</a>--%>
			第【${requestScope.page.pageNo}】页
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="${sessionScope.url}&min=${sessionScope.min}&max=${sessionScope.max}&pageNo=${requestScope.page.pageNo+1}">下⼀⻚</a>
				<a href="${sessionScope.url}&min=${sessionScope.min}&max=${sessionScope.max}&pageNo=${requestScope.page.pageTotal}">尾⻚</a>
			</c:if>
			共${requestScope.page.pageTotal}⻚，${requestScope.page.pageTotalCount}
			条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>⻚
			<input id="searchPageBtn" type="button" value="确定">
		</div>
		<script type="text/javascript">
			$(function () {
				// 跳到指定的⻚码
				$("#searchPageBtn").click(function () {
					var pageNo = $("#pn_input").val();
					<%--var pageTotal = ${requestScope.page.pageTotal};--%>
					<%--alert(pageTotal);--%>
					// javaScript 语⾔中提供了⼀个 location 地址栏对象
					// 它有⼀个属性叫 href.它可以获取浏览器地址栏中的地址
					// href 属性可读，可写
					location.href = "${pageScope.basePath}${sessionScope.url}&min=${sessionScope.min}&max=${sessionScope.max}&pageNo=" + pageNo;
				});
			});
		</script>
	</div>
		<%--分页结束--%>
	<%--静态包含页脚信息--%>
	<%@ include file="/pages/comment/footer.jsp"%>
</body>
</html>