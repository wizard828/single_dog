<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.faq.model.*"%>
<%
Faq faq = (Faq) request.getAttribute("faq");
%>

<html>
<head>
<title>FAQ�s�W - addFAQ.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>FAQ�s�W - addFAQ.jsp</h3>
		</td>
		<td>
		   <a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a>
	    </td>
	</tr>
</table>

<h3>FAQ�s�W:</h3>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" name="form1">
<table border="0">
	
	<tr>
		<td>�`�����D�s��:<font color=red><b>*</b></font></td>
		<td><input type="hidden" name="faqNo" value="">
<%-- 		<%=faq.getFaqNo()%> --%>
		</td>
	</tr>
	
	<tr>
		<td>���u�s��:</td>
		<td><input type="hidden" name="empNo" value="">
<%-- 		<%=faq.getEmpNo()%> --%>
		</td>
	</tr>
	
	<tr>
		<td>�`�����D���O:</td>
		<td><input type="TEXT" name="faqCategory" size="45" 
			value="<%= (faq ==null)? "��J���O" : faq.getFaqCategory()%>" /></td>
	</tr>
	
	<tr>
		<td>�`�����D���D:</td>
		<td><input type="TEXT" name="faqTitle" size="45" 
			value="<%= (faq ==null)? "��J���D" : faq.getFaqTitle()%>" /></td>
	</tr>
	
	<tr>
		<td>�`�����D�ѵ�:</td>
		<td><input type="TEXT" name="faqAnswer" size="45" 
			value="<%= (faq ==null)? "��J�ѵ�" : faq.getFaqAnswer()%>" /></td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="�e�X�s�W"></FORM>
</body>

</html>
