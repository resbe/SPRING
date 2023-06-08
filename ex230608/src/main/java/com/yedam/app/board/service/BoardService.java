package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	// 전체
	public List<BoardVO> getBoardList();
	// 단건
	public BoardVO getBoardInfo(BoardVO boardVO);
	//등록 - 등록 글 번호 반환 / 실패 = -1
	public int insertBoardInfo(BoardVO boardVO);
	//수정 - 수정 글 번호 반환 / 실패 = -1
	public int updateBoardInfo(BoardVO boardVO);
	//삭제 - 수정 글 번호 반환 / 실패 = -1
	public int deleteBoardInfo(BoardVO boardVO);
}
