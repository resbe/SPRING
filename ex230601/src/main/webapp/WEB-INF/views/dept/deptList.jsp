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
<h2>부서조회</h2>
<a href="deptInsert">등록</a>
<form action="deptList">
	부서번호<input type="text" name="departmentId" value="${deptVO.departmentId}"> 
	이름<input type="text" name="departmentName" value="${deptVO.departmentName}"> 
	<button>검색</button>
	<button type="reset">초기화</button>
</form>
<table border="1" style="text-align:center;">
<thead>
<td>부서번호</td>
<td>이름</td>
<td>매니저아이디</td>
<td>지역</td>
<td>삭제</td>
</thead>
<tbody>
<c:forEach items="${deptList }" var="dept">
<tr><td>${dept.departmentId }</td>
	<td>${dept.departmentName }</td>
	<td>${dept.managerId }</td>
	<td>${dept.locationId }</td>
	<td><a href="deptUpdate?departmentId=${dept.departmentId }">수정</a></td>
	<td><a href="deptDelete?departmentId=${dept.departmentId }">삭제</a></td>
</tr>
 </c:forEach>
</tbody>
</table>
</body>
</html>