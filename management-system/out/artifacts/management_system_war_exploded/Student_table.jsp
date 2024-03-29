<%@ page import="main.models.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="ThemeBucket">
  <link rel="shortcut icon" href="#" type="image/png">
  <title>Student Table</title>
  <!--data table-->
  <link rel="stylesheet" href="js/data-tables/DT_bootstrap.css" />
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
</head>
<body class="sticky-header">
<section>
  <!-- left side start-->
  <div class="left-side sticky-left-side">
    <!--logo and iconic logo start-->
    <div class="logo">
      <a href="Servlet_refresh_index"><img src="images/logo.png" alt=""></a>
    </div>
    <div class="logo-icon text-center">
      <a href="Servlet_refresh_index"><img src="images/logo_icon.png" alt=""></a>
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
        <li class="menu-list"><a href=""><i class="fa fa-laptop"></i> <span>系统管理员</span></a>
          <ul class="sub-menu-list">
            <li><a href="Servlet_refresh_teacher"> 教师信息管理</a></li>
            <li><a href="Servlet_refresh_student"> 学生信息管理</a></li>
            <li><a href="Servlet_refresh_college"> 学院信息管理</a></li>
            <li><a href="Servlet_refresh_major"> 专业信息管理</a></li>
            <li><a href="Servlet_refresh_class"> 班级信息管理</a></li>
            <li><a href="Servlet_refresh_teacher_health_table"> 教师打卡查询</a></li>
            <li><a href="Servlet_refresh_student_health_table"> 学生打卡查询</a></li>
            <li><a href="Servlet_refresh_schoolsetting">管理员设置</a></li>
          </ul>
        </li>
        <li><a href="user_login.jsp"><i class="fa fa-sign-in"></i> <span>登出</span></a></li>

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
      <form class="searchform" action="Servlet_refresh_index" method="post">
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
        Student Table
      </h3>
      <ul class="breadcrumb">
        <li>
          <a href="#">Dashboard</a>
        </li>
        <li>
          <a href="#">Data Table</a>
        </li>
        <li class="active"> Editable Table </li>
      </ul>
    </div>
    <div class="wrapper">
      <div class="row">
        <div class="col-sm-12">
          <section class="panel">
            <header class="panel-heading">
              学生信息表
              <span class="tools pull-right">
                        <a href="javascript:;" class="fa fa-chevron-down"></a>
                        <a href="javascript:;" class="fa fa-times"></a>
                     </span>
            </header>
            <div class="panel-body">
              <div class="adv-table editable-table ">
                <div class="clearfix">
                  <div class="btn-group">
                    <button id="editable-sample_new" class="btn btn-primary" onclick="window.location.href='addstudent.jsp'"> > Add New <i class="fa fa-plus"></i></button>

                    <form action="AddStudentBatch.do" method="post" enctype="multipart/form-data">
                      <label for="file"  id="upFile"  class="btn btn-primary" >数据导入</label>
                      <input type="file" id="file" name="file" multiple style="width: 0;" >
                      <input type="submit" value="上传" />
                    </form>
                    <div class="btn-group">
                      <!-- 一个查询按钮 ,链接到/Findteacher_withway.do，内容为 两个个text框，一个name为way，一个为thing，-->
                      <form action = "Findstudent_withway.do" method="post">
                        <input type="text" name="way" placeholder="查询方式">
                        <input type="text" name="thing" placeholder="查询内容">
                        <input type="submit" value="查询">
                      </form>
                    </div>
                  </div>
                  <div class="btn-group pull-right">
                    <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i>
                    </button>
                    <ul class="dropdown-menu pull-right">
                      <li><a href="#">Print</a></li>
                      <li><a href="#">Save as PDF</a></li>
                      <li><a href="#">Export to Excel</a></li>
                    </ul>
                  </div>
                </div>
                <div class="space15"></div>
                <table class="table table-striped table-hover table-bordered" id="editable-sample">
                  <thead>
                  <tr>
                    <th>姓名</th>
                    <th>身份证号</th>
                    <th>学号</th>
                    <th>学院</th>
                    <th>专业</th>
                    <th>班级</th>
                    <th>修改</th>
                    <th>删除</th>
                  </tr>
                  </thead>
                  <%
                    List<Student> list=new ArrayList<>();
                    list= (List<Student>) request.getAttribute("student_list");
                  %>

                  <tbody>
                  <c:forEach items="<%=list%>" var="student">
                  <tr>
                    <td>${student.name}</td>
                    <td>${student.idCard}</td>
                    <td>${student.studentNo}</td>
                    <td>${student.college}</td>
                    <th>${student.major}</th>
                    <th>${student.classNo}</th>
                    <td><a  href="editmanage.jsp?name=${student.name}&idCard=${student.idCard}&StudentNo=${student.studentNo}&college=${student.college}&major=${student.major}&classNo=${student.classNo}">修改</a></td>
                    <td><a  href="DeleteStudent.do?StudentNo=${student.studentNo}">Delete</a></td>
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

  </div>
</section>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="js/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<!--data table-->
<script type="text/javascript" src="js/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/data-tables/DT_bootstrap.js"></script>

<!--common scripts for all pages-->
<script src="js/scripts.js"></script>

<!--script for editable table-->
<script src="js/editable-table.js"></script>

<!-- END JAVASCRIPTS -->
<script>
  jQuery(document).ready(function() {
    EditableTable.init();
  });
</script>

</body>
</html>

