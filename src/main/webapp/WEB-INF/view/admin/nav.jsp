<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>花椒教材订购系统</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"
          rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- custom CSS -->
    <link href="${pageContext.request.contextPath}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- custom Fonts -->
    <link href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you util the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<div id="wrapper" style="width: auto">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0 ">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="#"><h4>欢迎&nbsp;<shiro:principal/>&nbsp;登录花椒教材订购系统!</h4></a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user">&nbsp;<shiro:principal/></i>
                </a>
                <%--<ul class="dropdown-menu dropdown-user">
                    <li><a href="${pageContext.request.contextPath}/account.do/profile.view">
                        <i class="fa fa-user fa-fw"></i> 用户设置</a>
                    </li>

                    <li class="divider"></li>
                    <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                    </li>
                </ul>--%>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->

        <div class="navbar-default sidebar" role="navigation" align="center">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/main.do/admin"><i class="fa fa-book fa-fw"></i> 控制面板</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/user.do/user.view"><i class="fa fa-book fa-fw"></i>用户管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/role.do/role.view"><i class="fa fa-book fa-fw"></i>角色管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/teacher.do/teacher.view"><i class="fa fa-book fa-fw"></i>教师管理</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/student.do/student.view"><i class="fa fa-book fa-fw"></i>学生管理</a>
                    </li>
                   <%-- <li state="">--%>
                       <%-- <a href="#"><i class="fa fa-wrench fa-fw"></i> 学院管理<span class="fa arrow"></span></a>--%>
                        <%--<ul class="nav nav-second-level">--%>
                            <li>
                                <a href="${pageContext.request.contextPath}/dept.do/dept.view"><i class="fa fa-wrench fa-fw"></i> 学院设置</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/spec.do/spec.view"><i class="fa fa-wrench fa-fw"></i> 专业设置</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/clazz.do/clazz.view"><i class="fa fa-wrench fa-fw"></i> 班级管理</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/course.do/course.view"><i class="fa fa-wrench fa-fw"></i> 添加课程</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/section.do/section.view"><i class="fa fa-wrench fa-fw"></i> 课程安排</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/orderbook.do/orderbook_review.view/"><i class="fa fa-user"></i>&nbsp;&nbsp;教材审核</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/account.do/profile.view/"><i class="fa fa-wrench fa-fw"></i>&nbsp;&nbsp;修改密码</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out fa-fw"></i>&nbsp;&nbsp;退出系统</a>
                            </li>

                        <%--</ul>--%>
                        <!-- /.nav-second-level -->
                   <%-- </li>--%>

                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>