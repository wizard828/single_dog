<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="">
<%
	Emp empVO = (Emp) request.getAttribute("empVO");
	List<Integer> authForUpdate=(List<Integer>)request.getAttribute("auth");
// 	List<Integer> auth = (List<Integer>) session.getAttribute("auth");
	pageContext.setAttribute("empVO", empVO);
	//pageContext.setAttribute("auth", auth);
	pageContext.setAttribute("authForUpdate", authForUpdate);
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

								<div class=" col-md-9 col-lg-9">
									<tbody>

										<table border='1' cellpadding='5' cellspacing='0' width='400'>
											<tr bgcolor='#CCCCFF' align='center' valign='middle'
												height='20'>
												<td>
													<h3>���u��ƭק�</h3> <a
													href="<%=request.getContextPath()%>/back_end/emp/authManage.jsp">�^����</a>
												</td>
											</tr>
										</table>

										<h3>��ƭק�:</h3>
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

										<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/emp/EmpServlet.do" name="form1">
											<table class="table table-user-information" border="0">

	
												<tr>
													<td>���u�s��:<font color=red><b>*</b></font></td>
													<td><%=empVO.getEmpNo()%></td>
												</tr>
											

												<tr>
													<td class="title">���u�m�W:</td>
													<td><input type="text" class="form-control"
														name="empName" id="empName"
														value="<%=empVO.getEmpName()%>" placeholder="��J���u�m�W" /></td>
												</tr>
											
												
												
												<tr>
													<td class="title">���uEmail:</td>
													<td><input type="text" class="form-control"
														name="empEmail" id="empEmail"
														value="<%=empVO.getEmpEmail()%>" placeholder="��J���uEmail" /></td>
												</tr>
												
									
												<tr>
													<td class="title">¾��</td>
													<td><select class="form-control" id="sel1"
														name="empJob">
															<c:if test="${empVO.getEmpJob()=='�`�g�z'}">
																<option value="�`�g�z" selected>�`�g�z</option>
															</c:if>
															<c:if test="${empVO.getEmpJob()!='�`�g�z'}">
																<option value="�`�g�z">�`�g�z</option>
															</c:if>

															<c:if test="${empVO.getEmpJob()=='��z'}">
																<option value="��z" selected>��z</option>
															</c:if>
															<c:if test="${empVO.getEmpJob()!='��z'}">
																<option value="�`��z">��z</option>
															</c:if>


															<c:if test="${empVO.getEmpJob()=='�M��'}">
																<option value="�M��" selected>�M��</option>
															</c:if>
															<c:if test="${empVO.getEmpJob()!='�M��'}">
																<option value="�M��">�M��</option>
															</c:if>


															<c:if test="${empVO.getEmpJob()=='�uŪ��'}">
																<option value="�uŪ��" selected>�uŪ��</option>
															</c:if>
															<c:if test="${empVO.getEmpJob()!='�uŪ��'}">
																<option value="�uŪ��">�uŪ��</option>
															</c:if>
													</select></td>
												</tr>
											
												
												
							
												<tr>
													<td class="title">���Τ��</td>
													<td><input type="date" name="empHireDate"
														min="1910-01-01" max='2000-13-13' id="empHireDate"
														value="<%=empVO.getEmpHireDate()%>" class="form-control"
														placeholder="Confirm your Password" /></td>
												</tr>

	</table>

												
													���u�v��<%=authForUpdate %>
<c:if test="<%=authForUpdate!=null %>">
														<div class="row">
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4001"
																		<c:if test="<%=authForUpdate.contains(4001) %>">
																		checked
																		</c:if>
																		>�e�ݬݪO�޲z</label>
																</div>
															</div>
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4002"
																		<c:if test="<%=authForUpdate.contains(4002) %>">
																		checked
																		</c:if>
																		>�|���b���޲z</label>
																</div>
															</div>
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4003"
																		<c:if test="<%=authForUpdate.contains(4003) %>">
																		checked
																		</c:if>
																		>�ӫ��޲z</label>
																</div>
															</div>
														</div>


														<div class="row">
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4004"
																		<c:if test="<%=authForUpdate.contains(4004) %>">
																		checked
																		</c:if>
																		>���|�ӶD�޲z</label>
																</div>
															</div>
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4005"
																		<c:if test="<%=authForUpdate.contains(4005) %>">
																		checked
																		</c:if>
																		>�v���޲z</label>
																</div>
															</div>
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4006"
																		<c:if test="<%=authForUpdate.contains(4006) %>">
																		checked
																		</c:if>
																		>���ʺ޲z</label>
																</div>
															</div>
														</div>


														<div class="row">
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4007"
																	    <c:if test="<%=authForUpdate.contains(4007) %>">
																		checked
																		</c:if>
																		>�\�U�޲z</label>
																</div>
															</div>
															<div class="col-sm-4">
																<div class="checkbox">
																	<label><input type="checkbox" name="empAuth"
																		value="4008"
																		<c:if test="<%=authForUpdate.contains(4008) %>">
																		checked
																		</c:if>
																		>�����H�޲z</label>
																</div>
															</div>
														</div>
											
	</c:if>


										
											<br> <input type="hidden" name="action" value="update">
											<input type="hidden" name="empNo"
												value="<%=empVO.getEmpNo()%>"> <input type="hidden"
												name="requestURL"
												value="<%=request.getParameter("requestURL")%>">
											<!--������e�X�ק諸�ӷ��������|��,�A�e��Controller�ǳ���椧��-->
											<input type="hidden" name="whichPage"
												value="<%=request.getParameter("whichPage")%>">
											<!--�Ω�:istAllEmp.jsp �P �ƦX�d�� listEmps_ByCompositeQuery.jsp-->
											<input class="btn btn-primary" type="submit" value="�e�X�ק�">
										</FORM>


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
