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
            <h1 class="page-header">学生选课</h1>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        已开设课程信息
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>课程名称</th>
                                    <th>授课老师</th>
                                    <th>周次</th>
                                    <th>星期</th>
                                    <th>节次</th>
                                    <th>教室</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="section" items="${sectionList}">
                                    <tr>
                                        <td>${section.courseTitle}</td>
                                        <td>${section.teacher}</td>
                                        <td>${section.weeks}</td>
                                        <td>${section.week}</td>
                                        <td>${section.time}</td>
                                        <td>${section.classroom}</td>
                                        <td>
                                            <c:if test="${section.flag==0}">
                                                <a href="${pageContext.request.contextPath}/elective.do/add?secId=${section.secId}" onclick="return confirm('是否选择该课')">选课</a>
                                            </c:if>
                                            <c:if test="${section.flag==1}">
                                                <a href="#"><font color="red">已选课</font></a>
                                            </c:if>
                                        </td>
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