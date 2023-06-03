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
<h3>부서등록</h3>
 <form action="deptInsert" method="post">
 <div>
	부서이름<input name="departmentName"><br>
	매니저<input name="mnagerId"><br>
	locationtId<select name="locationId"><br>
	<option value="">--선택--
	<c:forEach items="${locations }" var="location">
		<option value="${ location.locationId}">${location.CITY }</option>
	</c:forEach>
	</select><br>
	<button>저장</button>
</form>
<script>
console.log("${locations}");
</script>
</body>
</html>