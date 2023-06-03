package com.yedam.app.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.DeptVO;

public interface DeptMapper {
	public DeptVO selectDept(int departmentId);
	public List<DeptVO> deptList(DeptVO vo); //목록
	public int updateDept(DeptVO vo); //수정
	public int deleteDept(int departmentId); //삭제
	public int insertDept(DeptVO vo);//등록
	public List<Map<String, Object>> selectLocations();
	public List<Map<String, Object>> selectEmp();
	
}
