package com.yedam.app.emp.service;

import lombok.Data;

@Data
public class DeptVO {
	String departmentId;
	String departmentName;
	String managerId;
	String locationId;
	String orderColumn;
	
	String[] getDeptArr() {
		return departmentId.split(",");
	}
}
