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
<jsp:include page="/WEB-INF/view/student/nav.jsp"></jsp:include>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">课程信息</h1>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已选课程
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>课程名称</th>
                                    <th>课程类型</th>
                                    <th>授课老师</th>
                                    <th>学年</th>
                                    <th>课程学分</th>
                                    <th>成绩</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="playedCourse" items="${playedCourseList}">
                                    <tr>
                                        <td>${playedCourse.courseTitle}</td>
                                        <td>${playedCourse.type}</td>
                                        <td>${playedCourse.staffName}</td>
                                        <td>${playedCourse.year}</td>
                                        <td>${playedCourse.credits}</td>
                                        <c:if test="${playedCourse.score<60}">
                                            <td><font color="red">${playedCourse.score}</font></td>
                                        </c:if>
                                        <c:if test="${playedCourse.score>=60}">
                                            <td><b><font color="#4169e1">${playedCourse.score}</font></b></td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
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

        <!-- /.container-fluid -->
    </div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/bottom.jsp"></jsp:include>
</body>
</html>