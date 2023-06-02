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
<h3>사원등록</h3>
 <form action="empInsert" method="post">
 <div>
	lname*<input name="lastName"><br>
	hiredate<input name="hireDate"><br>
	email<input name="email"><br>
	</div>
	departmentId<select name="departmentId"><br>
	<option value="">--선택--
	<c:forEach items="${departments }" var="dept">
		<option value="${ dept.departmentId}">${dept.departmentName }</option>
	</c:forEach>
	</select><br>
	jobId
	<c:forEach items="${jobs }" var="job">
		<input type="radio" name="jobId" value="${job.jobId}">${job.jobTitle }</radio>
	</c:forEach><br>
	<button>저장</button>
</form>
</body>
</html>