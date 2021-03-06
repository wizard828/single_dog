<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.news.model.*"%>
<%
News news = (News) request.getAttribute("news");
%>

<html>
<head>
<title>員工資料新增 - addNews.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>最新消息新增 - addNews.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back_end/about_us/news/news_select_page.jsp">
		   <img src="" width="" height="" border="">回首頁</a>
	    </td>
	</tr>
</table>

<h3>新增最新消息:</h3>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do" name="form1">
<table border="0">
	
	<tr>
		<td>最新消息編號:</td>
		<td>系統生成</td>
	</tr>
	<tr>
		<td>員工編號:</td>
		<td><input type="TEXT" name="empNo" size="45" 
			value="" placeholder="施工中"></td>
	</tr>
	<tr>
		<td>最新消息標題:</td>
		<td><input type="TEXT" name="newsTitle" size="45" 
			value="" placeholder="請輸入標題"></td>
	</tr>
	<tr>
		<td>最新消息內容:</td>
		<td><input type="TEXT" name="newsContent" size="45" 
			value="" placeholder="請輸入內容"></td>
	</tr>
	<tr>
		<td>發佈（更新）日期:</td>
		<td>系統生成</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
