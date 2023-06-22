<%--
  Created by IntelliJ IDEA.
  User: 12935
  Date: 2023/6/22
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="main.models.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>管理员信息添加</title>

    <link href="./css/style.css" rel="stylesheet">
    <link href="./css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->px

</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="index.jsp"><img src="../images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="index.jsp"><img src="images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->
        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li class="active"><a href="index.jsp"><i class="fa fa-home"></i> <span>主页</span></a></li>
            <li class="menu-list"><a href=""><i class="fa fa-laptop"></i> <span>系统管理员</span></a>
                <ul class="sub-menu-list">
                    <li><a href="./Teacher_table.jsp"> 教师信息管理</a></li>
                    <li><a href="./Student_table.jsp"> 学生信息管理</a></li>
                    <li><a href="./health_table.jsp"> 打卡查询</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>校级管理员</span></a>
                <ul class="sub-menu-list">
                    <li><a href="./Teacher_table1.jsp">查看教师信息</a></li>
                    <li><a href="./Student_table2.jsp"> 查看学生信息</a></li>
                    <li><a href="./health_table.jsp">打卡查询</a></li>
                </ul>
            </li>
            <li class="menu-list"><a href=""><i class="fa fa-cogs"></i> <span>院级管理员</span></a>
                <ul class="sub-menu-list">
                    <li><a href="./Student_table.jsp"> 查看学生信息</a></li>
                    <li><a href="./health_table.jsp"> 打卡查询</a></li>
                </ul>
            </li>

            <li class="menu-list"><a href=""><i class="fa fa-envelope"></i> <span>教师每日一报</span></a>
                <ul class="sub-menu-list">
                    <li><a href="mail.jsp">每日打卡</a></li>
                    <li><a href="mail_compose.jsp">健康码显示</a></li>
                </ul>
            </li>


            <li><a href="./login.jsp"><i class="fa fa-sign-in"></i> <span>登出</span></a></li>
        </ul>
        <!--sidebar nav end-->

    </div>
    </div>
    <!-- left side end-->

    <!-- main content start-->
    <div class="main-content" >

        <!-- header section start-->
        <div class="header-section">

            <!--toggle button start-->
            <a class="toggle-btn"><i class="fa fa-bars"></i></a>
            <!--toggle button end-->

            <!--search start-->
            <form class="searchform" action="index.jsp" method="post">
                <input type="text" class="form-control" name="keyword" placeholder="点此搜索...在开发中未实现" />
            </form>
            <!--search end-->

            <!--notification menu start -->
            <div class="menu-right">
                <ul class="notification-menu">
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                            <i class="fa fa-tasks"></i>
                            <span class="badge">1</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-head pull-right">
                            <h5 class="title">任务清单</h5>
                            <ul class="dropdown-list user-list">
                                <li class="new">
                                    <a href="#">
                                        <div class="task-info">
                                            <div>每日一报进度</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div style="width: 40%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-warning">
                                                <span class="">40%</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>

                                <li class="new"><a href="health_show.html">查看所有任务</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge">5</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-head pull-right">
                            <h5 class="title">你有5条消息 </h5>
                            <ul class="dropdown-list normal-list">
                                <li class="new">
                                    <a href="">
                                        <span class="thumb"><img src="../images/photos/user1.png" alt="" /></span>
                                        <span class="desc">学生a <span class="badge badge-success">new</span></span>
                                        <span class="msg"> 快去每日一报...</span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="thumb"><img src="../images/photos/user2.png" alt="" /></span>
                                        <span class="desc">
                                          <span class="name">学生b</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="thumb"><img src="../images/photos/user3.png" alt="" /></span>
                                        <span class="desc">
                                          <span class="name">学生c</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="thumb"><img src="../images/photos/user4.png" alt="" /></span>
                                        <span class="desc">
                                          <span class="name">学生d</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="thumb"><img src="../images/photos/user5.png" alt="" /></span>
                                        <span class="desc">
                                          <span class="name">学生e</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                                    </a>
                                </li>
                                <li class="new"><a href="#">查看所有信息</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="badge">4</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-head pull-right">
                            <h5 class="title">通知</h5>
                            <ul class="dropdown-list normal-list">
                                <li class="new">
                                    <a href="">
                                        <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                        <span class="name">Server #1 overloaded.  </span>
                                        <em class="small">34 mins</em>
                                    </a>
                                </li>
                                <li class="new">
                                    <a href="">
                                        <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                        <span class="name">Server #3 overloaded.  </span>
                                        <em class="small">1 hrs</em>
                                    </a>
                                </li>
                                <li class="new">
                                    <a href="">
                                        <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                        <span class="name">Server #5 overloaded.  </span>
                                        <em class="small">4 hrs</em>
                                    </a>
                                </li>
                                <li class="new">
                                    <a href="">
                                        <span class="label label-danger"><i class="fa fa-bolt"></i></span>
                                        <span class="name">Server #31 overloaded.  </span>
                                        <em class="small">4 hrs</em>
                                    </a>
                                </li>
                                <li class="new"><a href="">查看所有通知</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="../images/photos/user-avatar.png" alt="" />
                            学生a
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li><a href="#"><i class="fa fa-user"></i>  个人信息</a></li>
                            <li><a href="#"><i class="fa fa-cog"></i>  设置</a></li>
                            <li><a href="./user_login.html"><i class="fa fa-sign-out"></i> 登出</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <!--notification menu end -->

        </div>
        <!-- header section end-->
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading">
                        教师信息填写
                    </header>
                    <div class="panel-body">
                        <div class="form">
                            <form class="cmxform form-horizontal adminex-form" id="signupForm" method="post" action="AddUser.do">
                                <div class="form-group ">
                                    <label for="username" class="control-label col-lg-2">工号</label>
                                    <div class="col-lg-10">
                                        <input class=" form-control" id="username" name="username" type="text" />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="password" class="control-label col-lg-2">密码</label>
                                    <div class="col-lg-10">
                                        <input class=" form-control" id="password" name="password" type="password" />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="level" class="control-label col-lg-2">等级</label>
                                    <div class="col-lg-10">
                                        <input class="form-control " id="level" name="level" type="text" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button class="btn btn-primary" type="submit">submit</button>
                                        <button class="btn btn-default" type="reset">Cancel</button>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
    <!--body wrapper end-->

    <!--footer section start-->
    <!--footer section end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="../js/jquery-1.10.2.min.js"></script>
<script src="../js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="../js/jquery-migrate-1.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/modernizr.min.js"></script>
<script src="../js/jquery.nicescroll.js"></script>

<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script src="../js/validation-init.js"></script>

<!--common scripts for all pages-->
<script src="../js/scripts.js"></script>

</body>
</html>
