<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- �U�νƦX�d��-�i�ѫȤ��select_page.jsp�H�N�W�����Q�d�ߪ���� --%>
<%-- �����u�@���ƦX�d�߮ɤ����G�m�ߡA�i���ݭn�A�W�[�����B�e�X�ק�B�R�����\��--%>

<jsp:useBean id="listNews_ByCompositeQuery" scope="request" type="java.util.List" />
<jsp:useBean id="newsService" scope="page" class="com.news.model.NewsService" />
<html>
<head>
<title>�ƦX�d�� - listEmps_ByCompositeQuery.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=blue>
���U�νƦX�d��-�i�ѫȤ��select_page.jsp�H�N�W�����Q�d�ߪ����<br>
�������u�@���ƦX�d�߮ɤ����G�m�ߡA�i���ݭn�A�W�[�����B�e�X�ק�B�R�����\��:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3><font color=red>�ƦX�d��</font>�̷s���� - listNews_ByCompositeQuery.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="" width="" height="" border="">�^����</a>
		</td>
	</tr>
</table>


<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>�̷s�����s��</th>
		<th>�o�G���u�s��</th>
		<th>�̷s�������D</th>
		<th>�̷s�������e</th>
		<th>�o�G�]��s�^���</th>
		
	</tr>
	<c:forEach var="news" items="${listEmps_ByCompositeQuery}">
		<tr align='center' valign='middle'>
			<td>${empVO.empno}</td>
			<td>${empVO.ename}</td>
			<td>${empVO.job}</td>
			<td>${empVO.hiredate}</td>
			<td>${empVO.sal}</td>
			<td>${empVO.comm}</td>			
			<td><c:forEach var="deptVO" items="${deptSvc.all}">
                    <c:if test="${empVO.deptno==deptVO.deptno}">
	                    ${deptVO.deptno}�i${deptVO.dname} - ${deptVO.loc}�j
                    </c:if>
                </c:forEach>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
