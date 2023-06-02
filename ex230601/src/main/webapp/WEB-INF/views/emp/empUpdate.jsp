<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     div {
            width: 500px;
            text-align: right;
            display:block;
        }

</style>
</head>
<body>
<h3>사원수정</h3>
 <form action="empUpdate" method="post" name="frm">
 <div>
 	employeeId<input name="employeeId" readonly="readonly" value="${emp.employeeId }"><br>
	fname<input name="firstName" value="${emp.firstName }"><br>
	lname*<input name="lastName" value="${emp.lastName }"><br>
	email<input name="email" value="${emp.email }"><br>
	</div>
	departmentId
	<c:forEach items="${departments }" var="dept">
		<input type="radio" name="departmentId"  value="${ dept.departmentId}">${dept.departmentName }</radio>
	</c:forEach></br>
	jobId<select name="jobId"><br>
	<option value="">--선택--
	<c:forEach items="${jobs }" var="job">
		<option value="${job.jobId}">${job.jobTitle }</option>
	</c:forEach></select><br>
	<button>저장</button>
</form>
<script>
frm.jobId.value="${emp.jobId}"
</script>
</body>
</html>