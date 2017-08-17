<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="">
<%
	Emp emp = (Emp) request.getAttribute("emp");
	pageContext.setAttribute("emp", emp);

%>
<head>

<%@ include file="empHeader.file"%>


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






										<a href="#" class="list-group-item" data-toggle="collapse"
											data-target="#search" data-parent="#menu">���u�d�� <span
											class="glyphicon glyphicon-triangle-bottom pull-right"></span></a>
										<div id="search" class="sublinks collapse">
											<a class="list-group-item small" href='<%=request.getContextPath()%>/back_end/emp/listAllEmp.jsp'>�d�ߥ������u</a>
											<a href="#" class="list-group-item small" data-toggle="modal"
												data-target="#searchSpec"> �d�߯S�w���u</a>
										</div>




										<!-- �ק�Modal-->
										<div class="modal fade" id="searchSpec"
											role="dialog">
											<div class="modal-dialog">

												
												
												
												<!-- �ƦX�d��Modal content-->
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal">&times;</button>
														<h4 class="modal-title">�d�߭��u</h4>
													</div>
													<div class="modal-body">

														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>//back_end/emp/EmpServlet.do">
															<table class="table table-user-information">


																<tr>
																	<td class="title">���u�s��:</td>
																	<td><input type="text" class="form-control"
																		name="empNo" id="empNo"
																		placeholder="�п�J���u�s��" /></td>
																</tr>


																<tr>
																	<td class="title">���u�b��:</td>
																	<td><input type="text" class="form-control"
																		name="empId" id="empId"
																		placeholder="��J���u�m�W" /></td>
																</tr>

																<tr>
																	<td class="title">���u�m�W:</td>
																	<td><input type="text" class="form-control"
																		name="empName" id="empName"
																		placeholder="��J���u�m�W" /></td>
																</tr>


																<tr>
																	<td class="title">¾��</td>
																	<td><select class="form-control" id="sel1"
																		name="empJob">
																			<option value=""></option>
																			<option value="�`�g�z">�`�g�z</option>
																			<option value="��z">��z</option>
																			<option value="�M��">�M��</option>
																			<option value="�uŪ��">�uŪ��</option>
																	</select></td>
																</tr>


																<tr>
																	<td class="title">���Τ��</td>
																	<td><input type="date" name="empHireDate"
																		min="1910-01-01" max='2000-13-13' id="empHireDate"
																		 class="form-control"
																		placeholder="Confirm your Password" /></td>
																</tr>

															</table>

															<input type="hidden" name="action"
																value="listEmps_ByCompositeQuery"> <input
																type="submit" value="�d��" class="btn btn-primary">

														</FORM>
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