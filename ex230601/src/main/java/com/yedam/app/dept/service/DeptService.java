package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	// 전체조회
	public List<DeptInfoVO> getAllDept();
	
	// 단건조회
	public DeptInfoVO getDeptInfo(DeptInfoVO deptVO);
	
	// 등록
	public int insertDeptInfo(DeptInfoVO deptVO);
	
	// 수정
	public Map<String,Object> updateDeptList(List<DeptInfoVO> deptVO);
	
	// 삭제
	public int deletDeptList(List<DeptInfoVO> deptVO);
}
