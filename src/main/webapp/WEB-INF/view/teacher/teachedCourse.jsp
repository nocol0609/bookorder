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
<jsp:include page="/WEB-INF/view/teacher/nav.jsp"></jsp:include>
<script src=""></script>
<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">课程管理</h1>
        </div>
        <%--<c:forEach var="entrty" items="${classBelongSpec}">--%>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        我教授的课程
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>课程名称</th>
                                    <th>课程类型</th>
                                    <th>课程学分</th>
                                    <th>授课周次</th>
                                    <th>授课星期</th>
                                    <th>授课节次</th>
                                    <th>授课地点</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--<c:forEach var="className" items="${entrty.value}">--%>
                                <c:forEach var="teachedCourse" items="${teachedCourseVoList}">
                                    <tr>
                                        <td>${teachedCourse.courseTitle}</td>
                                        <td>${teachedCourse.type}</td>
                                        <td>${teachedCourse.credits}</td>
                                        <td>${teachedCourse.weeks}</td>
                                        <td>${teachedCourse.week}</td>
                                        <td>${teachedCourse.time}</td>
                                        <td>${teachedCourse.classRoom}</td>
                                        <td>
                                            <button class="btn btn-default btn-xs btn-info" onClick="location.href='${pageContext.request.contextPath}/orderbook.do/grade.view?courseTitle=${teachedCourse.courseTitle}'">成绩</button>
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
    <!-- /.container-fluid -->
</div>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="/bottom.jsp"></jsp:include>

</body>
</html>
