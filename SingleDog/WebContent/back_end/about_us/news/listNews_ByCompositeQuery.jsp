<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位 --%>
<%-- 此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能--%>

<jsp:useBean id="listNews_ByCompositeQuery" scope="request" type="java.util.List" />
<jsp:useBean id="newsService" scope="page" class="com.news.model.NewsService" />
<html>
<head>
<title>複合查詢 - listEmps_ByCompositeQuery.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=blue>
☆萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位<br>
☆此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3><font color=red>複合查詢</font>最新消息 - listNews_ByCompositeQuery.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="" width="" height="" border="">回首頁</a>
		</td>
	</tr>
</table>


<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>最新消息編號</th>
		<th>發佈員工編號</th>
		<th>最新消息標題</th>
		<th>最新消息內容</th>
		<th>發佈（更新）日期</th>
		
	</tr>
	<c:forEach var="news" items="${listEmps_ByCompositeQuery}">
		<tr align='center' valign='middle'>
			<td>${empVO.empno}</td>
			<td>${empVO.ename}</td>
			<td>${empVO.job}</td>
			<td>${empVO.hiredate}</td>
			<td>${empVO.sal}</td>
			<td>${empVO.comm}</td>			
			<td><c:forEach var="deptVO" items="${deptSvc.all}">
                    <c:if test="${empVO.deptno==deptVO.deptno}">
	                    ${deptVO.deptno}【${deptVO.dname} - ${deptVO.loc}】
                    </c:if>
                </c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
