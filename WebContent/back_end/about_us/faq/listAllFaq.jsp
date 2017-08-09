<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.news.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	NewsService newsService = new NewsService();
	List<News> list = newsService.getAll();
	pageContext.setAttribute("list",list);
%>
<%-- <jsp:useBean id="NewsService" scope="page" class="com.news.model.NewsService" /> --%>

<html>
<head>
<title>�Ҧ��̷s���� - listAllNews.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�Ҧ��̷s���� - ListAllNews.jsp</h3>
		<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a>
		</td>
	</tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		
		<th>�̷s�����s��</th>
		<th>�o�G���u�s��</th>
		<th>�̷s�������D</th>
		<th>�̷s�������e</th>
		<th>�o�G�]��s�^���</th>
		
	</tr>

	<%@ include file="pages/page1.file" %> 
	<c:forEach var="news" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(News.newsNo==param.newsNo) ? 'bgcolor=#CCCCFF':''}><!--�N�ק諸���@���[�J����Ӥw-->
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
<!-- 			</td> -->
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do">
			     <input type="submit" value="�ק�"> 
			     <input type="hidden" name="newsNo" value="${news.newsNo}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller-->
			     <input type="hidden" name="action"	value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="newsNo" value="${news.newsNo}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2.file" %>

<br>�����������|:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
