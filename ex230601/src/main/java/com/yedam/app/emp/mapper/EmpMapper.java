package com.yedam.app.emp.mapper;


import java.util.List;
import java.util.Map;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	public EmpVO selectOne(int empNo);
	public List<EmpVO> selectList(EmpVO vo);
	public int insertEmp(EmpVO vo);   //등록
	public int updateEmp(EmpVO vo);	  //수정
	public int deleteEmp(int empNo);  //삭제
	public int selectCount(EmpVO vo);
	public List<Map<String, Object>> selectJobs();
	public List<Map<String, Object>> selectDept();
}
