<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.faq.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	FaqService faqService = new FaqService();
	List<Faq> faqList = faqService.getAll();
	pageContext.setAttribute("faqList",faqList);
%>
<%-- <jsp:useBean id="FaqService" scope="page" class="com.faq.model.FaqService" /> --%>

<html>
<head>
<title>所有常見問題 - list All FAQ.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#FFFFFF' align='center' valign='middle' height='20'>
		<td>
		<h3>所有常見問題 - ListAllFaq.jsp</h3>
		<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">回首頁</a>
		</td>
	</tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		
		<th>常見問題編號</th>
		<th>發佈員工編號</th>
		<th>常見問題類別</th>
		<th>常見問題標題</th>
		<th>常見問題解答</th>
		
	</tr>

<%@ include file="pages/page1.file" %> 
	<c:forEach var="faq" items="${faqList}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(Faq.faqNo==param.faqNo) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${faq.faqNo}</td>
			<td>${faq.empNo}</td>
			<td>${faq.faqCategory}</td>
			<td>${faq.faqTitle}</td>
			<td>${faq.faqAnswer}</td>
			
<%-- 			<td><c:forEach var="deptVO" items="${deptSvc.all}"> --%>
<%--                     <c:if test="${news.deptno==deptVO.deptno}"> --%>
<%-- 	                    ${deptVO.deptno}【${deptVO.dname} - ${deptVO.loc}】 --%>
<%--                     </c:if> --%>
<%--                 </c:forEach> --%>
<!-- 			</td> -->
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
			     <input type="submit" value="修改"> 
			     <input type="hidden" name="faqNo" value="${faq.faqNo}">
			     <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			     <input type="hidden" name="action"	value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="faqNo" value="${faq.faqNo}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--送出當前是第幾頁給Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="pages/page2.file" %>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
