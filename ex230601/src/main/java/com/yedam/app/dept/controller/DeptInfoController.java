package com.yedam.app.dept.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.dept.service.DeptInfoVO;
import com.yedam.app.dept.service.DeptListVO;
import com.yedam.app.dept.service.DeptService;

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
	public String getDeptAllList(@RequestParam(required = false) String msg,Model model, HttpServletRequest request) {
		model.addAttribute("deptList", deptService.getAllDept());
		
		System.out.println("redirect :" + msg);
		
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			System.out.println("department_id : " + flashMap.get("departmentId"));
		}
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
	public String deptInsert(DeptInfoVO deptVO, RedirectAttributes rtt) {
		deptService.insertDeptInfo(deptVO);
		rtt.addFlashAttribute("departmentId", deptVO.getDepartmentId()); // 세션에 정보를 복사 세션을 이용해서 데이터를 옮길수 있다. 경로에 값이 붙지않는다. 보안성이 올라감.
		rtt.addAttribute("msg", "test"); // ?msg=test 경로가 붙음. 
		//	return "redirect:deptList?departmentId="+deptVO.getDepartmentId();
		return "redirect:deptList";
	}
	/*	redirect vs forward
		
		return "redirect: 경로" 사용자가 어떠한 경로로 요청했는지 알아야하는 경우
			  forward 서버
			  
		client 					-->(update)  			server
			   		  (redirect)<-- data+redirect=url
	*/
	//수정 - 기능 : POST
	
	
	
	//@RequestBody : JSON 포맷을 사용하는 경우
	//				 -> content-type : 'application/json'
	//@PostMapping("deptUpdate") 
	@ResponseBody
	public Map<String,Object> deptUpdate(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt ){
		return deptService.updateDeptList(deptVO);
	}
	
	@PostMapping("deptUpdate") 
	@ResponseBody
	public String deptUpdateText(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt ){
		System.out.println(deptVO);
		Map<String,Object> map = deptService.updateDeptList(deptVO);
		return "success";
	}
//	public String deptUpdate(@RequestBody List<DeptInfoVO> deptVO, RedirectAttributes rtt ) {
//		Map<String,Object> map = deptService.updateDeptList(deptVO);
//		rtt.addFlashAttribute("updateRes",map);
//		return "redirect:deptInfo?departmentId="+deptVO.get(0).getDepartmentId();	
//		
//	}
	
	
	
	//삭제 - 기능 : POST
	@PostMapping("deptDelete")
	public String deptDelte(DeptListVO list) {
		
		int result = deptService.deletDeptList(list.getDeptList());
		return "redirect:deptList?msg=" + result;
	}
	
}
