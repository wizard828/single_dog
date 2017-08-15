<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="utf-8"></meta>
<meta content="IE=edge" http-equiv="X-UA-Compatible"></meta>
<meta content="width=device-width, initial-scale=1.0, shrink-to-fit=no" name="viewport"></meta>

<title>Backend-Index</title>

<link href="<%= request.getContextPath() %>/back_end/css/bootstrap.css" rel="stylesheet"></link>
<link href="<%= request.getContextPath() %>/back_end/css/nav.css" rel="stylesheet"></link>
<link href="<%= request.getContextPath() %>/back_end/css/colorplan.css" rel="stylesheet"></link>
<!-- Custom CSS -->
<link href="<%= request.getContextPath() %>/back_end/css/modern-business.css" rel="stylesheet"></link>
<!-- Custom Fonts -->
<link href="<%= request.getContextPath() %>/back_end/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"></link>
<link href="<%= request.getContextPath() %>/back_end/css/backend.css" rel="stylesheet"></link>

<!--[if lt IE 9]>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
       
</head>

<style type="text/css">

#btn btn-success btn-md{
    margin-left: auto;
    margin-bottom: 1em; 
    }
    
</style>

    <body>
        <nav class="navbar navbar-light navbar-fixed-top" id="emerald-nav" role="navigation">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button class="navbar-toggle" data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" type="button">
                        <span class="sr-only">
                            Toggle navigation
                        </span>
                        <span class="icon-bar">
                        </span>
                        <span class="icon-bar">
                        </span>
                        <span class="icon-bar">
                        </span>
                    </button>
                    <a class="navbar-brand logo" href="index.html">
                        �d��You&Me
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                    </ul>
                    <div class="nav collapse navbar-collapse navbar-right" id="login">
                        <ul class="nav navbar-nav">
                            <li>
                                <a href="contact.html">
                                    �޲z���n�X
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                    <!-- /.container -->
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-2 postion-left-group-b">
                    <div id="menu">
                        <div class="panel list-group list-color">
                            <a class="list-group-item" href="">
                                ��ݭ���
                            </a>
                            <a class="list-group-item" data-parent="#menu" data-target="#sm1" data-toggle="collapse" href="#">
                                �e�ݬݪO�޲z
                                <span class="glyphicon glyphicon-triangle-bottom pull-right">
                                </span>
                            </a>
                            <div class="sublinks collapse" id="sm1">
                                <a class="list-group-item small" href="#">
                                    �ۿO���޲z
                                </a>
                                <a class="list-group-item small" href="#">
                                    �̷s�����޲z
                                </a>
                            </div>
                            <a class="list-group-item" data-parent="#menu" data-target="#sm2" data-toggle="collapse" href="#">
                                �|���b���޲z
                                <span class="glyphicon glyphicon-triangle-bottom pull-right">
                                </span>
                            </a>
                            <div class="sublinks collapse" id="sm2">
                                <a class="list-group-item small" href="#">
                                    �@��|���޲z
                                </a>
                                <a class="list-group-item small" href="#">
                                    �\�U�|���޲z
                                </a>
                            </div>
                            <a class="list-group-item" data-parent="#menu" data-target="#sm3" data-toggle="collapse" href="#">
                                �ӫ��޲z
                                <span class="glyphicon glyphicon-triangle-bottom pull-right">
                                </span>
                            </a>
                            <div class="sublinks collapse" id="sm3">
                                <a class="list-group-item small" href="#">
                                    �ӫ~�޲z
                                </a>
                                <a class="list-group-item small" href="#">
                                    �q��޲z
                                </a>
                            </div>
                            <a class="list-group-item" data-parent="#menu" data-target="#sm4" data-toggle="collapse" href="#">
                                ���|�ӶD�޲z
                                <span class="glyphicon glyphicon-triangle-bottom pull-right">
                                </span>
                            </a>
                            <div class="sublinks collapse" id="sm4">
                                <a class="list-group-item small" href="#">
                                    ���|�ӫ~���|�޲z
                                </a>
                                <a class="list-group-item small" href="#">
                                    ���|�ӫ~�ӶD�޲z
                                </a>
                            </div>
                            <a class="list-group-item" href="#">
                                ���ʼf��
                            </a>
                            <a class="list-group-item" href="#">
                                �޲z���v���޲z
                            </a>
                            <a class="list-group-item" href="#">
                                �\�U�f��
                            </a>
                            <a class="list-group-item" href="#">
                                �ޯ����H�޲z
                            </a>
                        </div>
                    </div>
                </div>
                <!-- ���Y�b�o -->
                <div class="jumbotron">
                    <h2>
                        ����ڭ�
                    </h2>
                    <p>
                        �������]�t�̷s�����BFAQ�B�ϥΪ̴���FAQ�B�s�i�B�ۿO���޲z
                    </p>
                    <!-- �D�n�\��ϥ� -->
                    <div class="row">
                        <!--  <div class="col-xs-12 col-sm-2">
                            <div class="to-do-list">
                                <button class="btn btn-success btn-md" style="margin-left: 5em; margin-bottom: 1em;" type="to-do-list-button">
                                    What to Do?
                                    <span class="badge">
                                        10
                                    </span>
                                </button>
                                <a data-toggle="to-do-list" href="#" title="Get Your Job Done!">
                                    <img alt="" src="<%= request.getContextPath() %>/back_end/images/about_us/list.png" style="margin-left: 3em; width:200px; height:200px; border:10;">
                                    </img>
                                </a>
                            </div>
                        </div> -->
                        <div class="col-xs-12 col-sm-2">
                            <div class="news-list">
                                <button class="btn btn-success btn-md" type="news-button">
                                    Post Something New?
                                </button>
                                <a data-toggle="news-list" href="<%= request.getContextPath() %>/back_end/about_us/news/news_select_page.jsp" title="Got New Stuff?">
                                    <img alt="" src="<%= request.getContextPath() %>/back_end/about_us/images/news.png" style="margin-left: auto; width:100%; height:100%; border:10;">
                                    </img>
                                </a>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-2">
                            <div class="faq-list">
                                <button class="btn btn-success btn-md" type="faq-button">
                                    Got New FAQ for User?
                                </button>
                                <a data-toggle="faq-list" href="<%= request.getContextPath() %>/back_end/about_us/faq/faq_select_page.jsp"" title="Get New FAQ?">
                                    <img alt="" src="<%= request.getContextPath() %>/back_end/about_us/images/faq.png" style="margin-left: auto; width:100%; height:100%; border:10;">
                                    </img>
                                </a>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-2">
                            <div class="user-submit-list">
                                <button class="btn btn-success btn-md" type="user-submit-button">
                                  User Submit FAQ!
                                    <span class="badge">
                                        7
                                    </span>
                                </button>
                                <a data-toggle="user-submit-list" href="#" title="Someone Just Submit the Problem">
                                    <img alt="" src="<%= request.getContextPath() %>/back_end/about_us/images/user_submit.png" style="margin-left: auto; width:100%; height:100%; border:10;">
                                    </img>
                                </a>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-2">
                            <div class="ad-list">
                                <button class="btn btn-success btn-md" type="ad-button">
                                    Nees Some ADs?
                                    <span class="badge">
                                        7
                                    </span>
                                </button>
                                <a data-toggle="ad-list" href="#" title="No ADs No Wage!">
                                    <img alt="" src="<%= request.getContextPath() %>/back_end/about_us/images/billboard.png" style="margin-left: auto; width:100%; height:100%; border:10;">
                                    </img>
                                </a>
                            </div>
                        </div>
                        <div class="col-xs-12 col-sm-2">
                            <div class="slide-manage">
                                <button class="btn btn-success" type="slide-button">
                                    Want a New Slide?
                                </button>
                                <a data-toggle="slide-manage" href="#" title="Post Something New Plz">
                                    <img alt="" src="<%= request.getContextPath() %>/back_end/about_us/images/slider.png" style="margin-left: auto; width:100%; height:100%; border:10;">
                                    </img>
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- �����D�n�񤰻� -->
                    <div class="container" style="margin-top:2em; margin-left: 20em">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    ���D
                                </h3>
                            </div>
                            <div class="panel-body">
                                ���e��r
                            </div>
                        </div>
                    </div>
                </div>
                <!-- �����b�o�� -->
                <a class="btn btn-primary" data-toggle="modal" href="#modal-id">
                    �T�{
                </a>
                <div class="modal fade" id="modal-id">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button aria-hidden="true" class="close" data-dismiss="modal" type="button">            
                                </button>
                                <h4 class="modal-title">
                                    �T�{���D�b�o
                                </h4>
                            </div>
                            <div class="modal-body">
                                �ϥ��N�O�T�{���o��
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-default" data-dismiss="modal" type="button">
                                    ����
                                </button>
                                <button class="btn btn-primary" type="button">
                                    �T�w
                                </button>
                            </div>
                        </div>
                    </div>
                </div>


<footer class="footer" style="background-color: black; color: white; padding: 1em; margin-top: 1em;">
  <div class="container">
    <p class="text-muted"><h4>�o�Osticky footer</h4></p>
  </div>
</footer>


                <script src="https://code.jquery.com/jquery.js">
                </script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js">
                </script>
            </div>
        </div>
    </body>
</html>