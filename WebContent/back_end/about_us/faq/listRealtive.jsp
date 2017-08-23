<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="com.faq.model.*"%>

<%
	FaqService faqService = new FaqService();
	//List<Faq> list = faqService.findByAnswer();
	List<Faq> list = (List<Faq>)request.getAttribute("faqList");
	pageContext.setAttribute("faqList",list);
%>

<html>
<head>
<%@ include file="faqHeader.file"%>
<title>FAQ�d�� - listRealtive.jsp</title>
</head>
<body bgcolor='white'>

	<%@ include file="/back_end/backEndNavBar.file"%>

	<div class="container-fluid">
		<div class="row">

			<%@ include file="/back_end/backEndLSide.file"%>

			<div class="col-xs-12 col-sm-8">


				<h5 class="page-header text-right">�ثe��m:��ݭ���</h5>
<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a>

				<div class="row">

					<div class="panel panel-info">

						<div class="panel-heading">
							<h3 class="panel-title">${emp.empName}</h3>
						</div>

						<div class="panel-body">


							<div class="row">

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

<!-- <b><font color=red>�W�nder~����Ȱ�~</font></b> -->
<!-- <table border='1' cellpadding='5' cellspacing='0' width='800'> -->
<!-- 	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'> -->
<!-- 		<td> -->
<!-- 		<h3>FAQ��ݬd�� - ListRealtiveFaq.jsp</h3> -->
<%-- 		<a href="<%=request.getContextPath()%>/back_end/about_us/faq/faq_select_page.jsp"><img src="" width="" height="" border="">�^����</a> --%>
<!-- 		</td> -->
<!-- 	</tr> -->
<!-- </table> -->

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>�`�����D�s��</th>
		<th>�o�G���u�s��</th>
		<th>�`�����D���O</th>
		<th>�`�����D���D</th>
		<th>�`�����D�ѵ�</th>
		
	</tr>
	<%@ include file="pages/page1.file" %>
	<c:forEach var="faq" items="${faqList}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle' ${(Faq.faqNo==param.faqNo) ? 'bgcolor=#CCCCFF':''}><!--�N�ק諸���@���[�J����Ӥw-->
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
			     <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller-->
			     <input type="hidden" name="action"	value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="faqNo" value="${faq.faqNo}">
			    <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--�e�X�����������|��Controller-->
			    <input type="hidden" name="whichPage"	value="<%=whichPage%>">               <!--�e�X��e�O�ĴX����Controller-->
			    <input type="hidden" name="action"value="delete"></FORM>
			</td>
		
	</tr>
	</c:forEach>
</table>

<%@ include file="pages/page2.file" %>

							</div>
						</div>
					</div>
				</div>



			</div>

			<script src="https://code.jquery.com/jquery.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

			<script>
				
			</script>

</body>
</html>
