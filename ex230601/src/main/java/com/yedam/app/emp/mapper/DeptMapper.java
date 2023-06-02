package com.yedam.app.emp.mapper;

import java.util.List;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public List<DeptVO> deptList(DeptVO vo); //목록
	public int updateDept(DeptVO vo); //수정
	public int deleteDept(int departmentId); //삭제
	public int inserDept(DeptVO vo);//등록
	
}
