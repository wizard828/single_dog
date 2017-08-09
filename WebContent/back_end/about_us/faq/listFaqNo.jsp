<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.news.model.*"%>

<%-- �����m�߱ĥ� Script ���g�k���� --%>
<%-- ���X Concroller EmpServlet.java�w�s�Jrequest��EmpVO����--%>
<%-- ���X ������DeptVO����--%>

<html>
<head>
<title>�̷s�����d�� - listNewsNo.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�W�nder~����Ȱ�~</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�̷s������ݬd�� - listNewsNo.jsp</h3>
		<a href="<%=request.getContextPath()%>/back_end/about_us/news/news_select_page.jsp"><img src="" width="" height="" border="">�^����</a>
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
		<th>�ק�</th>
		<th>�R��</th>
		
	</tr>

	<tr align='center' valign='middle'>
		<td>${news.newsNo}</td>
 		<td>${news.empNo}</td>
 		<td>${news.newsTitle}</td>
 		<td>${news.newsContent}</td>
 		<td><fmt:formatDate  pattern="yyyy-MM-dd HH:mm:ss" value="${news.newsDate}"/> </td>
<%--  	<td><fmt:formatDate  pattern="yyyy-MM-dd HH:mm:ss" value="${news.newsDate}"/> </td> --%>
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do">
			     <input type="submit" value="�ק�"> 
			     <input type="hidden" name="newsNo" value="${news.newsNo}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			     
			     <input type="hidden" name="action"	value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="newsNo" value="${news.newsNo}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			  
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
	</tr>
	<c:forEach var="news" items="${newList}">
		<tr align='center' valign='middle'><!--�N�ק諸���@���[�J����Ӥw-->
			<td>${news.newsNo}</td>
			<td>${news.empNo}</td>
			<td>${news.newsTitle}</td>
			<td>${news.newsContent}</td>
			<td>${news.newsDate}</td>
			
<%-- 			<td><c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%--                     <c:if test="${news.deptno==deptVO.deptno}"> --%>
<%-- 	                    ${deptVO.deptno}�i${deptVO.dname} - ${deptVO.loc}�j --%>
<%--                     </c:if> --%>
<%--                 </c:forEach> --%>
<%-- 			</td> --%>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do">
			     <input type="submit" value="�ק�"> 
			     <input type="hidden" name="newsNo" value="${news.newsNo}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			     <input type="hidden" name="action"	value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="newsNo" value="${news.newsNo}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
