package com.yedam.app.dept.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptInfoVO;

@Controller("deptInfo")
public class DeptInfoController {
	@Autowired
	DeptService deptService;
	
	// 경로 : <-> 기능 ( View )
	// 경로 + Method -> Unique
	
	// 조회 ( 데이터, 페이지 ) -> GET
	// 등록, 수정, 삭제 -> POST
	
	// 전체조회
	@GetMapping("deptList")
	public String getDeptAllList(Model model) {
		model.addAttribute("deptList", deptService.getAllDept());
		return "dept/list";
	}
	
	//단건조회 - 페이지
	@GetMapping("deptInfo")
	public String getDeptInfo(DeptInfoVO deptVO, Model model) {
		DeptInfoVO findDept = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo",findDept);
		return "dept/info";
	}
	
	//등록 - 페이지 : GET
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		return "dept/insert";
	}
	
	//등록 - 기능 : POST
	@PostMapping("deptInsert")
	public String deptInsert(DeptInfoVO deptVO) {
		deptService.insertDeptInfo(deptVO);
		return "redirect:deptList";
	}
	/*	redirect vs forward
		
		return "redirect: 경로" 사용자가 어떠한 경로로 요청했는지 알아야하는 경우
			  forward 서버 내에서 몇사람이 동작하든
	*/
	//수정 - 기능 : POST
	
	
	
	//삭제 - 기능 : POST
	
	
}
