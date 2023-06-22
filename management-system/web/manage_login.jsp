<%--
  Created by IntelliJ IDEA.
  User: 12935
  Date: 2023/6/22
  Time: 11:03
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
  <title>学生登录</title>

  <link href="./css/style.css" rel="stylesheet">
  <link href="./css/style-responsive.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->

  <style>
    .tab-nav{
      display: flex;
      padding: 0 8px;
      justify-content: space-between;
      position: relative;
      font-size: 1.3em;
    }
    .tab-nav a.active{
      border-bottom: 2px solid #17bb9b;
    }
  </style>
</head>

<body class="login-body">

<div class="container">

  <form class="form-signin" action="Servlet_login_management" method="post">
    <div class="form-signin-heading text-center">
      <h1 class="sign-title">Sign In</h1>
      <div class="tab-nav">
        <a href="./user_login.jsp"  data-id="0">用户登录</a>
        <a href="./manage_login.jsp" data-id="1" class="active">管理员登录</a>
      </div>
      <img src="./images/login-logo.png" alt=""/>
    </div>


    <div class="login-wrap">

      <input name="username" type="text" class="form-control" placeholder="User ID" autofocus>
      <input name="password" type="password" class="form-control" placeholder="Password">

      <button class="btn btn-lg btn-login btn-block" onclick="check()">
        <i class="fa fa-check"></i>
      </button>

      <div class="registration">
        Not a member yet?
        <a class="" href="registration.html">
          Signup
        </a>
      </div>
      <label class="checkbox">
        <input type="checkbox" value="remember-me"> Remember me
        <span class="pull-right">
                    <a data-toggle="modal" href="#myModal"> Forgot Password?</a>

                </span>
      </label>

    </div>

    <!-- Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h4 class="modal-title">Forgot Password ?</h4>
          </div>
          <div class="modal-body">
            <p>Enter your e-mail address below to reset your password.</p>
            <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
            <button class="btn btn-primary" type="button">Submit</button>
          </div>
        </div>
      </div>
    </div>
    <!-- modal -->

  </form>

</div>



<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src="./js/jquery-1.10.2.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/modernizr.min.js"></script>


</body>
</html>
