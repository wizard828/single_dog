<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.news.model.*"%>

<%-- �����m�߱ĥ� Script ���g�k���� --%>

<%-- ���X Concroller EmpServlet.java�w�s�Jrequest��EmpVO����--%>
<% News news = (News) request.getAttribute("news");%>

<%-- ���X ������DeptVO����--%>

<html>
<head>
<title>�̷s���� - listOneEmp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�����m�߱ĥ� Script ���g�k����:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�̷s������ݬd�� - ListOneNews.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="" width="" height="" border="">�^����</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>�̷s�����s��</th>
		<th>�o�G���u�s��</th>
		<th>�̷s�������D</th>
		<th>�̷s�������e</th>
		<th>�o�G�]��s�^���</th>
		
	</tr>
	<tr align='center' valign='middle'>
<%--	EL�g�k	--%>
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
