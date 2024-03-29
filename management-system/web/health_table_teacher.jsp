<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.models.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>教师打卡查询</title>

  <!--dynamic table-->
  <link href="js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
  <link href="js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
  <link rel="stylesheet" href="js/data-tables/DT_bootstrap.css" />

  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">

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
      <a href="Servlet_refresh_index_school"><img src="images/logo.png" alt=""></a>
    </div>

    <div class="logo-icon text-center">
      <a href="Servlet_refresh_index_school"><img src="images/logo_icon.png" alt=""></a>
    </div>
    <!--logo and iconic logo end-->


    <div class="left-side-inner">

      <!-- visible to small devices only -->
      <div class="visible-xs hidden-sm hidden-md hidden-lg">
        <div class="media logged-user">
          <img alt="" src="images/photos/user-avatar.png" class="media-object">
          <div class="media-body">
            <h4><a href="#">John Doe</a></h4>
            <span>"Hello There..."</span>
          </div>
        </div>

        <h5 class="left-nav-title">Account Information</h5>
        <ul class="nav nav-pills nav-stacked custom-nav">
          <li><a href="#"><i class="fa fa-user"></i> <span>Profile</span></a></li>
          <li><a href="#"><i class="fa fa-cog"></i> <span>Settings</span></a></li>
          <li><a href="#"><i class="fa fa-sign-out"></i> <span>Sign Out</span></a></li>
        </ul>
      </div>

      <!--sidebar nav start-->
      <ul class="nav nav-pills nav-stacked custom-nav">
        <li class="active"><a href="Servlet_refresh_index"><i class="fa fa-home"></i> <span>主页</span></a></li>
        <li class="menu-list"><a href=""><i class="fa fa-book"></i> <span>校级管理员</span></a>
          <ul class="sub-menu-list">
            <li><a href="Servlet_refresh_teacher_school"> 教师信息管理</a></li>
            <li><a href="Servlet_refresh_student_school"> 学生信息管理</a></li>
            <li><a href="Servlet_refresh_teacher_health_table_school"> 教师打卡查询</a></li>
            <li><a href="Servlet_refresh_student_health_table_school"> 学生打卡查询</a></li>
            <li><a href="Servlet_refresh_schoolsetting_school">管理员设置</a></li>
          </ul>
        </li>


        <li><a href="manage_login.jsp"><i class="fa fa-sign-in"></i> <span>登出</span></a></li>

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
      <form class="searchform" action="Servlet_refresh_index_school" method="post">
        <input type="text" class="form-control" name="keyword" placeholder="Search here..." />
      </form>
      <!--search end-->

      <!--notification menu start -->
      <div class="menu-right">
        <ul class="notification-menu">
          <li>
            <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
              <i class="fa fa-tasks"></i>
              <span class="badge">8</span>
            </a>
            <div class="dropdown-menu dropdown-menu-head pull-right">
              <h5 class="title">You have 8 pending task</h5>
              <ul class="dropdown-list user-list">
                <li class="new">
                  <a href="#">
                    <div class="task-info">
                      <div>Database update</div>
                    </div>
                    <div class="progress progress-striped">
                      <div style="width: 40%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="40" role="progressbar" class="progress-bar progress-bar-warning">
                        <span class="">40%</span>
                      </div>
                    </div>
                  </a>
                </li>
                <li class="new">
                  <a href="#">
                    <div class="task-info">
                      <div>Dashboard done</div>
                    </div>
                    <div class="progress progress-striped">
                      <div style="width: 90%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="90" role="progressbar" class="progress-bar progress-bar-success">
                        <span class="">90%</span>
                      </div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="task-info">
                      <div>Web Development</div>
                    </div>
                    <div class="progress progress-striped">
                      <div style="width: 66%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="66" role="progressbar" class="progress-bar progress-bar-info">
                        <span class="">66% </span>
                      </div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="task-info">
                      <div>Mobile App</div>
                    </div>
                    <div class="progress progress-striped">
                      <div style="width: 33%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="33" role="progressbar" class="progress-bar progress-bar-danger">
                        <span class="">33% </span>
                      </div>
                    </div>
                  </a>
                </li>
                <li>
                  <a href="#">
                    <div class="task-info">
                      <div>Issues fixed</div>
                    </div>
                    <div class="progress progress-striped">
                      <div style="width: 80%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="80" role="progressbar" class="progress-bar">
                        <span class="">80% </span>
                      </div>
                    </div>
                  </a>
                </li>
                <li class="new"><a href="">See All Pending Task</a></li>
              </ul>
            </div>
          </li>
          <li>
            <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span class="badge">5</span>
            </a>
            <div class="dropdown-menu dropdown-menu-head pull-right">
              <h5 class="title">You have 5 Mails </h5>
              <ul class="dropdown-list normal-list">
                <li class="new">
                  <a href="">
                    <span class="thumb"><img src="images/photos/user1.png" alt="" /></span>
                    <span class="desc">
                                          <span class="name">John Doe <span class="badge badge-success">new</span></span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                  </a>
                </li>
                <li>
                  <a href="">
                    <span class="thumb"><img src="images/photos/user2.png" alt="" /></span>
                    <span class="desc">
                                          <span class="name">Jonathan Smith</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                  </a>
                </li>
                <li>
                  <a href="">
                    <span class="thumb"><img src="images/photos/user3.png" alt="" /></span>
                    <span class="desc">
                                          <span class="name">Jane Doe</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                  </a>
                </li>
                <li>
                  <a href="">
                    <span class="thumb"><img src="images/photos/user4.png" alt="" /></span>
                    <span class="desc">
                                          <span class="name">Mark Henry</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                  </a>
                </li>
                <li>
                  <a href="">
                    <span class="thumb"><img src="images/photos/user5.png" alt="" /></span>
                    <span class="desc">
                                          <span class="name">Jim Doe</span>
                                          <span class="msg">Lorem ipsum dolor sit amet...</span>
                                        </span>
                  </a>
                </li>
                <li class="new"><a href="">Read All Mails</a></li>
              </ul>
            </div>
          </li>
          <li>
            <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="badge">4</span>
            </a>
            <div class="dropdown-menu dropdown-menu-head pull-right">
              <h5 class="title">Notifications</h5>
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
                <li class="new"><a href="">See All Notifications</a></li>
              </ul>
            </div>
          </li>
          <li>
            <a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
              <img src="images/photos/user-avatar.png" alt="" />
              John Doe
              <span class="caret"></span>
            </a>
            <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
              <li><a href="#"><i class="fa fa-user"></i>  Profile</a></li>
              <li><a href="#"><i class="fa fa-cog"></i>  Settings</a></li>
              <li><a href="#"><i class="fa fa-sign-out"></i> Log Out</a></li>
            </ul>
          </li>

        </ul>
      </div>
      <!--notification menu end -->

    </div>
    <!-- header section end-->

    <!-- page heading start-->
    <div class="page-heading">
      <h3>
        Health Table
      </h3>
      <ul class="breadcrumb">
        <li>
          <a href="#">Dashboard</a>
        </li>
        <li>
          <a href="#">Data Tables</a>
        </li>
        <li class="active"> Dynamic Table </li>
      </ul>
    </div>
    <!-- page heading end-->

    <!--body wrapper start-->
    <div class="wrapper">
      <div class="row">
        <div class="col-sm-12">
          <section class="panel">
            <header class="panel-heading">
              Health Table
              <span class="tools pull-right">
                <a href="javascript:;" class="fa fa-chevron-down"></a>
                <a href="javascript:;" class="fa fa-times"></a>
             </span>
            </header>
            <div class="panel-body">
              <div class="adv-table">
                <table  class="display table table-bordered table-striped" id="dynamic-table">
                  <thead>
                  <tr>

                    <th>姓名</th>
                    <th>身份证号</th>
                    <th>工号</th>
                    <th>健康码</th>
                    <th>打卡情况</th>
                    <th>打卡天数</th>
                  </tr>
                  <%
                    List<Teacher>list=new ArrayList<>();
                    list=(List<Teacher>)request.getAttribute("teacher_list");
                  %>

                  </thead>
                  <tbody>
                  <c:forEach items="<%=list%>" var="teacher">
                  <tr class="gradeX">
                    <td>${teacher.name}</td>
                    <td>${teacher.idCard}</td>
                    <td>${teacher.workNo}</td>
                    <td class="center">${teacher.healthCode}</td>
                    <td>${teacher.dailycheck}</td>
                    <td>${teacher.checkdays}</td>
                  </tr>
                  </c:forEach>
                  </tbody>
                </table>

              </div>
            </div>
          </section>
        </div>
      </div>
    </div>
    <!--body wrapper end-->


  </div>
  <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<!--dynamic table-->
<script type="text/javascript" language="javascript" src="js/advanced-datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/data-tables/DT_bootstrap.js"></script>
<!--dynamic table initialization -->
<script src="js/dynamic_table_init.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

</body>
</html>