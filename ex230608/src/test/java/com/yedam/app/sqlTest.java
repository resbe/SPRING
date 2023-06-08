package com.yedam.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class sqlTest {
	@Autowired
	BoardMapper boardMapper;
	@Autowired
	BoardVO boardVO;
	
	//@Test
	public void getList() {
		System.out.println(boardMapper.selectBoardList());
	}
	
	//@Test
	public void getBoard() {
		boardVO.setBno(2);
		boardVO.setWriter("김성욱");
		System.out.println(boardMapper.selectBoardInfo(boardVO));
	}
	
	//@Test
	public void insert() {
		boardVO.setTitle("세번째");
		boardVO.setContents("세번째 글입니다");
		boardVO.setWriter("홍길동");
		System.out.println(boardMapper.insertBoard(boardVO));
	}
	
	@Test
	public void update() {
		boardVO.setBno(2);
		boardVO.setTitle("두번째(수정)");
		boardVO.setContents("두번째 글 수정본입니다");
		System.out.println(boardMapper.updateBoard(boardVO));
	}
	
	//@Test
	public void delete() {
		boardVO.setBno(3);
		boardMapper.deleteBoard(boardVO);
	}

}
