package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptInfoVO;

public interface DeptInfoMapper {
	//전체조회
	public List<DeptInfoVO> selectAllDept();
	
	//단건조회
	public DeptInfoVO selectOneDept(DeptInfoVO deptVO);
	
	//등록
	public int insertDeptInfo(DeptInfoVO deptVO);
	
	//수정
	public int updatetDeptInfo(DeptInfoVO deptVO);
	
	//삭제
	public int deletDeptInfo(int deptNo);
	
}
