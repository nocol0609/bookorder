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

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">课程成绩</h1>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        学生成绩
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th width="50">课程名</th>
                                    <th width="50">学号</th>
                                    <th width="50">姓名</th>
                                    <th width="50">性别</th>
                                    <th width="50">分数</th>
                                    <th width="50">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="markVo" items="${markVoList}">
                                    <tr>
                                        <td>${markVo.courseTitle}</td>
                                        <td>${markVo.studentId}</td>
                                        <td>${markVo.studentName}</td>
                                        <td>${markVo.gender}</td>
                                        <td>${markVo.score}</td>
                                        <td>
                                            <c:if test="${markVo.score==null}">
                                                <a href="${pageContext.request.contextPath}/orderbook.do/toMark.view?studentId=${markVo.studentId}&courseTitle=${markVo.courseTitle}">打分</a>
                                            </c:if>
                                            <c:if test="${markVo.score!=null}">
                                                <a href="#"><font color="red">已打分</font></a>
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