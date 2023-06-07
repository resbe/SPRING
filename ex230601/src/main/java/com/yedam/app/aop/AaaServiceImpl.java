package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("aService")
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("102");
	}

}
