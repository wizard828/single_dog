<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>
<%@ page import="java.util.*"%>


<%
	Emp emp = (Emp) session.getAttribute("emp");
	pageContext.setAttribute("emp", emp);
%>


<!DOCTYPE html>
<html lang="">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Title Page</title>
<link href="<%=request.getContextPath()%>/back_end/css/bootstrap.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/back_end/css/nav.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/back_end/css/colorplan.css"
	rel="stylesheet">
<!-- Custom CSS -->
<link
	href="<%=request.getContextPath()%>/back_end/css/modern-business.css"
	rel="stylesheet">
<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/back_end/font-awesome/css/font-awesome.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/back_end/css/backend.css"
	rel="stylesheet">
<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
</head>

<body>

<%@ include file="backEndNavBar.file"%>

	<div class="container-fluid">
		<div class="row">




			<%@ include file="backEndLSide.file"%>





			<div class="col-xs-12 col-sm-8">


				<h5 class="page-header text-right">�ثe��m:��ݭ���</h5>


				<div
					class="panel panel-default col-sm-offset-3 col-sm-6 text-center">
					<div class="panel-heading">
						<h3 class="panel-title">�ݳB�z�ƶ�</h3>
					</div>

					<ul class="list-group">
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5
							���ݼf�֭q�� <span class="label label-info pull-right">5</span>
						</li>
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1
							���ݼf���\�U <span class="label label-info pull-right">1</span>
						</li>
						<li class="list-group-item">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2
							���ݳB�z�ӶD <span class="label label-info pull-right">2</span>
						</li>
						<li class="list-group-item">0 ���ݳB�z���|</li>
						<li class="list-group-item">0 ���ݼf�֬���</li>

					</ul>







				</div>

		


			</div>

			<script src="https://code.jquery.com/jquery.js"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>