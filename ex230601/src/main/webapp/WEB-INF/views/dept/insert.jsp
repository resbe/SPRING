<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 등록</title>
</head>
<body>
	<form action="deptInsert" method="POST">
		<div>
			<label for="name">부서이름</label>
			<input type="text" id="name" name="departmentName" required>
		</div>
		<div>
			<label for="mId">매니저 번호</label>
			<input type="number" id="mId" name="managerId">
		</div>
		<div>
			<label for="lId">지역 번호</label>
			<input type="number" id="lId" name="locationId">
		</div>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='deptList'">목록</button>
	</form>
</body>
</html>