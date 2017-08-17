<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.news.model.*"%>
<%
	News news = (News) request.getAttribute("newsUpdate"); //EmpServlet.java (Controller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>
<html>
<head>
<title>�̷s�����ק� - update_News.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�̷s�����ק� - update_News.jsp</h3>
		<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a></td>
	</tr>
</table>

<h3>�̷s�����ק�/�R��:</h3>
<!-- ���~��C   -->
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
		<td><input type="TEXT" name="newsTitle" size="30"	value="<%=news.getNewsTitle()%>" /></td>
	</tr>
		<tr>
		<td>�̷s�������e:</td>
		<td><input type="TEXT" name="newsContent" size="45"	value="<%=news.getNewsContent()%>" /></td>
	</tr>
	
	<tr>
		<td>�o�G�]��s�^���:</td>
		<td><input type="hidden" name="newsDate" value="<%=news.getNewsDate()%>">
		<%=news.getNewsDate()%>
		</td>
		    
	</tr>

</table>
<br>
<input type="hidden" name="action" value="updateSuccess">
<%-- <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��--> --%>
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--�u�Ω�:listAllEmp.jsp-->
<input type="submit" value="�e�X�ק�"></FORM>

<br>�e�X�ק諸�ӷ��������|:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
   <font color=blue>request.getParameter("whichPage"):</font> <%= request.getParameter("whichPage")%> (���d�ҥثe�u�Ω�:istAllEmp.jsp))</b>
</body>
</html>
