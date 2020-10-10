<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        body{
            background: url(${pageContext.request.contextPath}/img/b.jpg)repeat;
        }
    </style>
</head>

<body>
<jsp:include page="/WEB-INF/view/admin/nav.jsp"></jsp:include>
<script src=""></script>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">教师管理</h1>
        </div>
        <%--<c:forEach var="entrty" items="${classBelongSpec}">--%>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        教师信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>教职工号</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>学位</th>
                                    <th>职称</th>
                                    <th>电话号码</th>
                                    <th>所属学院</th>
                                    <th >操作</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--<c:forEach var="className" items="${entrty.value}">--%>
                                <c:forEach var="teacher" items="${teacherList}">
                                    <tr>
                                        <td>${teacher.staffNo}</td>
                                        <td>${teacher.staffName}</td>
                                        <td>${teacher.sex}</td>
                                        <td>${teacher.degree}</td>
                                        <td>${teacher.title}</td>
                                        <td>${teacher.moble}</td>
                                        <td>${teacher.deptName}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/teacher.do/teacher_updata.view?staffNo=${teacher.staffNo}">修改</a>
                                        </td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/teacher.do/delete?staffNo=${teacher.staffNo}"
                                               onclick="return confirm('是否要删除该教师信息')">删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <%--</c:forEach>--%>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <%--</c:forEach>--%>

    </div>
    <a href="${pageContext.request.contextPath}/teacher.do/teacher_add.view" class="btn btn-primary" role="button">添加教师</a>
    <!-- /.container-fluid -->
</div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="/bottom.jsp"></jsp:include>

</body>
</html>
