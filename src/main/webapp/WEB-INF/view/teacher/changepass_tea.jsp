<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        body{
            background: url(${pageContext.request.contextPath}/img/b.jpg)
            repeat;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/view/teacher/nav.jsp"></jsp:include>

<!-- Page Content -->
<div id="page-wrapper">
    <div class="container-fluid">
        <div>
            <h1 class="page-header">密码管理</h1>
        </div>
        <div class="panel-heading">
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        修改密码
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <form action="${pageContext.request.contextPath}/orderbook.do/updatePass" method="get">
                                <p></p>
                                <label>新密码</label>
                                <input class="form-control" name="password">
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