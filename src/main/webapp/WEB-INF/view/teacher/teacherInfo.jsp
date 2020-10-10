<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
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
<jsp:include page="/WEB-INF/view/teacher/nav.jsp"></jsp:include>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">个人主页</h1>
        </div>
        <div class="panel-heading">
        </div>0
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        个人信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="${pageContext.request.contextPath}/student.do/update" method="post" enctype="multipart/form-data">
                                <label>教职工号(用于账号登录)</label>
                                <input class="form-control" name="staffNo" value="${teacher.staffNo}" readonly>
                                <br>
                                <label>姓名</label>
                                <input class="form-control" name="staffName" value="${teacher.staffName}" disabled>
                                <br>
                                <label>性别</label>
                                <input class="form-control" name="staffName" value="${teacher.sex}" disabled>
                                <br>
                                <label>学位</label>
                                <input class="form-control" name="degree" value="${teacher.degree}" disabled>
                                <br>
                                <label>职称</label>
                                <input class="form-control" name="title" value="${teacher.title}" disabled>
                                <br>
                                <label>所属学院</label>
                                <input class="form-control" name="title" value="${teacher.deptName}" disabled>
                                <br>
                                <label>联系电话</label>
                                <input class="form-control" name="moble" value="${teacher.moble}" disabled>
                                <label></label>
                            </form>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>

    <!-- /.container-fluid -->
</div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/bottom.jsp"></jsp:include>
</body>
</html>
