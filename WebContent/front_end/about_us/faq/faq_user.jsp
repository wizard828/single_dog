<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.faq.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="">



<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Title Page</title>
    <link href="<%= request.getContextPath() %>/front_end/css/bootstrap.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/front_end/css/nav.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/front_end/css/colorplan.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%= request.getContextPath() %>/front_end/css/modern-business.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/front_end/css/date.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<%= request.getContextPath() %>/front_end/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="<%= request.getContextPath() %>/front_end/css/frontend.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>

/*��gcolorplan�̭����o�Ӽ���*/
.postion-left-group{
/*   position:relative; */
/*   margin-top: 28rem; */
    margin-top:2rem;
  display:block;
}

/*�æb�A��colorplan CSS���[�J�o��*/
.img-bg{
    opacity:1;
    background-color:#ccc;
    max-width: 100%;
    display: block;
    margin: 0 auto;
}

/* �ƥΰ����d���s */
input[type="submit"]{
 color: #000000;
 width: 100%;
}

/*�ѥ]�h*/
.breadcrumb-container {
	margin-top: 0.5em;
}

#faq_category {
	margin-right: 1em;
}

#user_submit_title {
	width: 50%;
	margin-left: 1em;
}

.user_submit {
	resize: none;
	width: 100%;
	height: 100px;
	font-size: 16px;
}

</style>



</head>

<body>
    <nav id="emerald-nav" class="navbar navbar-light navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo" href="index.html">�d��You&amp;Me</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="date.html">���|�ӫ~</a>
                    </li>
                    <li>
                        <a href="product.html">�ӫ�</a>
                    </li>
                    <li>
                        <a href="activity.html">����</a>
                    </li>
                    <li>
                        <a href="diary.html">�d����x</a>
                    </li>
                </ul>
                <div class="nav collapse navbar-collapse navbar-right" id="login">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="about.html">�ʪ���</a>
                        </li>
                        <li>
                            <a href="about.html">�����H</a>
                        </li>
                        <li>
                            <a href="services.html">�|���M��</a>
                        </li>
                        <li>
                            <a href="contact.html">�n�X</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
<!-- �쥻�Ӧ��Ϊ������d -->
<div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-2">
             <div class="frontend"><img src="<%= request.getContextPath() %>/front_end/images/logo-sp.png" class="img-rounded img-bg try-color">
             </div>
                <div id="menu" data-spy="affix" data-offset-top="200">
					<div class="panel list-group list-color">
						<a class="list-group-item" data-parent="#menu" data-target="#sm1"
							data-toggle="collapse" href="" name="faqCategory" value="���U���D" > ���U���D <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
						
						<a class="list-group-item" data-parent="#menu" data-target="#sm2"
							data-toggle="collapse" href="" name="faqCategory" value="�n�J���D"> �n�J���D <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>

						<a class="list-group-item" data-parent="#menu" data-target="#sm3"
							data-toggle="collapse" href="" name="faqCategory" value="���|���D"> ���|���D <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>

						<a class="list-group-item" data-parent="#menu" data-target="#sm4"
							data-toggle="collapse" href="" name="faqCategory" value="������D"> ������D <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>

						<a class="list-group-item" data-parent="#menu" data-target="#sm5"
							data-toggle="collapse" href="" name="faqCategory" value="��L���D"> ��L���D <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
	
<!-- �ƥΪ������d   -->
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
     <input type="submit" name="faqCategory" value="���U���D">
     <input type="hidden" name="action" value="faq_for_user">
	 </FORM>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
     <input type="submit" name="faqCategory" value="�n�J���D">
     <input type="hidden" name="action" value="faq_for_user">
	 </FORM>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
     <input type="submit" name="faqCategory" value="���|���D">
     <input type="hidden" name="action" value="faq_for_user">
	 </FORM>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
     <input type="submit" name="faqCategory" value="������D">
     <input type="hidden" name="action" value="faq_for_user">
	 </FORM>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
	<input type="submit" name="faqCategory" value="��L���D">
	<input type="hidden" name="action" value="faq_for_user">
	</FORM>
						
<%-- 						<%=request.getContextPath()%>/back_end/faq/faq.do?faqCategory=��L���D&action=getRealtive_For_Category --%>
						
					</div>
				</div>
			</div>

            <div class="col-xs-12 col-sm-10">
                <div class="row">
 


<!-- ��A�n�񪺤��e��b�o=====================================================

        �Ҧp
        <div class="col-xs-12 col-sm-3">    1234</div>
        <div class="col-xs-12 col-sm-3">    1234</div>
        <div class="col-xs-12 col-sm-3">    1234</div>
        <div class="col-xs-12 col-sm-3">    1234</div>


