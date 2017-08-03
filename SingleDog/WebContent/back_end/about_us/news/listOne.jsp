<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.news.model.*"%>

<%-- 此頁練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<% News news = (News) request.getAttribute("news");%>

<%-- 取出 對應的DeptVO物件--%>

<html>
<head>
<title>最新消息 - listOneEmp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 Script 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>最新消息後端查詢 - ListOneNews.jsp</h3>
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
	<tr align='center' valign='middle'>
<%--	EL寫法	--%>
<%-- 		<td>${news.newsNo}</td> --%>
<%--  		<td>${news.empNo}</td> --%>
		
		<td><%=news.getNewsNo()%></td>
 		<td><%=news.getEmpNo()%></td>
 		<td><%=news.getNewsTitle()%></td>
 		<td><%=news.getNewsContent()%></td>
 		<td><%=news.getNewsDate()%></td>
		
	</tr>
</table>

</body>
</html>
