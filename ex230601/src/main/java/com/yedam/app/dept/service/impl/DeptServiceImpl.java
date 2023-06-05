package com.yedam.app.dept.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptInfoMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptInfoVO;

@Service //누락금지 Impl로 끝나는 모든클래스는 이게 존재해야함.
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptInfoMapper deptMapper;
	
	@Override
	public List<DeptInfoVO> getAllDept() {
		return deptMapper.selectAllDept();
	}

	@Override
	public DeptInfoVO getDeptInfo(DeptInfoVO deptVO) {
		return deptMapper.selectOneDept(deptVO);
	}

	@Override
	public int insertDeptInfo(DeptInfoVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		System.out.println("id :" + deptVO.getDepartmentId());
		return result;
	}

	@Override
	public Map<String, Object> updateDeptList(List<DeptInfoVO> deptVO) {
		Boolean result = false;
		List<Integer> successList = new ArrayList<>();  
		int count = 0;
		
		for(DeptInfoVO deptInfo : deptVO) {
			int res = deptMapper.updateDeptInfo(deptInfo);
			if(res > 0) {
				// 정상적으로 수정이 되었을 경우
				count += 1;
				successList.add(deptInfo.getDepartmentId());
				System.out.println(successList);
			}
		}
		
		if(count > 0) {
			result =true;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("deptList", successList);
		
		return map;
	}

	@Override
	public int deletDeptList(List<DeptInfoVO> deptVO) {
		int count = 0;
		for(DeptInfoVO deptInfo : deptVO) {
			count += deptMapper.deleteDeptInfo(deptInfo.getDepartmentId());
		}
		return count;
	}
	

}
