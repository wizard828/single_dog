<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.faq.model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="">

<% 

FaqService faqService = new FaqService();
List<Faq> faqList = faqService.getAll();
request.setAttribute("faqList", faqList);

%>

<head>
    <!--  ===================================================
    <meta charset="UTF-8"> ==================================
    =========================================================-->
    <meta charset="BIG-5">
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

/*改寫colorplan裡面的這個標籤*/
.postion-left-group{
/*   position:relative; */
/*   margin-top: 28rem; */
    margin-top:2rem;
  display:block;
}

/*並在你的colorplan CSS中加入這個*/
.img-bg{
    opacity:1;
    background-color:#ccc;
    max-width: 100%;
    display: block;
    margin: 0 auto;
}

/*麵包屑*/
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

#user_submit {
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
                <a class="navbar-brand logo" href="index.html">寵物You&amp;Me</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="date.html">約會商品</a>
                    </li>
                    <li>
                        <a href="product.html">商城</a>
                    </li>
                    <li>
                        <a href="activity.html">活動</a>
                    </li>
                    <li>
                        <a href="diary.html">寵物日誌</a>
                    </li>
                </ul>
                <div class="nav collapse navbar-collapse navbar-right" id="login">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="about.html">購物車</a>
                        </li>
                        <li>
                            <a href="about.html">站內信</a>
                        </li>
                        <li>
                            <a href="services.html">會員專區</a>
                        </li>
                        <li>
                            <a href="contact.html">登出</a>
                        </li>
                    </ul>
                </div>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
<div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-2">
             <div class="frontend"><img src="<%= request.getContextPath() %>/front_end/images/logo-sp.png" class="img-rounded img-bg try-color">
             </div>
                <div id="menu" data-spy="affix" data-offset-top="200">
					<div class="panel list-group list-color">
						<a class="list-group-item" data-parent="#menu" data-target="#sm1"
							data-toggle="collapse" href="#"> 註冊問題 <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
						<div class="sublinks collapse" id="sm1">
							<a class="list-group-item small " href="# "> 問題1 </a> <a
								class="list-group-item small " href="# "> 問題2 </a> <a
								class="list-group-item small " href="# "> 問題3 </a> <a
								class="list-group-item small " href="# "> 問題4 </a> <a
								class="list-group-item small " href="# "> 問題5 </a>
						</div>
						<a class="list-group-item" data-parent="#menu" data-target="#sm2"
							data-toggle="collapse" href="#"> 登入問題 <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
						<div class="sublinks collapse" id="sm2">
							<a class="list-group-item small " href="# "> 問題1 </a> <a
								class="list-group-item small " href="# "> 問題2 </a> <a
								class="list-group-item small " href="# "> 問題3 </a> <a
								class="list-group-item small " href="# "> 問題4 </a> <a
								class="list-group-item small " href="# "> 問題5 </a>
						</div>
						<a class="list-group-item" data-parent="#menu" data-target="#sm3"
							data-toggle="collapse" href="#"> 約會問題 <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
						<div class="sublinks collapse" id="sm3">
							<a class="list-group-item small " href="# "> 問題1 </a> <a
								class="list-group-item small " href="# "> 問題2 </a> <a
								class="list-group-item small " href="# "> 問題3 </a> <a
								class="list-group-item small " href="# "> 問題4 </a> <a
								class="list-group-item small " href="# "> 問題5 </a>
						</div>
						<a class="list-group-item" data-parent="#menu" data-target="#sm4"
							data-toggle="collapse" href="#"> 交易問題 <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
						<div class="sublinks collapse" id="sm4">
							<a class="list-group-item small " href="# "> 問題1 </a> <a
								class="list-group-item small " href="# "> 問題2 </a> <a
								class="list-group-item small " href="# "> 問題3 </a> <a
								class="list-group-item small " href="# "> 問題4 </a> <a
								class="list-group-item small " href="# "> 問題5 </a>
						</div>
						<a class="list-group-item" data-parent="#menu" data-target="#sm5"
							data-toggle="collapse" href="#"> 其他問題 <span
							class="glyphicon glyphicon-triangle-bottom pull-right"> </span>
						</a>
						<div class="sublinks collapse" id="sm5">
							<a class="list-group-item small " href="# "> 問題1 </a> <a
								class="list-group-item small " href="# "> 問題2 </a> <a
								class="list-group-item small " href="# "> 問題3 </a> <a
								class="list-group-item small " href="# "> 問題4 </a> <a
								class="list-group-item small " href="# "> 問題5 </a>
						</div>
					</div>
				</div>
			</div>






            <div class="col-xs-12 col-sm-10">
                <div class="row">
 


