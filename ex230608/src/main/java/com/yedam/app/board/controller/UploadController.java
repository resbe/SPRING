package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@GetMapping("getUploadPath")
	@ResponseBody
	public String getUploadPath() {
		return uploadPath;
	}
}
