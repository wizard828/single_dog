<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.news.model.*"%>
<%
News news = (News) request.getAttribute("news");
%>

<html>
<head>
<title>���u��Ʒs�W - addNews.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�̷s�����s�W - addNews.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back_end/about_us/news/news_select_page.jsp">
		   <img src="" width="" height="" border="">�^����</a>
	    </td>
	</tr>
</table>

<h3>�s�W�̷s����:</h3>
<%-- ���~���C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
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
		<td>�̷s�����s��:</td>
		<td>�t�Υͦ�</td>
	</tr>
	<tr>
		<td>���u�s��:</td>
		<td><input type="TEXT" name="empNo" size="45" 
			value="" placeholder="�I�u��"></td>
	</tr>
	<tr>
		<td>�̷s�������D:</td>
		<td><input type="TEXT" name="newsTitle" size="45" 
			value="" placeholder="�п�J���D"></td>
	</tr>
	<tr>
		<td>�̷s�������e:</td>
		<td><input type="TEXT" name="newsContent" size="45" 
			value="" placeholder="�п�J���e"></td>
	</tr>
	<tr>
		<td>�o�G�]��s�^���:</td>
		<td>�t�Υͦ�</td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>
</body>

</html>