�@�ӧ��㪺<div></div>�H�ιj�u================================================ 
���n�`�N�A�@�}�l�O���O���⵲����</div>��bfooter.file�̭�-->


<!-- �ۿO���o�o -->
			<div class="col-xs-12 col-sm-12 ">
				<div>
					<div class="row">
						<div class="col-sm-10 col-sm-offset-1">
							<div class="carousel slide" data-ride="carousel" id="carousel-id">
								<!-- �ۿO���p���I�� -->
								<ol class="carousel-indicators">
									<li class="" data-slide-to="0" data-target="#carousel-id">
									</li>
									<li class="" data-slide-to="1" data-target="#carousel-id">
									</li>
									<li class="" data-slide-to="2" data-target="#carousel-id">
									</li>
									<li class="" data-slide-to="3" data-target="#carousel-id">
									</li>
									<li class="" data-slide-to="4" data-target="#carousel-id">
									</li>
									<li class="" data-slide-to="5" data-target="#carousel-id">
									</li>
									<li class="active" data-slide-to="6" data-target="#carousel-id">
									</li>
								</ol>
								<!-- �ۿO���D�ϰ� -->
								<div class="carousel-inner">
									<div class="item">
										<img alt=""
											src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>�ݻP��</h1>
												<p>����</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														Sign up today </a>
												</p>
											</div>
										</div>
										</img>
									</div>
									<div class="item">
										<img alt=""
											src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>FAQ</h1>
												<p>����H</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														��h </a>
												</p>
											</div>
										</div>
										</img>
									</div>
									<div class="item">
										<img alt=""
											src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>�ݻP��</h1>
												<p>����H</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														��h </a>
												</p>
											</div>
										</div>
										</img>
									</div>
									<div class="item">
										<img alt=""
											src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>FAQ</h1>
												<p>����H</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														��h </a>
												</p>
											</div>
										</div>
										</img>
									</div>
									<div class="item">
										<img alt=""
											src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>�ݻP��</h1>
												<p>����H</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														��h </a>
												</p>
											</div>
										</div>
										</img>
									</div>
									
									<div class="item active">
										<img alt="" src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>FAQ</h1>
												<p>����</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														�ԲӤ��e </a>
												</p>
											</div>
										</div>
										</img>
									</div>
								</div>
								<!-- �W�U������� -->
								<a class="left carousel-control" data-slide="prev"
									href="#carousel-id"> <span
									class="glyphicon glyphicon-chevron-left"> </span>
								</a> <a class="right carousel-control" data-slide="next"
									href="#carousel-id"> <span
									class="glyphicon glyphicon-chevron-right"> </span>
								</a>
							</div>
						</div>
					</div>
					
					<!-- �j�M��� -->
<!-- 					<div> -->
<!-- 						<form class="navbar-form navbar-right" role="search"> -->
<!-- 						<div class="form-group"> -->

<!-- <!-- �d�ߥ\��b�o --> -->

<%--      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" > --%>
<!--      <input type="text" name="faqCategory" placeholder="�п�J�Q�d�ߪ����O"> -->
<!--      <button class="btn btn-success" type="submit">�j�M</button> -->
<!--      <input type="hidden" name="action" value="faq_for_user"> -->
<!--  	 </FORM> -->
     
<%--      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" > --%>
<!--      <input type="text" name="faqTitle" placeholder="�п�J�Q�d�ߪ����D"> -->
<!--      <button class="btn btn-success" type="submit">�j�M</button> -->
<!--      <input type="hidden" name="action" value="getRealtive_For_Title"> -->
<!--      </FORM> -->
     
<%--      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" > --%>
<!--      <input type="text" name="faqAnswer" placeholder="�п�J�Q�d�ߪ�����"> -->
<!--      <button class="btn btn-success" type="submit">�j�M</button> -->
<!--      <input type="hidden" name="action" value="getRealtive_For_Answer"> -->
<!-- 	 </FORM> -->

<!-- 						</div> -->
<!-- 						</form> -->
<!-- 					</div> -->

<!-- �ѥ]�h�b�o -->
					<div class="breadcrumb-container">
						<div class="breadcrumb-row">
							<ol class="breadcrumb">
								<li><a href="<%=request.getContextPath() %>/front_end/index.html"> ���� </a></li>
								<li><a href="<%=request.getContextPath() %>/front_end/about_us/faq/faq_user.jsp"> �`�����D </a></li>
							</ol>
						</div>
					</div>
					
					
					<!-- faq�P�|��� -->
					
					<div class="panel-group" id="accordion">						
							<div class="panel-collapse collapse in" id="collapseOne">
									<!-- faq���I�b�o -->
							</div>
					</div>
						
						<div class="panel panel-success">
								
								<% int count=0; %>
								<c:forEach var="faq" items="${faqList}">
								<div class="panel-heading">
								<h4 class="panel-title">
									<a data-parent="#accordion" data-toggle="collapse"
										href="#FAQ<%=count%>"> ${faq.faqTitle}</a>
								</h4>
						        </div>
								<div class="panel-collapse collapse" id="FAQ<%=count%>">
									<div class="panel-body">${faq.faqAnswer}</div>
								</div>
							<% count++;%>
								</c:forEach>
								
						</div>
							
