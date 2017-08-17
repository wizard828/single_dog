<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.faq.model.*"%>

<%-- �����m�߱ĥ� Script ���g�k���� --%>
<%-- ���X Concroller EmpServlet.java�w�s�Jrequest��EmpVO����--%>
<%-- ���X ������DeptVO����--%>

<html>
<head>
<title>FAQ�d�� - listRealtive.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�W�nder~����Ȱ�~</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>FAQ��ݬd�� - ListRealtiveFaq.jsp</h3>
		<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>�`�����D�s��</th>
		<th>�o�G���u�s��</th>
		<th>�`�����D���O</th>
		<th>�`�����D���D</th>
		<th>�`�����D�ѵ�</th>
		
	</tr>
	<c:forEach var="faq" items="${faqList}" >
	<tr align='center' valign='middle'>
		<td>${faq.faqNo}</td>
 		<td>${faq.empNo}</td>
 		<td>${faq.faqCategory}</td>
 		<td>${faq.faqTitle}</td>
 		<td>${faq.faqAnswer}</td>
 		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
			     <input type="submit" value="�ק�"> 
			     <input type="hidden" name="faqNo" value="${faq.faqNo}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			     <input type="hidden" name="action"	value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="faqNo" value="${faq.faqNo}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		
	</tr>
	</c:forEach>
</table>

</body>
</html>
