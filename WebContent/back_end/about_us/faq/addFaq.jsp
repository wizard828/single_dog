<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.news.model.*"%>
<%
News news = (News) request.getAttribute("news");
%>

<html>
<head>
<title>���u��Ʒs�W - addEmp.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>���u��Ʒs�W - addEmp.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a>
	    </td>
	</tr>
</table>

<h3>��ƭ��u:</h3>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<FORM METHOD="post" ACTION="emp.do" name="form1">
<table border="0">
	
	<tr>
		<td>�̷s�����s��:<font color=red><b>*</b></font></td>
		<td><input type="hidden" name="newsNo" value="<%=news.getNewsNo()%>">
		<%=news.getNewsNo()%>
		</td>
	</tr>
	
	<tr>
		<td>���u�s��:</td>
		<td><input type="hidden" name="empNo" value="<%=news.getEmpNo()%>">
		<%=news.getEmpNo()%>
		</td>
	</tr>
	
	<tr>
		<td>�̷s�������D:</td>
		<td><input type="TEXT" name="newsTitle" size="45" 
			value="<%= (news ==null)? "��J���D" : news.getNewsTitle()%>" /></td>
	</tr>
	
	<tr>
		<td>�̷s�������e:</td>
		<td><input type="TEXT" name="newsContent" size="45" 
			value="<%= (news ==null)? "��J���e" : news.getNewsContent()%>" /></td>
	</tr>
	
	<tr>
		<td>�o�G�]��s�^���:</td>
		<td><input type="hidden" name="newsDate" value="<%=news.getNewsDate()%>">
		<%=news.getNewsDate()%>
		</td>
		    
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>
</body>

</html>