<!-- 把你要放的內容放在這=====================================================

        例如
        <div class="col-xs-12 col-sm-3">    1234</div>
        <div class="col-xs-12 col-sm-3">    1234</div>
        <div class="col-xs-12 col-sm-3">    1234</div>
        <div class="col-xs-12 col-sm-3">    1234</div>


一個完整的<div></div>以及隔線================================================ 
但要注意你一開始是不是有把結尾的</div>放在footer.file裡面-->


<!-- 幻燈片這這 -->
			<div class="col-xs-12 col-sm-12 ">
				<div>
					<div class="row">
						<div class="col-sm-10 col-sm-offset-1">
							<div class="carousel slide" data-ride="carousel" id="carousel-id">
								<!-- 幻燈片小圓點區 -->
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
								<!-- 幻燈片主圖區 -->
								<div class="carousel-inner">
									<div class="item">
										<img alt=""
											src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>標題</h1>
												<p>內文</p>
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
												<h1>標題</h1>
												<p>內文？</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														更多 </a>
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
												<h1>標題</h1>
												<p>內文？</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														更多 </a>
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
												<h1>標題</h1>
												<p>內文？</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														更多 </a>
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
												<h1>標題</h1>
												<p>內文？</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														更多 </a>
												</p>
											</div>
										</div>
										</img>
									</div>
									
									<div class="item active">
										<img alt="" src="<%= request.getContextPath() %>/front_end/images/pets_try3_resized.jpg">
										<div class="container">
											<div class="carousel-caption">
												<h1>標題</h1>
												<p>內文</p>
												<p>
													<a class="btn btn-lg btn-primary" href="#" role="button">
														詳細內容 </a>
												</p>
											</div>
										</div>
										</img>
									</div>
								</div>
								<!-- 上下頁控制區 -->
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
					<!-- 搜尋表單 -->
					<div>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input class="form-control" placeholder="請輸入關鍵字" type="text">
								</input>
							</div>
							<button class="btn btn-default" type="submit">搜尋</button>
						</form>
					</div>

<!-- 麵包屑在這 -->
					<div class="breadcrumb-container">
						<div class="breadcrumb-row">
							<ol class="breadcrumb">
								<li><a href="#"> 首頁 </a></li>
								<li><a href="#"> 常見問題 </a></li>
								<li class="active">太神啦~</li>
							</ol>
						</div>
					</div>
 
<!-- 查詢功能在這 -->
<li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
       <input type="text" name="faqCategory" placeholder="請輸入想查詢的類別">
       <input type="submit" value="查詢">
       <input type="hidden" name="action" value="getRealtive_For_Category">
 
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
       <input type="text" name="faqTitle" placeholder="請輸入想查詢的標題">
       <input type="submit" value="查詢">
       <input type="hidden" name="action" value="getRealtive_For_Title">
  
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back_end/faq/faq.do" >
       <input type="text" name="faqAnswer" placeholder="請輸入想查詢的答案">
       <input type="submit" value="查詢">
       <input type="hidden" name="action" value="getRealtive_For_Answer">
