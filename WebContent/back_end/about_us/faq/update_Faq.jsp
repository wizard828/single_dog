<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="com.faq.model.*"%>

<%
	Faq faq = (Faq) request.getAttribute("faqUpdate"); //EmpServlet.java (Controller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>

<html>
<head>
<%@ include file="faqHeader.file"%>
<title>�̷s�����ק� - update_Faq.jsp</title>
</head>

<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body>

<%@ include file="/back_end/backEndNavBar.file"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/back_end/backEndLSide.file"%>

			<div class="col-xs-12 col-sm-8">


				<h5 class="page-header text-right">�ثe��m:��ݭ���</h5>


				<div class="row">

					<div class="panel panel-info">

						<div class="panel-heading">
							<h3 class="panel-title">${emp.empName}</h3>
						</div>

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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" name="form1">
<table border="0">
	<tr>
		<td>�`�����D�s��:<font color=red><b>*</b></font></td>
		<td><input type="hidden" name="faqNo" value="${faqUpdate.faqNo}">
		${faqUpdate.faqNo}
		</td>
	</tr>
	<tr>
		<td>�`�����D���O:</td>
		<td><input type="text" name="faqCategory" value="<%=faq.getFaqCategory() %>" required>
		</td>
	</tr>
	<tr>
		<td>�`�����D���D:</td>
		<td><input type="TEXT" name="faqTitle" size="30"	value="<%=faq.getFaqTitle() %>" required></td>
	</tr>
		<tr>
		<td>�`�����D�ѵ�:</td>
		<td><input type="TEXT" name="faqAnswer" size="45"	value="<%=faq.getFaqAnswer() %>" required></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="updateSuccess">
<%-- <input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��--> --%>
<input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--�u�Ω�:listAllEmp.jsp-->
<input type="submit" value="�e�X�ק�"></FORM>

</body>
</html>
