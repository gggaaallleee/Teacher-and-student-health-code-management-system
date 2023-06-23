<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/6/21
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import=" java.text.*, java.util.*" %>
<%@ page import="com.google.zxing.EncodeHintType" %>
<%@ page import="com.google.zxing.BarcodeFormat" %>
<%@ page import="com.google.zxing.qrcode.decoder.ErrorCorrectionLevel" %>
<%@ page import="com.google.zxing.qrcode.QRCodeWriter" %>
<%@ page import="com.google.zxing.common.BitMatrix" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.*" %>
<%@ page import="java.io.OutputStream" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>健康码展示页面</title>

    <link href="./css/style.css" rel="stylesheet">
    <link href="./css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/green.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->


    <script>
        function showTime(){
            let d=new Date();
            let year=d.getFullYear();
            let month=d.getMonth()+1;  //获取月，从 Date 对象返回月份 (0 ~ 11)，故在此处+1
            let day=d.getDay()    //获取日
            let days=d.getDate() //获取日期
            let hour=d.getHours()   //获取小时
            let minute=d.getMinutes()  //获取分钟
            let second=d.getSeconds()   //获取秒

            // if(month<10) month="0"+month
            if(days<10) days="0"+days
            if(hour<10) hour="0"+hour
            if(minute<10) minute="0"+minute
            if(second<10) second="0"+second

            var week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六")
            let shang=month+"月"+days+"日";
            let xia=hour+":"+minute+":"+second
            // var da=year+" 年 "+month+" 月 "+days+" 日 "+week[day]+" "+hour+" : "+minute+" :"+second

            document.getElementById("clock1").value=shang
            document.getElementById("clock2").value=xia
        }
        setInterval("showTime()",1000)
    </script>
</head>

<body class="sticky-header">
<%String name = request.getAttribute("name").toString();
    String id = request.getAttribute("idCard").toString();
    String code = request.getAttribute("healthCode").toString();
    String identity = request.getAttribute("identity").toString();
    String num = request.getAttribute("workNo").toString();
    String college = request.getAttribute("college").toString();
    System.out.println(code);
%>
<%  Date nowTime = new Date();
    SimpleDateFormat matter = new SimpleDateFormat(
            "现在时间:yyyy年MM月dd日E HH时mm分ss秒");%>

<p> <%=name%></p>
<p> <%=matter.format(nowTime)%></p>
<%
    String text = name+" "+id+" "+code+" "+identity+" "+num+" "+college+" "+matter.format(nowTime);
    int width = 400;
    int height = 400;
    Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
    int BLACK = 0xFF000000;
    int YELLOW = 0xFFFFFF00;
    int RED = 0xFFFF0000;
    int GREEN = 0xFF008000;
    int BLUE = 0xFF0000FF;
    int color;
    int border = BLACK;
    System.out.println(code);
    switch (code) {
        case "green":
            color = GREEN;
            break;
        case "yellow":
            color = YELLOW;
            break;
        case "red":
            color = RED;
            break;
        case "blue":
            color = BLUE;
            border = YELLOW;
            break;
        default:
            color = BLACK;
            break;
    }
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
    java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            int pixelColor = bitMatrix.get(x, y) ? BLACK : 0xFFFFFFFF;
            if (x < 1 || y < 1 || x >= width - 1 || y >= height - 1) {
                image.setRGB(x, y, border);
            } else if (pixelColor == BLACK) {
                image.setRGB(x, y, color);
            } else {
                image.setRGB(x, y, 0xFFFFFFFF);
            }
        }
    }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    javax.imageio.ImageIO.write(image, "png", baos);
    baos.flush();
    byte[] imageBytes = baos.toByteArray();
    baos.close();
    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
%>
<section>
<!-- left side start-->
<div class="left-side sticky-left-side">

    <!--logo and iconic logo start-->
    <div class="logo">
        <a href="index.html"><img src="./images/logo.png" alt=""></a>
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
                                <span class="thumb"><img src="./images/photos/user1.png" alt="" /></span>
                                <span class="desc">学生a <span class="badge badge-success">new</span></span>
                                <span class="msg"> 快去每日一报...</span>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="./images/photos/user2.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">学生b</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="./images/photos/user3.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">学生c</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="./images/photos/user4.png" alt="" /></span>
                                <span class="desc">
                                          <span class="name">学生d</span>
                                          <span class="msg">快去每日一报...</span>
                                        </span>
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <span class="thumb"><img src="./images/photos/user5.png" alt="" /></span>
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
                    <img src="./images/photos/user-avatar.png" alt="" />
                    学生a
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                    <li><a href="#"><i class="fa fa-user"></i>  个人信息</a></li>
                    <li><a href="#"><i class="fa fa-cog"></i>  设置</a></li>
                    <li><a href="./student_login.html"><i class="fa fa-sign-out"></i> 登出</a></li>
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
    个人健康码
</header>

<div class="main">
<div class="time">
    <input type="text" id="clock1"><br>
    <input type="text" id="clock2">
</div>

<div class="center">
<div class="top">
<div class="name">
    <%=name%>
    </div>
    </div>

    <div class="pic">
    <img src="data:image/png;base64,<%= base64Image %>" alt="QR code">
    </div>

    <div class="text">
    绿码：凭此码可以在浙江省内通行，请主动出示，配合检查；并要做好自身防护工作，码颜色将根据的 <br> 您的申报由当地政府按照相关政策动态更新，出行前请仔细检查您的健康码
    </div>
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
    <script src="./js/jquery-1.10.2.min.js"></script>
    <script src="./js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="./js/jquery-migrate-1.2.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/modernizr.min.js"></script>
    <script src="./js/jquery.nicescroll.js"></script>

    <script type="text/javascript" src="./js/jquery.validate.min.js"></script>
    <script src="./js/validation-init.js"></script>

    <!--common scripts for all pages-->
    <script src="./js/scripts.js"></script>

    </body>
    </html>



