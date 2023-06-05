<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
</head>
<body>
	<form name="frm" onsubmit="return false">
		<div>
			<label for="id">부서번호</label>
			<input type="number" id="id" name="departmentId" value="${deptInfo.departmentId }" readonly>
		</div>
		<div>
			<label for="name">부서이름</label>
			<input type="text" id="name" name="departmentName" value="${deptInfo.departmentName}">
		</div>
		<div>
			<label for="mId">매니저 번호</label>
			<input type="number" id="mId" name="managerId" value="${deptInfo.managerId }">
		</div>
				<div>
			<label for="lId">지역 번호</label>
			<input type="number" id="lId" name="locationId" value="${deptInfo.locationId }">
		</div>
		<button type="submit">수정</button>
		<button type="button">목록</button>
	</form>
	<script>

		document.querySelector('button[type="submit"]').addEventListener('click',function(e){
			let data = [{
				'departmentId' : frm.departmentId.value,
				'departmentName' : frm.departmentName.value,
				'managerId' : frm.managerId.value,
				'locationId' : frm.locationId.value
			}]

			fetch('deptUpdate',{
				method : 'post',
				headers : {
					'content-type' : 'application/json'
				},
				body : JSON.stringify(data)	
			})
			.then(response => response.json())
			.then(result => {
				if(result != "" && result != null){
						let msg = `결과 : ${result.result} \n 
							   	   성공 : ${result.success}\n
							  	   대상 : ${result.deptList[0]}`;
					alert(msg);
				}
			})
			.catch(err => console.log(err));
		})
	</script>
</body>
</html>