</li>
  
					
					
					<!-- faq摺疊選單 -->
					
					<div class="panel-group" id="accordion">						
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
								
									<a data-parent="#accordion" data-toggle="collapse"
										href="#collapseOne"> ${faq.faqTitle} </a>
								</h3>
							</div>
							
							<div class="panel-collapse collapse in" id="collapseOne">
								<div class="panel-body">
									<!-- faq重點在這 -->
									<div class="question">
										<blockquote>
											<p>這是ㄧ個blockquote</p>
											<cite class=""> 單身狗關心您 </cite>
										</blockquote>
									</div>
									<div class="answer">
										<h4>${faq.faqAnswer}</h4>
										
									</div>
									
								</div>
								
							</div>
						
						</div>
						
						<div class="panel panel-success">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-parent="#accordion" data-toggle="collapse"
										href="#collapseTwo"> 
										
										<c:forEach var="faq" items="${faqList}">
								<c:if test="${faq.faqCategory =='寵物走失1'}">
								<div>${faq.faqTitle}</div>
								<div>${faq.faqAnswer}</div>
								</c:if>
								</c:forEach>
										
										 </a>
								</h4>
							</div>
							<div class="panel-collapse collapse" id="collapseTwo">
								
								<c:forEach var="faq" items="${faqList}">
								<c:if test="${faq.faqCategory =='寵物走失1'}">
								<div>${faq.faqTitle}</div>
								<div>${faq.faqAnswer}</div>
								</c:if>
								</c:forEach>
								
							</div>
							
						</div>
						
						<div class="panel panel-success">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-parent="#accordion" data-toggle="collapse"
										href="#collapseTwo"> 問題在這邊。第 2 部分--show 方法 </a>
								</h4>
							</div>
							<div class="panel-collapse collapse" id="collapseTwo">
								<div class="panel-body">Nihil anim keffiyeh helvetica,
									craft beer labore wes anderson cred nesciunt sapiente ea
									proident. Ad vegan excepteur butcher vice lomo.</div>
							</div>
						</div>
						<div class="panel panel-info">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-parent="#accordion" data-toggle="collapse"
										href="#collapseThree"> 問題在這邊。第 3 部分--toggle 方法 </a>
								</h4>
							</div>
							<div class="panel-collapse collapse" id="collapseThree">
								<div class="panel-body">Nihil anim keffiyeh helvetica,
									craft beer labore wes anderson cred nesciunt sapiente ea
									proident. Ad vegan excepteur butcher vice lomo.</div>
							</div>
						</div>
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-parent="#accordion" data-toggle="collapse"
										href="#collapseFour"> 問題在這邊。第 4 部分--options 方法 </a>
								</h4>
							</div>
							<div class="panel-collapse collapse" id="collapseFour">
								<div class="panel-body">Nihil anim keffiyeh helvetica,
									craft beer labore wes anderson cred nesciunt sapiente ea
									proident. Ad vegan excepteur butcher vice lomo.</div>
							</div>
						</div>
					</div>
					
					
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
					


<!-- 暫時用不到 -->
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
<!--                         <li><a href="#">前一頁</a></li> -->
<!--                         <li><a href="#">下一頁</a></li> -->
<!--                     </ul> -->
<!--                 </div> -->
                
                
                	<!-- 這邊是user submit -->
					<div class="container">
						<div class="row">
							<div class="col-md-12 col-md-12">
								<div class="user-submit">
									<h4>
										以上解答有幫助到你嗎? <input type="radio" name="yes" value="yes">有
										<input type="radio" name="no" value="no">沒有
									</h4>
									<div class="dropdown">
										<h4>
											問題類別 <select id="faq_category">
												<option value="defaultValue">請選擇</option>
												<option value="">類別1</option>
												<option value="">類別2</option>
												<option value="">類別3</option>
												<option value="">類別4</option>
												<option value="">類別5</option>
											</select> 主旨<input type="text" id="user_submit_title"
												placeholder="你的問題是?">
										</h4>

									</div>
									<!-- placegolder 業障重 -->
									<textarea class="user_submit" id="user_submit"
										placeholder="請描述一下問題內容" onfocus="this.select()" required
										data-validation-required-message="Please enter a message.">
                                </textarea>
								</div>
								<div class="btn-group">
									<a href="#" class="btn btn-primary" role="button">確認</a> <a
										href="#" class="btn btn-default" role="button">取消</a>
								</div>
								<!-- 下面測試用 -->
								<!-- <script>
                                function getValue() {
                                    var content = document.getElementById("user_submit").value;
                                    document.getElementById("user_submit").innerHTML = content;
                                }
                                </script> -->
								<!-- 
                                用 JavaScript 抓 <textarea> 目前內部現有值請用 value ，抓一開始初始預設值請用 defaultValue ，就是不要用 innerHTML 。因為 <textarea> innerHTML 在 IE 是目前內部現有值，在 Firefox 、 Chrome 是初始預設值。
                                 <script>
                                var content = document.getElementById('user_submit');
                                </script>
                                <input type="button" value="value" onclick="alert(content.value)">
                                <input type="button" value="defaultValue" onclick="alert(content.defaultValue)">
                                <input type="button" value="innerHTML" onclick="alert(content.innerHTML)">
                                 -->
								<!-- 測試到這 -->

							</div>
						</div>
					</div>
                
                
                <div class="postion-left-group-b">
                    <footer>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="col-sm-3">
                                    <p>Copyright 寵物You&amp;Me 2017</p>
                                </div>
                                <div class="col-sm-3">
                                    <p>關於我們</p>
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
                <a href="#">
                    <div class="" id="fixedbutton-talk">
                        <button class="button btn-lg btn-primary active">
                            交易聊天室
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