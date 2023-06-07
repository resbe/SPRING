package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

/*
* command
* Pojo : 상속필요없음
*/

@Controller // 객체 생성해서 컨테이너에 빈등록하고 
			// 스프링 디스패처서블릿에서 호출할 수 있도록
			// 커멘드 타입으로 만들어 줌 
			// @Component 상속
			// class 위에 있어야 함.
public class EmpController {
	
	@Autowired EmpMapper empMapper;
	
	@GetMapping("empList")
	public String empList(Model model, @ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);
		//model.addAttribute("empVO",vo);
		model.addAttribute("empList", empMapper.selectList(vo));
		return "emp/empList";
	}
	// @ModelAttribute 보낸데이터를 유지해야할때 쓴다.
	
	//사원등록 페이지로 이동
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("jobs",empMapper.selectJobs());
		model.addAttribute("departments",empMapper.selectDept());
		return "emp/empInsert";
	}
	
	//사원등록 처리
	@PostMapping("empInsert")
	public String empInsert(EmpVO vo) {
		empMapper.insertEmp(vo);
		return "redirect:empList"; //forward redirect
	}
	
	//사원삭제 처리
	@GetMapping("empDelete")
	public String empDelete(@RequestParam int empId) {
		// int empId = request.getParameter("empId")
		// @requestPARAM 이 대체 
		empMapper.deleteEmp(empId);
		return "redirect:empList";
	}
	
	//사원수정페이지로 이동
	@GetMapping("empUpdate")
	public String empUpdateForm(Model model, int empId) {
		model.addAttribute("emp",empMapper.selectOne(empId));
		model.addAttribute("jobs",empMapper.selectJobs());
		model.addAttribute("departments",empMapper.selectDept());
		return "emp/empUpdate";
	}

	//사원수정 처리
	@PostMapping("empUpdate")
	public String empUpdate(EmpVO vo) {
		empMapper.updateEmp(vo);
		return "redirect:empList"; //forward redirect
	}
}
