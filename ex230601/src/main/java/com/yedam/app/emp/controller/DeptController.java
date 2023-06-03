package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;


@Controller
public class DeptController {

	
	@Autowired DeptMapper deptMapper;
	@GetMapping("deptList")
	public String deptList(Model model, @ModelAttribute("dept") DeptVO vo) {
		System.out.println(vo);
		//model.addAttribute("empVO",vo);
		model.addAttribute("deptList", deptMapper.deptList(vo));
		return "dept/deptList";
	}
	
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		model.addAttribute("locations",deptMapper.selectLocations());
		return "dept/deptInsert";
	}
	
	//사원등록 처리
	@PostMapping("deptInsert")
	public String deptInsert(DeptVO vo) {
		deptMapper.insertDept(vo);
		return "redirect:deptList"; //forward redirect
	}
	
	//사원삭제 처리
	@GetMapping("deptDelete")
	public String deptDelete(@RequestParam int departmentId) {
		// int empId = request.getParameter("empId")
		// @requestPARAM 이 대체 
		deptMapper.deleteDept(departmentId);
		return "redirect:deptList";
	}
	
	//사원수정페이지로 이동
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Model model, int departmentId) {
		model.addAttribute("dept",deptMapper.selectDept(departmentId));
		model.addAttribute("locations",deptMapper.selectLocations());
		model.addAttribute("employees",deptMapper.selectEmp());
		return "dept/deptUpdate";
	}

	//사원수정 처리
	@PostMapping("deptUpdate")
	public String deptUpdate(DeptVO vo) {
		deptMapper.updateDept(vo);
		return "redirect:deptList"; //forward redirect
	}
	
}
