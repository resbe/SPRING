package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptInfoVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
