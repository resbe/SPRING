<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사원조회</h2>
<a href="empInsert">등록</a>
<form action="empList">
	부서<input type="text" name="departmentId" value="${empVO.departmentId}"> 
	fname<input type="text" name="firstName" value="${empVO.firstName}"> 
	<button>검색</button>
	<button type="reset">초기화</button>
</form>
<table border="1" style="text-align:center;">
<thead>
<td>사원번호</td>
<td>이름</td>
<td>부서번호</td>
<td>수정</td>
<td>삭제</td>
</thead>
<tbody>
<c:forEach items="${empList }" var="emp">
<tr><td>${emp.employeeId }</td>
	<td>${emp.firstName } - ${emp.lastName }</td>
	<td>${emp.departmentId }</td>
	<td><a href="empUpdate?empId=${emp.employeeId }">수정</a></td>
	<td><a href="empDelete?empId=${emp.employeeId }">삭제</a></td>
</tr>
 </c:forEach>
</tbody>
</table>
</body>
</html>