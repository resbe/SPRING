package com.yedam.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;

@Service
@Primary
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> getBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public BoardVO getBoardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}

	@Override
	public int insertBoardInfo(BoardVO boardVO) {
		int result = boardMapper.insertBoard(boardVO);
		
		if(result > 0) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public int updateBoardInfo(BoardVO boardVO) {
		int result = boardMapper.updateBoard(boardVO);
		
		if(result > 0) {
			return boardVO.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public int deleteBoardInfo(int boardVO) {
		int result = boardMapper.deleteBoard(boardVO);
		
		if(result > 0) {
			return boardVO;
		}else {
			return -1;
		}
	}

}
