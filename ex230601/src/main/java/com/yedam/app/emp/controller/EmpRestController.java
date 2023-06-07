package com.yedam.app.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RestController
public class EmpRestController {
	@Autowired
	EmpMapper empMapper;
	
	//전체 조회
	@GetMapping("emps")
	public List<EmpVO> getEmpList(EmpVO empVO){
		return empMapper.selectList(empVO);
	}
	
	//단건 조회
	@GetMapping("emps/{employeeId}") //밑에 네임태그를 통해서 새로운 이름 지정가능 지정안할시 그냥 뒤에 변수명이 지칭됨.
	public EmpVO getEmpInfo(@PathVariable(name="employeeId") int employeeId) {
		return empMapper.selectOne(employeeId);
	} 
	
	//등록
	@PostMapping("emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empMapper.insertEmp(empVO);
		return empVO;
	}
	
	//수정
	@PutMapping("emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable String employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empMapper.updateEmp(empVO);
		return empVO;
	}
	
	//삭제
	@DeleteMapping("emps/{employeeId}")
	public Map<String, Object> deleteEmpInfo(@PathVariable int employeeId) {
		boolean success = false;
		int result = empMapper.deleteEmp(employeeId);
		if(result >0) {
			success = true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", success);
		map.put("employeeId", employeeId);
		
		return map;
	}
	
}
