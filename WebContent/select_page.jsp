<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.news.model.*"%>

<html>
<head>
<title>NewsTest Home</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>News Backend</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for News Backend</p>

<h3>��Ƭd��:</h3>
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

<ul>
  <li><a href='<%=request.getContextPath()%>/back_end/about_us/news/listAllNews.jsp'>List</a> all News. </li>
  <li><a href='<%=request.getContextPath()%>/back_end/about_us/news/addNews.jsp'>Add</a> something New.</li>
  
  <br>
  
  <li>
    <FORM METHOD="post" ACTION="<%= request.getContextPath() %>/back_end/news/news.do" >
        <b>��J�̷s�����s�� (�p0001):</b>
        <input type="text" name="newsNo">
        <input type="submit" value="�d��">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

<%--   <jsp:useBean id="EmpService" scope="page" class="com.Emp.model.EmpService" /> --%>
   
  <li>

     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do" >
       <b>��ܭ��u�s��:</b>
       <select size="1" name="empNo">
         <c:forEach var="emp" items="${empSvc.all}" > 
          <option value="${emp.empno}">${emp.empno}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="getEmpNo_For_Display">
    </FORM>
  </li>

<li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do" >
       <b>��ܭ��u�m�W:</b>
       <select size="1" name="empName">
         <c:forEach var="empname" items="${empSvc.all}" > 
          <option value="${emp.empname}">${emp.empname}
         </c:forEach>   
       </select>
       <input type="submit" value="�e�X">
       <input type="hidden" name="action" value="getEmpName_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do" >
       <b>��J�̷s�������D:</b>
       <input type="text" name="newsTitle">
       <input type="submit" value="�d��">
       <input type="hidden" name="action" value="getRealtive_For_Title">
     </FORM>
  </li>
  
    <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do" >
       <b>��J�̷s�������e:</b>
       <input type="text" name="newsContent">
       <input type="submit" value="�d��">
       <input type="hidden" name="action" value="getRealtive_For_Content">
     </FORM>
  </li>
  
<%--   
	<%
 	News news = (News) request.getAttribute("news"); //EmpServlet.java (Concroller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
	%>
 
  <li>
 		<FORM>
 		<b>�o�G���:</b>
 		    <input class="cal-TextBox"
 			onFocus="this.blur()" size="9" readonly type="text" name="newsdate" value="<%=news.getNewsDate()%>">
 			<a class="so-BtnLink"
 			href="javascript:calClick();return false;"
 			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
 			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
 			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hiredate','BTN_date');return false;">
 		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"></a>
 		</FORM>
 	</li>
--%>

<%-- �U�νƦX�d��-�H�U���-�i�H�N�W�� 
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/news/news.do" name="form1">
        <b><font color=blue>�U�νƦX�d��:</font></b> <br>
        <b>��J�̷s�����s��:</b>
        <input type="text" name="newsno" value="1"><br>
           
       <b>��J���u�s��:</b>
       <input type="text" name="empno" value="6001"><br>
       
       <b>��ܭ��u:</b>
       <select size="1" name="ename" >
          <option value="">
         <c:forEach var="emp" items="${empSvc.all}" > 
          <option value="${emp.empno}">${emp.ename}
         </c:forEach>   
       </select><br>
       
       <b>��J�̷s�������D:</b>
       <input type="text" name="newstitle" value="�o�O���i"><br>
       
       <b>��J�̷s�������e:</b>
       <input type="text" name="newscontent" value="���i���e�b�o"><br>
           
       <b>�o�G���:</b>
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="hiredate" value="2017-01-01">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hiredate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"></a>
		        
        <input type="submit" value="�e�X">
        <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
     </FORM>
  </li>
</ul>
--%>
</body>

</html>
