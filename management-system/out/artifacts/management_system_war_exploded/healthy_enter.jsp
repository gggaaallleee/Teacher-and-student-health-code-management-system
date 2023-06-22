<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/6/21
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>健康码填写页面</title>

    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="sticky-header">

<section>
    <!-- left side start-->
    <div class="left-side sticky-left-side">

        <!--logo and iconic logo start-->
        <div class="logo">
            <a href="index.html"><img src="../images/logo.png" alt=""></a>
        </div>

        <div class="logo-icon text-center">
            <a href="index.html"><img src="images/logo_icon.png" alt=""></a>
        </div>
        <!--logo and iconic logo end-->

        <!--sidebar nav start-->
        <ul class="nav nav-pills nav-stacked custom-nav">
            <li><a href="index.html"><i class="fa fa-home"></i> <span>主页</span></a></li>

            <li class="menu-list nav-active"><a href=""><i class="fa fa-tasks"></i> <span>每日一报填写与查看</span></a>
                <ul class="sub-menu-list">
                    <li class="active"><a href="health_enter.html"> 填写表单</a></li>
                    <li><a href="./healthcode.html"> 我的健康码</a></li>
                </ul>
            </li>
            <li><a href="login.html"><i class="fa fa-sign-in"></i> <span>登出</span></a></li>

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
            <form class="searchform" action="index.html" method="post">
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
                        每日健康信息填报
                    </header>
                    <div class="panel-body">
                        <div class="form">
                            <form class="cmxform form-horizontal adminex-form" id="signupForm" method="get" action="">
                                <div class="form-group ">
                                    <label for="name" class="control-label col-lg-2">姓名</label>
                                    <div class="col-lg-10">
                                        <input class=" form-control" id="name" name="name" type="text" />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="id" class="control-label col-lg-2">身份证号</label>
                                    <div class="col-lg-10">
                                        <input class=" form-control" id="id" name="id" type="text" />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="StunumberdentNO" class="control-label col-lg-2">学号</label>
                                    <div class="col-lg-10">
                                        <input class="form-control " id="number" name="number" type="text" />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="phone" class="control-label col-lg-2">手机号</label>
                                    <div class="col-lg-10">
                                        <input class="form-control " id="phone" name="phone" type="password" />
                                    </div>
                                </div>
                                <!-- <div class="form-group ">
                                    <label for="confirm_password" class="control-label col-lg-2">Confirm Password</label>
                                    <div class="col-lg-10">
                                        <input class="form-control " id="confirm_password" name="confirm_password" type="password" />
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="email" class="control-label col-lg-2">Email</label>
                                    <div class="col-lg-10">
                                        <input class="form-control " id="email" name="email" type="email" />
                                    </div>
                                </div> -->

                                <div class="form-group ">
                                    <label for="agree" class="control-label col-lg-2 col-sm-3">本人近期（14天内）是否去过重点疫区？</label>
                                    <div class="col-lg-10 col-sm-9">
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox1" name="is_in_danger" value="是"> 是
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox2" name="is_in_danger" value="否"> 否
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="newsletter" class="control-label col-lg-2 col-sm-3">本人近期（14天内）是否去过国外？</label>
                                    <div class="col-lg-10 col-sm-9">
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox1" name="is_abroad" value="是"> 是
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox2" name="is_abroad" value="否"> 否
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group ">
                                    <label for="newsletter" class="control-label col-lg-2 col-sm-3">本人近期（14天内）是否接触过新冠确诊病人或疑似病人？</label>
                                    <div class="col-lg-10 col-sm-9">
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox1" name="is_contact" value="是"> 是
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox2" name="is_contact" value="否"> 否
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label for="newsletter" class="control-label col-lg-2 col-sm-3">本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？</label>
                                    <div class="col-lg-10 col-sm-9">
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox1" name="is_confirmed" value="是"> 是
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox2" name="is_confirmed" value="否"> 否
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label col-lg-2" for="inputSuccess">本人是否打过新冠疫苗，可选“未打过，已打1针，已打2针，已打3针”</label>
                                    <div class="col-lg-10">
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox1" name="vaccine" value="1"> 1
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox2" name="vaccine" value="2"> 2
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="radio" id="inlineCheckbox3" name="vaccine" value="3"> 3
                                        </label>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label col-lg-2" for="inputSuccess">当前健康状况？无异常、发烧（≥37.3℃）、乏力、干咳、鼻塞、流涕、咽痛、腹泻等。</label>
                                    <div class="col-lg-10">
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox1" name="vaccine" value="正常" checked> 正常
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox2" name="vaccine" value="发烧"> 发烧
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox3" name="vaccine" value="乏力"> 乏力
                                        </label>
                                        <br>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox3" name="vaccine" value="乏力"> 干咳
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox3" name="vaccine" value="乏力"> 鼻塞
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox3" name="vaccine" value="乏力"> 流涕
                                        </label>
                                        <br>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox3" name="vaccine" value="乏力"> 咽痛
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" id="inlineCheckbox3" name="vaccine" value="乏力"> 腹泻
                                        </label>
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
    <footer>
        2014 &copy; AdminEx by <a href="http://www.mycodes.net/" target="_blank">源码之家</a>
    </footer>
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