<!-- 						<div class="panel panel-success"> -->
<!-- 							<div class="panel-heading"> -->
<!-- 								<h4 class="panel-title"> -->
<!-- 									<a data-parent="#accordion" data-toggle="collapse" -->
<!-- 										href="#collapseTwo"> ���D�b�o��C�� 2 ����--show ��k </a> -->
<!-- 								</h4> -->
<!-- 							</div> -->
<!-- 							<div class="panel-collapse collapse" id="collapseTwo"> -->
<!-- 								<div class="panel-body"> -->
<!-- 									<blockquote> -->
<!-- 											<p>�o�O����blockquote</p> -->
<%-- 											<cite class=""> �樭�����߱z </cite> --%>
<!-- 									</blockquote> -->
<!-- 									Nihil anim keffiyeh helvetica, -->
<!-- 									craft beer labore wes anderson cred nesciunt sapiente ea -->
<!-- 									proident. Ad vegan excepteur butcher vice lomo.</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading"> -->
<!-- 								<h4 class="panel-title"> -->
<!-- 									<a data-parent="#accordion" data-toggle="collapse" -->
<!-- 										href="#collapseThree"> ���D�b�o��C�� 3 ����--toggle ��k </a> -->
<!-- 								</h4> -->
<!-- 							</div> -->
<!-- 							<div class="panel-collapse collapse" id="collapseThree"> -->
<!-- 								<div class="panel-body">Nihil anim keffiyeh helvetica, -->
<!-- 									craft beer labore wes anderson cred nesciunt sapiente ea -->
<!-- 									proident. Ad vegan excepteur butcher vice lomo.</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class="panel panel-warning"> -->
<!-- 							<div class="panel-heading"> -->
<!-- 								<h4 class="panel-title"> -->
<!-- 									<a data-parent="#accordion" data-toggle="collapse" -->
<!-- 										href="#collapseFour"> ���D�b�o��C�� 4 ����--options ��k </a> -->
<!-- 								</h4> -->
<!-- 							</div> -->
<!-- 							<div class="panel-collapse collapse" id="collapseFour"> -->
<!-- 								<div class="panel-body">Nihil anim keffiyeh helvetica, -->
<!-- 									craft beer labore wes anderson cred nesciunt sapiente ea -->
<!-- 									proident. Ad vegan excepteur butcher vice lomo.</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
					
					<!--  <script type="text/javascript">
                    $(function() {
                        $('#collapseFour').collapse({
                            toggle: false
                        })
                    });
                    $(function() { $('#collapseTwo').collapse('show') });
                    $(function() { $('#collapseThree').collapse('toggle') });
                    $(function() { $('#collapseOne').collapse('hide') });
                    </script> -->
					


<!-- �ȮɥΤ��� -->
<!--                 <div class="text-center"> -->
<!--                     <ul class="pagination"> -->
<!--                         <li><a href="#">&laquo;</a></li> -->
<!--                         <li><a href="#">1</a></li> -->
<!--                         <li><a href="#">2</a></li> -->
<!--                         <li class="active"><a href="#">3</a></li> -->
<!--                         <li><a href="#">4</a></li> -->
<!--                         <li><a href="#">5</a></li> -->
<!--                         <li><a href="#">&raquo;</a></li> -->
<!--                     </ul> -->
<!--                     <br> -->
<!--                     <ul class="pager"> -->
<!--                         <li><a href="#">�e�@��</a></li> -->
<!--                         <li><a href="#">�U�@��</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
                
                
                	<!-- �o��Ouser submit -->
<%--                 	<form action="<%=request.getContextPath() %>/back_end/faq/faq.do" method="post"> --%>
<!-- 					<div class="container"> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-12 col-md-12"> -->
<!-- 								<div class="user-submit"> -->
<!-- 									<h4> -->
<!-- 										�H�W�ѵ������U��A��? -->
<!-- 										<input type="radio" name="radio" value="yes">�� -->
<!-- 										<input type="hidden" name="action" value="user_insert" > -->
<!-- 										<input type="radio" name="radio" value="no" onclick="alert('yeah~');">�S��<p> -->
<!-- 									</h4> -->
										
