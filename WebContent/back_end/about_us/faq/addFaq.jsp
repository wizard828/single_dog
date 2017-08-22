<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="com.faq.model.*"%>
<%
	Faq faq = (Faq) request.getAttribute("faq");
	Emp emp = (Emp) request.getAttribute("emp");
	pageContext.setAttribute("emp", emp);
%>

<html>
<head>
<%@ include file="faqHeader.file"%>
<title>�ƦX�d�� - listEmps_ByCompositeQuery.jsp</title>
</head>
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

						<div class="panel-body">

							<div class="row">

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
											<td>�`�����D���O:</td>
											<td><input type="TEXT" name="faqCategory" size="45" value="<%=(faq == null) ? "��J���O" : faq.getFaqCategory()%>" /></td>
										</tr>

										<tr>
											<td>�`�����D���D:</td>
											<td><input type="TEXT" name="faqTitle" size="45" value="<%=(faq == null) ? "��J���D" : faq.getFaqTitle()%>" /></td>
										</tr>

										<tr>
											<td>�`�����D�ѵ�:</td>
											<td><input type="TEXT" name="faqAnswer" size="45" value="<%=(faq == null) ? "��J�ѵ�" : faq.getFaqAnswer()%>" /></td>
										</tr>

									</table>
									<br>
								<input type="hidden" name="action" value="insert">
								<input type="submit" value="�e�X�s�W"></FORM>
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
</body>
</html>
