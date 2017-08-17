<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.news.model.*"%>
<%
	News news = (News) request.getAttribute("newsUpdate"); //EmpServlet.java (Controller), 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<html>
<head>
<title>最新消息修改 - update_News.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>最新消息修改 - update_News.jsp</h3>
		<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">回首頁</a></td>
	</tr>
</table>

<h3>最新消息修改/刪除:</h3>
<!-- 錯誤表列   -->
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
		<td>最新消息編號:<font color=red><b>*</b></font></td>
		<td><input type="hidden" name="newsNo" value="<%=news.getNewsNo()%>">
		<%=news.getNewsNo()%>
		</td>
	</tr>
	<tr>
		<td>員工編號:</td>
		<td><input type="hidden" name="empNo" value="<%=news.getEmpNo()%>">
		<%=news.getEmpNo()%>
		</td>
	</tr>
	<tr>
		<td>最新消息標題:</td>
		<td><input type="TEXT" name="newsTitle" size="30"	value="<%=news.getNewsTitle()%>" /></td>
	</tr>
		<tr>
		<td>最新消息內容:</td>
		<td><input type="TEXT" name="newsContent" size="45"	value="<%=news.getNewsContent()%>" /></td>
	</tr>
	
	<tr>
		<td>發佈（更新）日期:</td>
		<td><input type="hidden" name="newsDate" value="<%=news.getNewsDate()%>">
		<%=news.getNewsDate()%>
		</td>
		    
	</tr>

</table>
<br>
<input type="hidden" name="action" value="updateSuccess">
<%-- <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--接收原送出修改的來源網頁路徑後,再送給Controller準備轉交之用--> --%>
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:listAllEmp.jsp-->
<input type="submit" value="送出修改"></FORM>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
   <font color=blue>request.getParameter("whichPage"):</font> <%= request.getParameter("whichPage")%> (此範例目前只用於:istAllEmp.jsp))</b>
</body>
</html>
