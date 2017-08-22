<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="">
<%
	Emp emp = (Emp) request.getAttribute("emp");
	pageContext.setAttribute("emp", emp);

%>

<head>
<%@ include file="faqHeader.file"%>
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

								<div class=" col-md-9 col-lg-9 ">
									<tbody>

										<a href="<%=request.getContextPath()%>/back_end/about_us/faq/addFaq.jsp" class="list-group-item" >�s�W�`�����D<span></span></a>

										<a href="#" class="list-group-item" data-toggle="collapse" data-target="#search" data-parent="#menu" style="margin-top:10px;">�s��`�����D <span
											class="glyphicon glyphicon-triangle-bottom pull-right"></span></a>
										<div id="search" class="sublinks collapse">
											<a class="list-group-item small" href='<%=request.getContextPath()%>/back_end/about_us/faq/listAllFaq.jsp'>�d�ߥ����`�����D</a>
											<a href="#" class="list-group-item small" data-toggle="modal"
												data-target="#searchSpec"> �d�߯S�w�`�����D</a>
										</div>

										<!-- �ק�Modal-->
										<div class="modal fade" id="searchSpec"
											role="dialog">
											<div class="modal-dialog">

												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">�d�߭��u</h4>
													</div>
													<div class="modal-body">

	<ul>

		<li>
			<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
				<b>��J�`�����D�s�� (�p0001):</b> <input type="text" name="faqNo">
				<input type="submit" value="�d��">
				<input type="hidden" name="action" value="getFaqNo_For_Display" required>
			</FORM>
		</li>

		<%--   <jsp:useBean id="FaqService" scope="page" class="com.Faq.model.FaqService" /> --%>

<!-- 		<li> -->

<%-- 			<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do"> --%>
<!-- 				<b>��ܱ`�����D�s��:</b> <select size="1" name="faqNo"> -->
<%-- 					<c:forEach var="faq" items="${faqService.all}"> --%>
<%-- 						<option value="${faq.faqno}">${faq.faqno} --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> <input type="submit" value="�e�X"> -->
<!-- 				<input type="hidden" name="action" value="getOne_For_Display"> -->
<!-- 			</FORM> -->
<!-- 		</li> -->

<!-- 		<li> -->
<%-- 			<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do"> --%>
<!-- 				<b>��ܭ��u�m�W:</b> <select size="1" name="empName"> -->
<%-- 					<c:forEach var="empname" items="${empSvc.all}"> --%>
<%-- 						<option value="${emp.empname}">${emp.empname} --%>
<%-- 					</c:forEach> --%>
<!-- 				</select> <input type="submit" value="�e�X"> -->
<!-- 				<input type="hidden" name="action" value="getEmpName_For_Display"> -->
<!-- 			</FORM> -->
<!-- 		</li> -->

		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
				<b>��J�`�����D���O:</b> <input type="text" name="faqCategory">
				<input type="submit" value="�d��">
				<input type="hidden" name="action" value="getRealtive_For_Category">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
				<b>��J�`�����D���D:</b> <input type="text" name="faqTitle">
				<input type="submit" value="�d��">
				<input type="hidden" name="action" value="getRealtive_For_Title">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do">
				<b>��J�`�����D����:</b> <input type="text" name="faqAnswer">
				<input type="submit" value="�d��">
				<input type="hidden" name="action" value="getRealtive_For_Answer">
			</FORM>
		</li>
	</ul>
													</div>


												</div>

											</div>
										</div>

									</tbody>


									<c:if test="${not empty errorMsgs}">
										<font color="red">
											<ul>
												<c:forEach var="message" items="${errorMsgs}">
													<li>${message}</li>
												</c:forEach>
											</ul>
										</font>
									</c:if>


								</div>
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