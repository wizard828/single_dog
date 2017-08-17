<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
	EmpService empSvc = new EmpService();
	List<Emp> list = empSvc.getAll();
	pageContext.setAttribute("list", list);

%>


<html>
<head>
<%@ include file="empHeader.file"%>
<title>�Ҧ����u��� - listAllEmp.jsp</title>
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


										<table border='1' cellpadding='5' cellspacing='0' width='800'>
											<tr bgcolor='#CCCCFF' align='center' valign='middle'
												height='20'>
												<td>
													<h3>�Ҧ����u���</h3> <a
													href="<%=request.getContextPath()%>/back_end/emp/authManage.jsp">�^����</a>
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
												<th>���u�s��</th>
												<th>���u�m�W</th>
												<th>¾��</th>
												<th>���Τ��</th>
												<th>�ק�</th>
												<th>�R��</th>
											</tr>
											<%@ include file="pages/page1.file"%>
											<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>"
												end="<%=pageIndex+rowsPerPage-1%>">
												<tr align='center' valign='middle'
													${(empVO.empNo==param.empNo) ? 'bgcolor=#CCCCFF':''}>
													<!--�N�ק諸���@���[�J����Ӥw-->
													<td>${empVO.empNo}</td>
													<td>${empVO.empName}</td>
													<td>${empVO.empJob}</td>
													<td>${empVO.empHireDate}</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/back_end/emp/EmpServlet.do">
															<input type="submit" value="�ק�"> <input
																type="hidden" name="empno" value="${empVO.empNo}">
															<input type="hidden" name="requestURL"
																value="<%=request.getServletPath()%>">
															<!--�e�X�����������|��Controller-->
															<input type="hidden" name="whichPage"
																value="<%=whichPage%>">
															<!--�e�X��e�O�ĴX����Controller-->
															<input type="hidden" name="action"
																value="getOne_For_Update">
														</FORM>
													</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/back_end/emp/EmpServlet.do">
															<input type="submit" value="�R��"> <input
																type="hidden" name="empno" value="${empVO.empNo}">
															<input type="hidden" name="requestURL"
																value="<%=request.getServletPath()%>">
															<!--�e�X�����������|��Controller-->
															<input type="hidden" name="whichPage"
																value="<%=whichPage%>">
															<!--�e�X��e�O�ĴX����Controller-->
															<input type="hidden" name="action" value="delete">
														</FORM>
													</td>
												</tr>
											</c:forEach>
										</table>
										<%@ include file="pages/page2.file"%>

						

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
