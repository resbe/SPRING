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
<h3>부서수정</h3>
 <form action="deptUpdate" method="post" name="frm">
 <div>
 	departmentId<input name="departmentId" readonly="readonly" value="${dept.departmentId}"><br>
	부서이름<input name="departmentName" value="${dept.departmentName }"><br>
	managerId
	<c:forEach items="${employees }" var="emp">
		<input type="radio" name="managerId" value="${ emp.managerId}" <c:if test="${ emp.managerId == dept.managerId }"> checked </c:if>>
		${emp.firstName }
	</c:forEach></br>
	locationId
	<c:forEach items="${locations }" var="loca">
		<input type="radio" name="locationId" value="${ dept.locationId}">
		${loca.CITY }
	</c:forEach></br>
	<button>저장</button>
</form>
<script>
frm.locationId.value="${dept.locationId}"
</script>
</body>
</html>