<!-- 									<div class="dropdown"> -->
<!-- 										<h4> -->
<!-- 											���D���O <select name="faqCategory"> -->
<!-- 												<option value="defaultValue">�п��</option> -->
<!-- 												<option value="getRealtive_For_Category">���U���D</option> -->
<!-- 												<option value="getRealtive_For_Category">�n�J���D</option> -->
<!-- 												<option value="getRealtive_For_Category">���|���D</option> -->
<!-- 												<option value="getRealtive_For_Category">������D</option> -->
<!-- 												<option value="getRealtive_For_Category">��L���D</option> -->
<!-- 											</select>  -->
<!-- 											�D��<input type="text" name="faqTitle" placeholder="�A�����D�O?"> -->
<!-- 										</h4> -->

<!-- 									</div> -->
<!-- 									placegolder �~�٭� -->
<!-- 									<textarea class="user_submit" name="faqAnswer" placeholder="�дy�z�@�U���D���e" onfocus="this.select()" required -->
<!-- 										data-validation-required-message="Please enter a message."> -->
<!--                                 	</textarea> -->
<!-- 									</div> -->
								
<!-- <!--								<div class="btn-group"> --> -->
<!-- <!-- 									<a href="" class="btn btn-primary" role="button" onclick="safeSubmit" >�T�{</a> <a --> -->
<!-- <!-- 										href="" class="btn btn-default" role="button">����</a> --> -->
<!-- <!-- 								</div> --> -->
								
<!-- 								�T�{submit -->
<!-- 								<button type="submit" class="btn btn-primary btn-mi" data-toggle="modal" data-target="#myModal">�T�{</button> -->
<!-- 								�o��e�X��� -->
<!-- 								<input type="hidden" name="action" value="user_insert" > -->
								
<!-- 								Modal -->
<!-- 								<div id="myModal" class="modal fade" role="dialog"> -->
<!-- 								  <div class="modal-dialog"> -->
								
<!-- 								    Modal content -->
<!-- 								    <div class="modal-content"> -->
<!-- 								      <div class="modal-header"> -->
<!-- 								        <button type="button" class="close" data-dismiss="modal">&times;</button> -->
<!-- 								        <h4 class="modal-title">�P�§A������</h4> -->
<!-- 								      </div> -->
<!-- 								      <div class="modal-body"> -->
<!-- 								        <p>���D�w�g�e�X�o~</p> -->
<!-- 								      </div> -->
<!-- 								      <div class="modal-footer"> -->
<!-- 								        <button type="button" class="btn btn-primary" data-dismiss="modal">����</button> -->
<!-- 								      </div> -->
<!-- 								    </div> -->
								
<!-- 								  </div> -->
<!-- 								</div> -->
<!-- 								</form> -->
								
<!-- 								����submit -->
<!-- 								<button type="button" class="btn btn-danger btn-mi" data-toggle="modal" data-target="#cancle-submit">����</button> -->
								
<!-- 								Modal -->
<!-- 								<div id="cancle-submit" class="modal fade" role="dialog"> -->
								  <div class="modal-dialog">
								
								    <!-- Modal content-->
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal">&times;</button>
								        <h4 class="modal-title">��������</h4>
								      </div>
								      <div class="modal-body">
								        <p>�T�{���U�h�N���򳣨S���F��~</p>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-danger" data-dismiss="modal">�T�w</button>
								      </div>
								    </div>
								
								  </div>
								</div>
								
								
								<!-- �U�����ե� -->
								<!-- <script>
                                function getValue() {
                                    var content = document.getElementById("user_submit").value;
                                    document.getElementById("user_submit").innerHTML = content;
                                }
                                </script> -->
								<!-- 
                                �� JavaScript �� <textarea> �ثe�����{���ȽХ� value �A��@�}�l��l�w�]�ȽХ� defaultValue �A�N�O���n�� innerHTML �C�]�� <textarea> innerHTML �b IE �O�ثe�����{���ȡA�b Firefox �B Chrome �O��l�w�]�ȡC
                                 <script>
                                var content = document.getElementById('user_submit');
                                </script>
                                <input type="button" value="value" onclick="alert(content.value)">
                                <input type="button" value="defaultValue" onclick="alert(content.defaultValue)">
                                <input type="button" value="innerHTML" onclick="alert(content.innerHTML)">
                                 -->
								<!-- ���ը�o -->

							</div>
						</div>
					</div>
                
                
                <div class="postion-left-group-b">
                    <footer>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="col-sm-3">
                                    <p>Copyright �d��You&amp;Me 2017</p>
                                </div>
                                <div class="col-sm-3">
                                    <p>����ڭ�</p>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
                <a href="#">
                    <div class="" id="fixedbutton-talk">
                        <button class="button btn-lg btn-primary active">
                            �����ѫ�
                        </button>
                    </div>
                </a>
                
        </div>
        </div>
</div>

        <script src="https://code.jquery.com/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>