package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yedam.app.emp.mapper.DeptMapper;


public class DeptController {

	@Controller
	
	@Autowired DeptMapper deptMapper;
	
	
}
