<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--静态包含 base css JQuery等--%>
	<%@ include file="/pages/comment/header.jsp" %>
	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗?");
			});
		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
		<%--静态包含图书管理信息--%>
		<%@ include file="/pages/comment/manager_menu.jsp"%>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageTotal=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>


		<%--分页功能开始--%>
		<div id="page_nav" style="height: 50px;width: 370px">
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="manager/bookServlet?action=page&pageNo=1">⾸⻚</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上⼀⻚</a>
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
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
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
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
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
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
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
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下⼀⻚</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">尾⻚</a>
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
					location.href = "${pageScope.basePath}manager/bookServlet?action=page&pageNo=" + pageNo;
				});
			});
		</script>
	</div>
	<%--静态包含列表--%>
	<%@ include file="/pages/comment/footer.jsp"%>
</body>
</html>