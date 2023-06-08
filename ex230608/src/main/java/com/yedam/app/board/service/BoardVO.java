package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BoardVO {
	private int bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate; // yyyy/mm/dd yyyy-mm-dd
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate;
	private String image;
	
}
