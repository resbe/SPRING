package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	BoardVO boardVO;
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList" , list);
		
		return "board/boardList";
	}

	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO getBoard,Model model) {
		boardVO = boardService.getBoardInfo(getBoard);
		model.addAttribute("board", boardVO);
		return "board/boardInfo";
	}

	
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}

	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO getBoard) {
		int result = boardService.insertBoardInfo(getBoard);
		
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(int bno, Model model) {
		boardVO.setBno(bno);
		model.addAttribute("board", boardService.getBoardInfo(boardVO));
		return "board/boardUpdate";
	}

	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody
	public String boardUpdate(@RequestBody BoardVO getBoard) {	
		System.out.println(getBoard);
		int result = boardService.updateBoardInfo(getBoard);
		
		if(result >0) {
			return "success";
		}else {
			return "fail";
		}
	}

	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(BoardVO getBoard) {
		boardService.deleteBoardInfo(boardVO);
		return "redirect:boardList";
	}
}
