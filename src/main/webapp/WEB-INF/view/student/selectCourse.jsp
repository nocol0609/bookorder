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
									<th>课程人数</th>
									<th>操作</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach var="selectedCourse" items="${selectedCourseList}">
									<tr>
										<td>${selectedCourse.courseTitle}</td>
										<td>${selectedCourse.type}</td>
										<td>${selectedCourse.staffName}</td>
										<td>${selectedCourse.year}</td>
										<td>${selectedCourse.credits}</td>
										<td>${selectedCourse.limitCount}</td>
										<td>
											<a href="${pageContext.request.contextPath}/elective.do/back?courseTitle=${selectedCourse.courseTitle}" onclick="return confirm('是退选该课？')">退选</a>
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