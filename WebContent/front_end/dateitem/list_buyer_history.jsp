<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.dateitem.model.*"%>
<%@ page import="com.restaurant.model.*" %>
<%@ page import="com.member.model.*" %>
<%@ page import="java.util.*"%>

<%@ include file="header.file"%>

<jsp:useBean id = "dSvc" scope="page" class="com.dateitem.model.DateItemService" />

<%
List<DateItemVO> list = dSvc.findByBuyer_history(5009);
pageContext.setAttribute("list",list);

%>




<head><title>�ʶR����</title></head>
<body bgcolor='white'>

<%@ include file="nav.file"%>
<%@ include file="sidelist.file"%>

<!-- JSP�H�@�ӥ]�t��u��div�}�l, ���O������</div>�g�bfooter�̭� -->

<div class="col-xd-12 col-sm-8 col-sm-offset-1 main-page-show">

					<ul class="list-inline amos">
                    <li><a href="<%=request.getContextPath() %>/front_end/dateitem/dateitem.do?action=list_buyer_future">�i�椤�����|</a></li>
					<li><a href="<%=request.getContextPath() %>/front_end/dateitem/dateitem.do?action=list_buyer_history">�L�h�����|���</a></li>
					</ul>
  
  <table class="table text-align:center">
	<tr>
		<th align="center">�s��</th>
		<th align="center">�ɶ�</th>
		<th align="center">��a</th>
<th>������G</th>
	</tr>
<%@ include file="page3.file"%>
<c:forEach var="dateitem" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
	<tr align='center' valign='middle'>
			<td>${dateitem.dateItemNo}</td>
			<td>${dSvc.getTimeForItem(dateitem.dateMeetingTime)}</td>
			<td>${dateitem.sellerNo}</td>
			<td><c:if test="${dateitem.dateItemStatus==3}">
  			�������
			</c:if>
			<c:if test="${dateitem.dateItemStatus==2}">
  			�������
			</c:if>
			
		</tr>
  </c:forEach>
</table>

<%@ include file="footer.file"%>





