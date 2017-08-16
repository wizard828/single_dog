<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.dateitem.model.*"%>
<%@ page import="com.restaurant.model.*" %>
<%@ page import="com.member.model.*" %>
<%@ page import="java.util.*"%>

<%@ include file="header.file"%>

<jsp:useBean id = "dSvc" scope="page" class="com.dateitem.model.DateItemService" />
<jsp:useBean id = "memSvc" scope="page" class="com.member.model.MemberService" />
<%
    List<DateItemVO> list = dSvc.getAllItems();
    pageContext.setAttribute("list",list);
%>




<head><title>���|����</title></head>
<body bgcolor='white'>

<%@ include file="nav.file"%>
<%@ include file="sidelist.file"%>

<!-- JSP�H�@�ӥ]�t��u��div�}�l, ���O������</div>�g�bfooter�̭� -->

<div class="col-xd-12 col-sm-8 col-sm-offset-1 main-page-show">
<table class="table">
<tr><td> <select class="w3-select selectpicker" name="option">
    <option value="" disabled selected>�п�ܦa�I</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option>
  </select></td>
  <td><select class="w3-select selectpicker" name="option">
    <option value="" disabled selected>�п�ܥD�H</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option>
  </select></td>
  <td><select class="w3-select selectpicker" name="option">
    <option value="" disabled selected>�п���d��</option>
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option></select>
  </td>
  <td><button class="btn btn-lg btn-warning glyphicon glyphicon-search"> </button>
  </td></tr>
  </table>
  
  <table class="table text-align:center">
	<tr>
		<th align="center">�Ϥ�</th>
		<th align="center">�ʺ�</th>
		<th align="center">�s��</th>
		<th align="center">�ɶ�</th>
		<th align="center">��a</th>
		<th align="center">����</th>
		<th align="center">�\�U</th>
	</tr>
	<%@ include file="page3.file"%>
<c:forEach var="dateitem" items="${list}">
	<tr align='center' valign='middle'>
		<td><img id="allitemsimg" src="<%=request.getContextPath()%>/ImgReader?dateitemNo=${dateitem.dateItemNo}"></td>
			<td>${memSvc.getOneMember(dateitem.sellerNo).getMemSname()}</td>
			<td>${dateitem.dateItemNo}</td>
			<td>${dSvc.getTimeForItem(dateitem.dateMeetingTime)}</td>
			<td>${dateitem.sellerNo}</td>
			<td>${dateitem.dateItemPrice}</td>
			<td>${dateitem.restListNo}</td>
			<td><a class="btn btn-primary" href="<%=request.getContextPath() %>/front_end/dateitem/dateitem.do?action=buy_date&dateItemNo=${dateitem.dateItemNo}">�ʶR</a></td>
		</tr>
  </c:forEach>
</table>


<%@ include file="footer.file"%>





