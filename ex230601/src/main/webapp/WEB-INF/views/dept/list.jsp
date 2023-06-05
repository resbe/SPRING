<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 부서 정보</title>
</head>
<body>
<div>
	<h3>부서조회</h3>
	<a href="deptInsert">등록</a>
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>지역번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptList}" var="dept">
				<tr onclick="location.href='deptInfo?departmentId=${dept.departmentId }'">
					<td><input type="checkbox"></td>
					<td>${dept.departmentId }</td>
					<td>${dept.departmentName }</td>
					<td>${dept.managerId }</td>
					<td>${dept.locationId }</td>
					<td><button type="button">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>