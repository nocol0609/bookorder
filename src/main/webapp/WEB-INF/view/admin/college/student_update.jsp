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

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">学生管理</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        学生信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="${pageContext.request.contextPath}/student.do/update?" method="post" enctype="multipart/form-data">
                                <label>学号</label>
                                <input class="form-control" name="studentId" value="${student.studentId}" readonly>
                                <br>
                                <label>姓名</label>
                                <input class="form-control" name="studentName"value="${student.studentName}">
                                <br>
                                <label>身份证号</label>
                                <input class="form-control" name="idCard" value="${student.idCard}">
                                <br>
                                <label>性别</label>
                                <select class="form-control" name="gender">
                                    <option>${student.gender}</option>
                                </select>
                                <br>
                                <label>联系电话</label>
                                <input class="form-control" name="telephoneNumber" value="${student.telephoneNumber}">
                                <br>
                                <label>年级</label>
                                <input class="form-control" name="year" value="${student.year}">
                                <br>
                                <label>班级</label>
                                <input class="form-control" name="className" value="${student.className}">
                                <br>
                                <label>生源地</label>
                                <input class="form-control" name="studentOriginBase" value="${student.studentOriginBase}">
                                <br>
                                <label>所属学院</label>
                                <select class="form-control" name="deptName">
                                    <c:forEach var="deptName" items="${deptNameList}">
                                        <option>${student.deptName}</option>
                                    </c:forEach>
                                </select>
                                <label></label>
                                <button type="submit" class="btn btn-primary form-control">修改</button>
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
